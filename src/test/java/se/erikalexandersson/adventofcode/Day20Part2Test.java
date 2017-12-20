package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day20Part2;
import se.erikalexandersson.adventofcode.helpers.Acceleration;
import se.erikalexandersson.adventofcode.helpers.Point;
import se.erikalexandersson.adventofcode.helpers.Velocity;

public class Day20Part2Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws URISyntaxException {
		Point p1 = new Point(0, -6, 0, 0, new Velocity(3, 0, 0), new Acceleration(0, 0, 0));
		Point p2 = new Point(1, -4, 0, 0, new Velocity(2, 0, 0), new Acceleration(0, 0, 0));
		Point p3 = new Point(2, -2, 0, 0, new Velocity(1, 0, 0), new Acceleration(0, 0, 0));
		Point p4 = new Point(3, 3, 0, 0, new Velocity(-1, 0, 0), new Acceleration(0, 0, 0));

		List<Point> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);

		int actual = Day20Part2.particlesLeft(points);

		assertEquals(1, actual);
	}

}
