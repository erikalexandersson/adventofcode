package adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day19Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(route(Paths.get(ClassLoader.getSystemResource("Day19Input.txt").toURI())));
	}

	private enum Direction {
		SOUTH, NORTH, EAST, WEST;
	}

	public static String route(Path path) {

		String passed = "";
		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			lines = stream.collect(Collectors.toList());
		} catch (IOException e) {
		}

		char[][] arr = new char[lines.size()][];

		for (int i = 0; i < lines.size(); i++) {
			arr[i] = lines.get(i).toCharArray();
		}

		int x = 0;
		int y = 0;
		Direction currentDirection = Direction.SOUTH;

		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == '|') {
				x = i;
				break;
			}
		}

		boolean route = true;
		while (route) {
			char currentPos = arr[y][x];
			switch (currentPos) {
			case ' ':
				route = false;
				break;
			case '|':
			case '-':
				break;
			case '+':
				switch (currentDirection) {
				case WEST:
				case EAST:
					if (y > 0 && arr[y - 1][x] != ' ') {
						currentDirection = Direction.NORTH;
					} else {
						currentDirection = Direction.SOUTH;
					}
					break;
				case SOUTH:
				case NORTH:
					if (x > 0 && arr[y][x - 1] != ' ') {
						currentDirection = Direction.WEST;
					} else {
						currentDirection = Direction.EAST;
					}
					break;
				default:
					break;
				}
				break;
			default:
				passed += currentPos;
				break;
			}
			x = currentDirection == Direction.WEST ? x - 1 : (currentDirection == Direction.EAST ? x + 1 : x);
			y = currentDirection == Direction.SOUTH ? y + 1 : (currentDirection == Direction.NORTH ? y - 1 : y);
		}

		return passed;
	}

}
