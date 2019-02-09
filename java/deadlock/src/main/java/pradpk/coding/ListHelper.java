package pradpk.coding;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListHelper {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		List<String> values = map.values().stream().collect(Collectors.toList());
	}

}
