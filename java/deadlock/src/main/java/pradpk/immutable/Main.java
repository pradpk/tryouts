package pradpk.immutable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] a) throws Exception {
		Scanner scan = new Scanner(
				new File("C:/work/poc/clone/tryouts/java/deadlock/src/main/java/pradpk/immutable/content.txt"));
		List<Integer> stacks = new ArrayList<Integer>();
		int index = 0;
		int max = 0;
		while (scan.hasNext()) {
			String content = scan.nextLine();
			if (null != content) {
				content = content.trim();
				if (index == 0) {
					index++;
					continue;
				} else {
					if (content.startsWith("1")) {
						String[] vals = content.split(" ");
						if (vals[0].equals("1")) {
							if(Integer.valueOf(vals[1]) > max) {
                                max = Integer.valueOf(vals[1]);
                            }
							stacks.add(Integer.valueOf(vals[1]));
						}
					} else {
						if (content.equals("2")) {
							int temp = stacks.remove(stacks.size() - 1);
							if (temp == max) {								
								max = 0;								
								for (Integer i : stacks) {
									if (i > max) {
										max = i;
									}
								}
								//System.out.println("new max :" + max);
							} 

						} else if (content.equals("3")) {
							System.out.println(max);
						}
					}
					//System.out.println(stacks);
					index++;
				}
			}

		}

		scan.close();

	}

}
