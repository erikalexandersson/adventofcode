package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day9Part2;

public class Day9Part2Test {

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
		int expected = 0;

		int garbage = Day9Part2.countGarbage("<>", 0, false, false);

		assertEquals(expected, garbage);
	}

	@Test
	public void test2() throws URISyntaxException {
		int expected = 17;

		int garbage = Day9Part2.countGarbage("<random characters>", 0, false, false);

		assertEquals(expected, garbage);
	}

	@Test
	public void test3() throws URISyntaxException {
		int expected = 3;

		int garbage = Day9Part2.countGarbage("<<<<>", 0, false, false);

		assertEquals(expected, garbage);
	}

	@Test
	public void test4() throws URISyntaxException {
		int expected = 2;

		int score = Day9Part2.countGarbage("<{!>}>", 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test5() throws URISyntaxException {
		int expected = 0;

		int score = Day9Part2.countGarbage("<!!>", 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test6() throws URISyntaxException {
		int expected = 0;

		int score = Day9Part2.countGarbage("<!!!>>", 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test7() throws URISyntaxException {
		int expected = 10;

		int score = Day9Part2.countGarbage("<{o\"i!a,<{i<a>", 0, false, false);

		assertEquals(expected, score);
	}

}
