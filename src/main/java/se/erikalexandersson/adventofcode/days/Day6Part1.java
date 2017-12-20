package se.erikalexandersson.adventofcode.days;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day6Part1 {

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

	public static int redistribute(int[] arr) {
		int cycle = 0;

		Set<String> keys = new HashSet<>();

		boolean unique = true;
		do {
			arr = reallocate(arr);
			cycle++;
			unique = keys.add(Arrays.toString(arr));
		} while (unique);

		return cycle;
	}

	public static void main(String args[]) {
		// int arr[] = { 5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6 };

		// System.out.println(redistribute(arr));

		speedTest();
	}

	public static void speedTest() {
		int arr[] = { 14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4 };

		final long startTime = System.nanoTime();
		int result = redistribute(arr);
		final long endTime = System.nanoTime() - startTime;

		System.out.println(result + " cycles");
		System.out.println(endTime / 1000.0 / 1000.0 + " ms");
	}

}
