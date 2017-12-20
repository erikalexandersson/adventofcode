package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day17Part2 {

	public static void main(String args[]) throws URISyntaxException {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		Day17Part2.spins(list, 0, 324, 50000000);
		System.out.println(list.get(1));
	}

	public static void spins(List<Integer> list, int startPos, int steps, int spins) {
		int endPos = startPos;
		for (int i = 1; i <= spins; i++) {
			endPos = spin(list, endPos, steps, i);
		}
	}

	public static int spin(List<Integer> list, int startPos, int steps, int currentValue) {
		int endPos = ((startPos + steps) % currentValue) + 1;
		if (endPos == 1) {
			list.add(endPos, currentValue);
		}
		return endPos;
	}

}
