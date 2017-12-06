package adventofcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day6Part2 {

	public static int[] reallocate(int[] arr) {

		int max = Integer.MIN_VALUE;
		int pos = 0;

		for (int i = 0; i < arr.length; i++) {
			int oldMax = max;
			max = Math.max(max, arr[i]);
			if (max > oldMax) {
				pos = i;
			}
		}

		int toRedistribute = arr[pos];
		arr[pos] = 0;

		while (toRedistribute-- > 0) {
			if (++pos >= arr.length) {
				pos = 0;
			}
			arr[pos]++;
		}

		return arr;
	}

	public static int countCycles(int[] arr) {
		int cycle = 0;
		int result = 0;
		Map<String, Integer> keys = new HashMap<>();

		do {
			arr = reallocate(arr);
			cycle++;
			String key = Arrays.toString(arr);
			if (keys.containsKey(key)) {
				result = cycle - keys.get(key);
			} else {
				keys.put(key, cycle);
			}
		} while (result == 0);

		return result;
	}

	public static void main(String args[]) {
//		int arr[] = { 5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6 };

//		System.out.println(countCycles(arr));

		speedTest();
	}

	public static void speedTest() {
		int arr[] = { 14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4 };

		final long startTime = System.nanoTime();
		int result = countCycles(arr);
		final long endTime = System.nanoTime() - startTime;

		System.out.println(result + " cycles");
		System.out.println(endTime / 1000.0 / 1000.0 + " ms");
	}
}
