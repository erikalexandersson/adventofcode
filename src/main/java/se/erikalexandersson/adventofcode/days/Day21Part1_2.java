package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day21Part1_2 {

	private Map<String, String> book;

	public static void main(String[] args) throws URISyntaxException {
		Day21Part1_2 day21part1 = new Day21Part1_2();
		day21part1.readManual(Paths.get(ClassLoader.getSystemResource("Day21Input.txt").toURI()));
		char[][] pattern = { { '.', '#', '.' }, { '.', '.', '#' }, { '#', '#', '#' } };
		System.out.println(day21part1.onAfterIterations(pattern, 5));
		char[][] pattern2 = { { '.', '#', '.' }, { '.', '.', '#' }, { '#', '#', '#' } };
		System.out.println(day21part1.onAfterIterations(pattern2, 18));
	}

	public char[][] getMatch(char[][] pattern) {
		String input = squareToString(pattern);
		int rotations = 0;
		while (true) {
			if (book.containsKey(input)) {
				return stringToSquare(book.get(input));
			}
			if (++rotations % 4 == 0) {
				pattern = flipVertical(pattern);
			}
			pattern = rotateClockwise(pattern);
			input = squareToString(pattern);
		}
	}

	private char[][] stringToSquare(String string) {
		String[] lines = string.split("/");
		int size = lines.length;
		char[][] square = new char[size][size];

		for (int i = 0; i < lines.length; i++) {
			square[i] = lines[i].toCharArray();
		}
		return square;
	}

	private String squareToString(char[][] pattern) {
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < pattern.length; i++) {
			String line = new String(pattern[i]);
			lines.add(line);
		}
		return lines.stream().collect(Collectors.joining("/"));
	}

	public void readManual(Path path) {
		book = new HashMap<>();

		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			lines = stream.collect(Collectors.toList());
		} catch (IOException e) {
		}

		for (String line : lines) {
			String input = line.split(" => ")[0];
			String output = line.split(" => ")[1];
			book.put(input, output);
		}
	}

	public static char[][] rotateClockwise(char[][] input) {
		char[][] output = new char[input.length][input.length];

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				output[i][j] = input[input.length - j - 1][i];
			}
		}

		return output;
	}

	public static char[][] flipVertical(char[][] input) {
		char[][] output = new char[input.length][input.length];

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				output[i][j] = input[i][input.length - j - 1];
			}
		}

		return output;
	}

	public char[][] next(char[][] pattern) {
		if (pattern.length % 2 == 0) {
			char[][] output = new char[(int) (1.5 * pattern.length)][(int) (1.5 * pattern.length)];
			for (int i = 0; i < pattern.length; i += 2) {
				for (int j = 0; j < pattern.length; j += 2) {
					char[][] subPattern = new char[2][2];
					subPattern[0][0] = pattern[i][j];
					subPattern[0][1] = pattern[i][j + 1];
					subPattern[1][0] = pattern[i + 1][j];
					subPattern[1][1] = pattern[i + 1][j + 1];
					char[][] nextPattern = getMatch(subPattern);
					for (int k = 0; k < nextPattern.length; k++) {
						for (int l = 0; l < nextPattern.length; l++) {
							int newPosX = (i / 2) * 3 + k;
							int newPosY = (j / 2) * 3 + l;
							output[newPosX][newPosY] = nextPattern[k][l];
						}
					}
				}
			}
			return output;
		} else if (pattern.length % 3 == 0) {
			char[][] output = new char[(int) (4 * pattern.length / 3)][(int) (4 * pattern.length / 3)];
			for (int i = 0; i < pattern.length; i += 3) {
				for (int j = 0; j < pattern.length; j += 3) {
					char[][] subPattern = new char[3][3];
					subPattern[0][0] = pattern[i][j];
					subPattern[0][1] = pattern[i][j + 1];
					subPattern[0][2] = pattern[i][j + 2];
					subPattern[1][0] = pattern[i + 1][j];
					subPattern[1][1] = pattern[i + 1][j + 1];
					subPattern[1][2] = pattern[i + 1][j + 2];
					subPattern[2][0] = pattern[i + 2][j];
					subPattern[2][1] = pattern[i + 2][j + 1];
					subPattern[2][2] = pattern[i + 2][j + 2];
					char[][] nextPattern = getMatch(subPattern);
					for (int k = 0; k < nextPattern.length; k++) {
						for (int l = 0; l < nextPattern.length; l++) {
							int newPosX = (i / 3) * 4 + k;
							int newPosY = (j / 3) * 4 + l;
							output[newPosX][newPosY] = nextPattern[k][l];
						}
					}
				}
			}
			return output;
		}
		return pattern;
	}

	public int onAfterIterations(char[][] pattern, int iterations) {
		while (iterations-- > 0) {
			pattern = next(pattern);
		}
		int count = 0;
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern.length; j++) {
				if (pattern[i][j] == '#') {
					count++;
				}
			}

		}
		return count;
	}

}
