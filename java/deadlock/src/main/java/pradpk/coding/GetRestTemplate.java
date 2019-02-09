package pradpk.coding;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamResult;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GetRestTemplate {

	public static void main(String[] a) {
		RestTemplate restTemplate = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(DmdRequest.class, DmdResponse.class);
		Map<String, Boolean> marshalProps = new HashMap<String, Boolean>();
		marshalProps.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setMarshallerProperties(marshalProps);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_XML);
		httpHeaders.set("isAuthorization", "false");
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_XML));
		httpHeaders.set("", "");

		StringWriter writer = new StringWriter();
		marshaller.marshal(createRequest(), new StreamResult(writer));
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new GetRestTemplateInterceptor());
		restTemplate.setInterceptors(interceptors);
		
		String uri = "https://dmdtest2.ebiz.verizon.com/dmd/DMDMultiDeviceFirmwareLookup?";
		uri = uri + "xmlReq=" + writer.toString();
		
		String response = (String)restTemplate.getForObject(uri, String.class);
	}

	private static DmdRequest createRequest() {
		DmdRequest dmdRequest = new DmdRequest();
		dmdRequest.setServiceName("firmwareInfo");
		DmdRequest.RequestHeader dmdHeader = new DmdRequest.RequestHeader();
		dmdHeader.setClientId("ITAGW");
		dmdHeader.setAppType("ITAGW");
		dmdRequest.setRequestHeader(dmdHeader);

		List<String> deviceIds = Arrays.asList("990000924773990", "990000924102380");

		DmdRequest.RequestBody.DeviceIDList deviceIDList = new DmdRequest.RequestBody.DeviceIDList();
		deviceIDList.getDeviceId().addAll(deviceIds);

		DmdRequest.RequestBody body = new DmdRequest.RequestBody();
		body.setDeviceIDList(deviceIDList);
		dmdRequest.setRequestBody(body);

		return dmdRequest;
	}

}

@Getter
@Setter
@XmlRootElement(name="dmd")
class DmdRequest {

	private String serviceName;
	private RequestHeader requestHeader;
	private RequestBody requestBody;

	@Getter
	@Setter
	@NoArgsConstructor
	static class RequestHeader {
		private String clientId;
		private String appType;
	}

	@Getter
	@Setter
	static class RequestBody {

		private DeviceIDList deviceIDList;

		@Getter
		@Setter
		static class DeviceIDList {
			private List<String> deviceId = new ArrayList<>();
		}
	}

}

@Getter
@Setter
@XmlRootElement
class DmdResponse {

}

class GetRestTemplateInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		log(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		logResponse(response);
		return response;
	}

	private void log(HttpRequest request, byte[] body) throws UnsupportedEncodingException {
		System.out.println("URI : " + request.getURI() + "; Method : " + request.getMethod() + "; Request header: {"
				+ request.getHeaders() + "}");
		System.out.println("Request body: " + new String(body, "UTF-8"));
	}

	private void logResponse(ClientHttpResponse response) throws IOException {
		System.out.println("Status : " + response.getStatusCode() + "; Status text :" + response.getStatusText()
				+ "; response headers : {" + response.getHeaders() + "}");
		while(null == response.getBody()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Response body: " + StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
	}

}
