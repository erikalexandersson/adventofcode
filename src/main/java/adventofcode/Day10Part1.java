package adventofcode;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Day10Part1 {

	public static void main(String args[]) throws URISyntaxException {
		Integer[] arr = new Integer[256];
		Integer[] lengths = { 106, 16, 254, 226, 55, 2, 1, 166, 177, 247, 93, 0, 255, 228, 60, 36 };

		arr = run(arr, lengths);

		System.out.println(arr[0] * arr[1]);
	}

	public static Integer[] run(Integer[] arr, Integer[] lengths) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		int position = 0;
		int skip = 0;
		for (int i = 0; i < lengths.length; i++) {
			int length = lengths[i];
			arr = pinchAndTwist(arr, position, length);
			position += length + skip;
			skip++;
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
