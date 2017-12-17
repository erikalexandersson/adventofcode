package adventofcode;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day17Part1 {

	public static void main(String args[]) throws URISyntaxException {
		List<Integer> list = new ArrayList<>(2018);
		list.add(0);
		int pos = spins(list, 0, 324, 2017);
		System.out.println(list.get(pos + 1));
	}

	public static int spins(List<Integer> list, int startPos, int steps, int spins) {
		long startTime = System.nanoTime();

		int endPos = startPos;
		for (int i = 1; i <= spins; i++) {
			if (i % 1000000 == 0) {
				System.out.println(i);
				final long endTime = System.nanoTime() - startTime;
				System.out.println(endTime / 1000.0 / 1000.0 / 1000.0 + " s");
				startTime = System.nanoTime();
			}
			endPos = spin(list, endPos, steps, i);
		}
		return endPos;
	}

	public static int spin(List<Integer> list, int startPos, int steps, int currentValue) {
		int endPos = ((startPos + steps) % currentValue) + 1;
		list.add(endPos, currentValue);
		return endPos;
	}

}
