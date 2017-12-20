package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day9Part2 {

	public static void main(String args[]) throws URISyntaxException {
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("Day9Input.txt").toURI()))) {
			stream.forEach(line -> {
				System.out.println(countGarbage(line, 0, false, false));
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static int countGarbage(String string, int position, boolean inGarbage, boolean ignore) {

		boolean stillInGarbage = inGarbage;
		boolean ignoreNext = false;
		boolean validGarbage = false;

		char currentChar = string.charAt(position);

		if (!ignore) {
			if (inGarbage) {
				if (currentChar == '>') {
					stillInGarbage = false;
				} else if (currentChar == '!') {
					ignoreNext = true;
				} else {
					validGarbage = true;
				}
			} else {
				switch (currentChar) {
				case '<':
					stillInGarbage = true;
					break;
				case '!':
					ignoreNext = true;
					break;

				default:
					validGarbage = true;
					break;
				}
			}
		} else {
		}

		if (position == string.length() - 1) {
			return 0;
		} else {
			if (stillInGarbage && validGarbage) {
				return 1 + countGarbage(string, position + 1, stillInGarbage, ignoreNext);
			} else {
				return countGarbage(string, position + 1, stillInGarbage, ignoreNext);
			}
		}
	}
}
