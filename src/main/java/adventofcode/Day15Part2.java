package adventofcode;

import java.net.URISyntaxException;

public class Day15Part2 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(judge(516, 190));
	}

	public static long nextValueGeneratorA(long value) {
		long nextValue = value;
		while (true) {
			nextValue = (nextValue * 16807) % 2147483647;
			if (nextValue % 4 == 0) {
				break;
			}
		}
		return nextValue;
	}

	public static long nextValueGeneratorB(long value) {
		long nextValue = value;
		while (true) {
			nextValue = (nextValue * 48271) % 2147483647;
			if (nextValue % 8 == 0) {
				break;
			}
		}
		return nextValue;
	}

	public static boolean match(long genA, long genB) {
		long lowA = genA & 0xFFFFL;
		long lowB = genB & 0xFFFFL;
		return lowA == lowB;
	}

	public static int judge(int startA, int startB) {
		int matches = 0;
		long currentA = startA;
		long currentB = startB;
		for (long i = 0; i < 5000000; i++) {
			currentA = nextValueGeneratorA(currentA);
			currentB = nextValueGeneratorB(currentB);
			if (match(currentA, currentB)) {
				matches++;
			}
		}
		return matches;
	}

}
