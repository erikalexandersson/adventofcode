package adventofcode;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Part2 {

	public static void main(String args[]) throws URISyntaxException {
		String input = "106,16,254,226,55,2,1,166,177,247,93,0,255,228,60,36";

		System.out.println(knotHash(input));
	}

	public static String knotHash(String input) {
		Integer[] arr = new Integer[256];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		List<Integer> list = input.chars().boxed().collect(Collectors.toList());
		list.add(17);
		list.add(31);
		list.add(73);
		list.add(47);
		list.add(23);

		Integer[] lengths = list.toArray(new Integer[0]);

		Integer[] output = run(arr, lengths, 64);

		String result = "";
		for (int i = 0; i < 16; i++) {
			int val = output[i * 16];
			for (int j = 1; j < 16; j++) {
				val ^= output[i * 16 + j];
			}
			result += String.format("%02x", val);
		}

		return result;
	}

	public static Integer[] run(Integer[] arr, Integer[] lengths, int rounds) {
		int position = 0;
		int skip = 0;
		while (rounds-- > 0) {
			for (int i = 0; i < lengths.length; i++) {
				int length = lengths[i];
				arr = pinchAndTwist(arr, position, length);
				position += length + skip;
				skip++;
			}
		}
		return arr;
	}

	public static Integer[] pinchAndTwist(Integer arr[], int position, int length) {
		CircularList<Integer> list = new CircularList<Integer>(Arrays.asList(arr));

		int steps = length / 2;
		for (int i = 0; i < steps; i++) {
			int pos1 = position + i;
			int pos2 = position + length - i - 1;
			int val1 = list.get(pos1);
			int val2 = list.get(pos2);
			list.set(pos1, val2);
			list.set(pos2, val1);
		}

		return list.toArray(new Integer[0]);
	}

	@SuppressWarnings("serial")
	private static class CircularList<E> extends ArrayList<E> {

		public CircularList(Collection<? extends E> c) {
			super(c);
		}

		@Override
		public E get(int index) {
			return super.get(index % size());
		}

		@Override
		public E set(int index, E element) {
			return super.set(index % size(), element);
		}
	}

}
