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

import se.erikalexandersson.adventofcode.days.Day20Part1;
import se.erikalexandersson.adventofcode.helpers.Acceleration;
import se.erikalexandersson.adventofcode.helpers.Point;
import se.erikalexandersson.adventofcode.helpers.Velocity;

public class Day20Part1Test {

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
	public void test1() throws URISyntaxException {
		Point p = new Point(0, 3, 0, 0, new Velocity(2, 0, 0), new Acceleration(-1, 0, 0));

		p.update();

		assertEquals(4, p.getX());
		assertEquals(1, p.getVelocity().getVx());

		p.update();

		assertEquals(4, p.getX());
		assertEquals(0, p.getVelocity().getVx());

		p.update();

		assertEquals(3, p.getX());
		assertEquals(-1, p.getVelocity().getVx());

		assertEquals(3, p.getDistanceFromOrigin());
	}

	@Test
	public void test2() throws URISyntaxException {
		Point p = new Point(0, 4, 0, 0, new Velocity(0, 0, 0), new Acceleration(-2, 0, 0));

		p.update();

		assertEquals(2, p.getX());
		assertEquals(-2, p.getVelocity().getVx());

		p.update();

		assertEquals(-2, p.getX());
		assertEquals(-4, p.getVelocity().getVx());

		p.update();

		assertEquals(-8, p.getX());
		assertEquals(-6, p.getVelocity().getVx());
		assertEquals(8, p.getDistanceFromOrigin());
	}

	@Test
	public void test3() throws URISyntaxException {
		Point p1 = new Point(0, 3, 0, 0, new Velocity(2, 0, 0), new Acceleration(-1, 0, 0));
		Point p2 = new Point(1, 4, 0, 0, new Velocity(0, 0, 0), new Acceleration(-2, 0, 0));

		List<Point> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);

		int actual = Day20Part1.closestInLongTerm(points);

		assertEquals(0, actual);
	}

}
