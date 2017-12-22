package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Direction;

public class Day22Part1 {

	public static void main(String args[]) throws URISyntaxException {

		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("Day22Input.txt").toURI()))) {
			lines = stream.collect(Collectors.toList());
		} catch (IOException e) {
		}

		Map<String, String> grid = new HashMap<>();

		for (int y = 0; y < lines.size(); y++) {
			String line = lines.get(y);
			for (int x = 0; x < line.length(); x++) {
				grid.put(String.format("%s,%s", x, y), "" + line.charAt(x));
			}
		}

		int startX = lines.get(0).length() / 2;
		int startY = lines.size() / 2;
		String startPos = String.format("%s,%s", startX, startY);

		System.out.println(burst(grid, startPos, 10000));
	}

	public static String getNode(Map<String, String> grid, String node) {
		if (!grid.containsKey(node)) {
			grid.put(node, ".");
		}
		return grid.get(node);
	}

	public static int burst(Map<String, String> grid, String currentPos, int bursts) {
		int numInfected = 0;

		Direction currentDirection = Direction.NORTH;
		while (bursts-- > 0) {
			if (getNode(grid, currentPos).equals("#")) {
				currentDirection = currentDirection.turnRight();
				setNode(grid, currentPos, ".");
			} else {
				currentDirection = currentDirection.turnLeft();
				setNode(grid, currentPos, "#");
				numInfected++;
			}

			currentPos = move(currentPos, currentDirection);
		}

		return numInfected;
	}

	private static String move(String currentPos, Direction currentDirection) {
		int x = Integer.valueOf(currentPos.split(",")[0]);
		int y = Integer.valueOf(currentPos.split(",")[1]);

		switch (currentDirection) {
		case NORTH:
			y--;
			break;
		case SOUTH:
			y++;
			break;
		case WEST:
			x--;
			break;
		case EAST:
			x++;
			break;
		default:
			break;
		}

		return String.format("%s,%s", x, y);
	}

	private static void setNode(Map<String, String> grid, String currentPos, String nodeValue) {
		grid.put(currentPos, nodeValue);
	}
}
