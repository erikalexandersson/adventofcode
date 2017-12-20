package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Acceleration;
import se.erikalexandersson.adventofcode.helpers.Point;
import se.erikalexandersson.adventofcode.helpers.Triplet;
import se.erikalexandersson.adventofcode.helpers.Velocity;

public class Day20Part1 {

	public static void main(String args[]) throws URISyntaxException {
		List<Point> points = new ArrayList<>();

		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("Day20Input.txt").toURI()))) {
			lines = stream.collect(Collectors.toList());
		} catch (IOException e) {
		}

		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			Triplet position = new Triplet(line.split("=")[1]);
			Triplet velocityTriplet = new Triplet(line.split("=")[2]);
			Triplet accelerationTriplet = new Triplet(line.split("=")[3]);

			Velocity velocity = new Velocity(velocityTriplet.x, velocityTriplet.y, velocityTriplet.z);
			Acceleration acceleration = new Acceleration(accelerationTriplet.x, accelerationTriplet.y,
					accelerationTriplet.z);

			points.add(new Point(i, position.x, position.y, position.z, velocity, acceleration));
		}

		System.out.println(closestInLongTerm(points));
	}

	public static int closestInLongTerm(List<Point> points) {
		for (int i = 0; i < 1000; i++) {
			points.forEach(point -> point.update());
		}

		int min = Integer.MAX_VALUE;
		int currentMin = 0;
		for (int i = 0; i < points.size(); i++) {
			int distance = points.get(i).getDistanceFromOrigin();
			min = Math.min(min, distance);
			if (min == distance) {
				currentMin = i;
			}
		}

		return currentMin;
	}

}
