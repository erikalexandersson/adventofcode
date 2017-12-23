package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;

public class Day23Part2 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(cheat());
	}

	private static int cheat() {
		int b = 84 * 100 + 100000;
		int c = b + 17000;
		long g = 0;
		int h = 0;

		while (true) {
			boolean found = false;
			int d = 2;
			do {
				int e = 2;

				do {
					g = ((long) d * (long) e) - b;
					if (g == 0) {
						found = true;
						break;
					}
					e++;
					g = e - b;
				} while (g != 0);

				if (found) {
					break;
				}

				d++;
				g = d - b;
			} while (g != 0);

			if (found) {
				h++;
			}
			g = b - c;
			if (g == 0) {
				return h;
			}
			b += 17;
		}
	}

}
