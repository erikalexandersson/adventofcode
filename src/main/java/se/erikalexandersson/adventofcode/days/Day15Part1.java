package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;

public class Day15Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(judge(516, 190));
	}

	public static long nextValueGeneratorA(long value) {
		return (value * 16807) % 2147483647;
	}

	public static long nextValueGeneratorB(long value) {
		return (value * 48271) % 2147483647;
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
		for (long i = 0; i < 40000000; i++) {
			currentA = nextValueGeneratorA(currentA);
			currentB = nextValueGeneratorB(currentB);
			if (match(currentA, currentB)) {
				matches++;
			}
		}
		return matches;
	}

}
