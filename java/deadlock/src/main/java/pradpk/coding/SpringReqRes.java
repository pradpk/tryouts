package pradpk.coding;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

public class SpringReqRes {

	public static void main(String[] a) {
		RestTemplate restTemplate = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

		Jaxb2Marshaller mcsMarshaller = new Jaxb2Marshaller();
		mcsMarshaller.setClassesToBeBound(ReqGetSubscriberProfile.class, RespGetSubscriberProfile.class);
		Map<String, Boolean> marshalProps = new HashMap<String, Boolean>();
		marshalProps.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mcsMarshaller.setMarshallerProperties(marshalProps);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MarshallingHttpMessageConverter httpMessageConverter = new MarshallingHttpMessageConverter();
		httpMessageConverter.setMarshaller(mcsMarshaller);
		httpMessageConverter.setUnmarshaller(mcsMarshaller);
		httpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_XML));
		messageConverters.add(httpMessageConverter);
		restTemplate.setMessageConverters(messageConverters);

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new LogReqResInterceptor());
		restTemplate.setInterceptors(interceptors);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_XML);
		httpHeaders.set("isAuthorization", "false");
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

		HttpEntity<ReqGetSubscriberProfile> reqEntity = new HttpEntity<ReqGetSubscriberProfile>(createRequest(),
				httpHeaders);
		RespGetSubscriberProfile respGetSubscriberProfile = restTemplate.postForObject(
				"http://mcscmpt2.ebiz.verizon.com:7164/apex/ApexServlet", reqEntity, RespGetSubscriberProfile.class);

	}

	private static ReqGetSubscriberProfile createRequest() {
		ReqGetSubscriberProfile reqProfile = new ReqGetSubscriberProfile();
		reqProfile.setChannelID("125");
		reqProfile.setCallerVendorID("200438");
		reqProfile.setCustomerId("242172466");
		reqProfile.setAccountNumber("1");
		reqProfile.setStartIndex(1);
		reqProfile.setEndIndex(100);
		return reqProfile;
	}

}

@Setter
@Getter
@XmlRootElement(name = "ReqGetSubscriberProfile")
class ReqGetSubscriberProfile {

	private String channelID;
	private String callerVendorID;
	private String customerId;
	private String accountNumber;
	private long startIndex;
	private long endIndex;
}

@Setter
@Getter
@XmlRootElement(name = "RespGetSubscriberProfile")
class RespGetSubscriberProfile {

	private String channelID;
	private String callerVendorID;
	private String customerId;
	private String accountNumber;
	private long startIndex;
	private long endIndex;
}

class LogReqResInterceptor implements ClientHttpRequestInterceptor {

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
