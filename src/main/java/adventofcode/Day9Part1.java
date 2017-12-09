package adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day9Part1 {

	public static void main(String args[]) throws URISyntaxException {
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("Day9Input.txt").toURI()))) {
			stream.forEach(line -> {
				System.out.println(score(line, 0, 0, false, false));
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static int score(String string, int position, int depth, boolean inGarbage, boolean ignore) {

		int score = depth;

		int newDepth = depth;

		boolean stillInGarbage = inGarbage;
		boolean ignoreNext = false;
		boolean endGroup = false;

		char currentChar = string.charAt(position);

		if (!ignore) {

			if (inGarbage) {
				if (currentChar == '>') {
					stillInGarbage = false;
				} else if (currentChar == '!') {
					ignoreNext = true;
				}
			} else {
				switch (currentChar) {
				case '{':
					newDepth++;
					break;
				case '}':
					endGroup = true;
					newDepth--;
					break;
				case '<':
					stillInGarbage = true;
					break;
				case '!':
					ignoreNext = true;
					break;

				default:
					break;
				}
			}
		} else {
		}

		if (position == string.length() - 1) {
			return score;
		} else {
			if (endGroup) {
				return score + score(string, position + 1, newDepth, stillInGarbage, ignoreNext);
			} else {
				return score(string, position + 1, newDepth, stillInGarbage, ignoreNext);
			}
		}
	}
}
