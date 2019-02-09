package pradpk.coding;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Chunking {
	
	public static void main(String[] a) {
		final List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        System.out.println(partition(list, 2));  // [[1, 2], [3, 4], [5, 6], [7]]
        System.out.println(partition(list, 3));  // [[1, 2, 3], [4, 5, 6], [7]]
	}
	
	private static  <T> Collection<List<T>> partition(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        Integer i = new Integer(0);

        return list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values();
    }
	

}
