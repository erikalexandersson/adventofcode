package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Day3Part1 {

	private static List<Integer> fromList;

	public static int countSteps(int square) {
		int numSteps = 0;

		int ring = 0;

		fromList = new ArrayList<>();

		int numElementsAtRingN = 1;
		int numElementsSoFar = 1;
		int from = 1;
		fromList.add(from);
		while (square > numElementsSoFar) {
			ring++;
			from = numElementsSoFar + 1;
			fromList.add(from);
			numElementsAtRingN = (((2 * ring) - 1) * 4) + 4;
			numElementsSoFar += numElementsAtRingN;
		}

		if (ring == 0) {
			numSteps = 0;
		} else {
			int x = getX(square, ring, fromList.get(ring));
			int y = getY(square, ring, fromList.get(ring));
			numSteps = Math.abs(x) + Math.abs(y);
		}

		return numSteps;
	}

	private static int getX(int square, int ring, int from) {
		if (ring == 0) {
			return 0;
		} else {
			if (from == square) {
				return getX(square - 1, ring - 1, fromList.get(ring - 1)) + 1;
			} else {
				int positionInRing = square - from;
				int side = (2 * ring) - 1;
				int div = Math.floorDiv(positionInRing, side + 1) + 1;

				if (div == 1) {
					return getX(square - 1, ring, from);
				} else if (div == 2) {
					return getX(square - 1, ring, from) - 1;
				} else if (div == 3) {
					return getX(square - 1, ring, from);
				} else {
					return getX(square - 1, ring, from) + 1;
				}
			}
		}
	}

	private static int getY(int square, int ring, int from) {
		if (ring == 0) {
			return 0;
		} else {
			if (from == square) {
				return getY(square - 1, ring - 1, fromList.get(ring - 1));
			} else {
				int positionInRing = square - from;
				int side = (2 * ring) - 1;
				int div = Math.floorDiv(positionInRing, side + 1) + 1;

				if (div == 1) {
					return getY(square - 1, ring, from) + 1;
				} else if (div == 2) {
					return getY(square - 1, ring, from);
				} else if (div == 3) {
					return getY(square - 1, ring, from) - 1;
				} else {
					return getY(square - 1, ring, from);
				}
			}
		}
	}

	public static void main(String args[]) {
		int square = 361527;

		System.out.println(countSteps(square));
	}
}
