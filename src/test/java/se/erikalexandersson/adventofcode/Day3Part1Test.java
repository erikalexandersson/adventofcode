package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day3Part1;

public class Day3Part1Test {

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
	public void test1() {
		int square = 1;
		int expected = 0;

		int steps = Day3Part1.countSteps(square);

		assertEquals(expected, steps);
	}

	@Test
	public void test2() {
		int square = 12;
		int expected = 3;

		int steps = Day3Part1.countSteps(square);

		assertEquals(expected, steps);
	}

	@Test
	public void test3() {
		int square = 23;
		int expected = 2;

		int steps = Day3Part1.countSteps(square);

		assertEquals(expected, steps);
	}

	@Test
	public void test4() {
		int square = 1024;
		int expected = 31;

		int steps = Day3Part1.countSteps(square);

		assertEquals(expected, steps);
	}
}
