package adventofcode;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day14Part2 {

	static Integer[][] arr = new Integer[128][128];

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(countRegions("jxqlasbh"));
	}

	public static int countRegions(String str) {

		Map<String, Integer> hex = new HashMap<>();
		hex.put("0", 0);
		hex.put("1", 1);
		hex.put("2", 2);
		hex.put("3", 3);
		hex.put("4", 4);
		hex.put("5", 5);
		hex.put("6", 6);
		hex.put("7", 7);
		hex.put("8", 8);
		hex.put("9", 9);
		hex.put("a", 10);
		hex.put("b", 11);
		hex.put("c", 12);
		hex.put("d", 13);
		hex.put("e", 14);
		hex.put("f", 15);

		for (int i = 0; i < 128; i++) {
			String hash = Day10Part2.knotHash(str + "-" + i);

			for (int j = 0; j < 32; j++) {
				String c = "" + hash.charAt(j);
				String bits = Integer.toBinaryString(hex.get(c));
				int pad = (4 - bits.length());

				if (pad > 0) {
					bits = String.format("%0" + pad + "d%s", 0, bits);
				}
				arr[i][4 * j] = Integer.valueOf(bits.charAt(0));
				arr[i][4 * j + 1] = Integer.valueOf(bits.charAt(1));
				arr[i][4 * j + 2] = Integer.valueOf(bits.charAt(2));
				arr[i][4 * j + 3] = Integer.valueOf(bits.charAt(3));
			}
		}

		int currentGroup = 1;
		Set<String> visited = new HashSet<>();

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (arr[i][j] == '1') {
					markGroups(i, j, currentGroup++, visited);
				} else {
					String key = String.valueOf(i) + ":" + String.valueOf(j);
					visited.add(key);
				}
			}
		}

		return currentGroup - 1;
	}

	private static void markGroups(int row, int col, int group, Set<String> visited) {
		if (row >= 0 && row < 128 && col >= 0 && col < 128) {
			String key = String.valueOf(row) + ":" + String.valueOf(col);
			if (!visited.contains(key)) {
				visited.add(key);
				if (arr[row][col] == '1') {
					arr[row][col] = group;
					markGroups(row + 1, col, group, visited);
					markGroups(row - 1, col, group, visited);
					markGroups(row, col + 1, group, visited);
					markGroups(row, col - 1, group, visited);
				}
			}
		}
	}

}
