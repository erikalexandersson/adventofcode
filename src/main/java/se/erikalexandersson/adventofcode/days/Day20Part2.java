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

public class Day20Part2 {

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

		System.out.println(particlesLeft(points));
	}

	public static int particlesLeft(List<Point> points) {
		for (int i = 0; i < 1000; i++) {
			points.forEach(point -> point.update());

			List<Point> allPoints = new ArrayList<>(points);
			points = points.stream().filter(point -> !collision(allPoints, point)).collect(Collectors.toList());
		}

		return points.size();
	}

	public static boolean collision(List<Point> points, Point point) {
		boolean collision = false;
		for (Point p : points) {
			if (p.equals(point)) {
				continue;
			}
			if ((p.getX() == point.getX()) && (p.getY() == point.getY()) && (p.getZ() == point.getZ())) {
				collision = true;
				break;
			}
		}
		return collision;
	}
}
