package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day9Part1;

public class Day9Part1Test {

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
		int expected = 1;

		int score = Day9Part1.score("{}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test2() throws URISyntaxException {
		int expected = 6;

		int score = Day9Part1.score("{{{}}}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test3() throws URISyntaxException {
		int expected = 5;

		int score = Day9Part1.score("{{},{}}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test4() throws URISyntaxException {
		int expected = 16;

		int score = Day9Part1.score("{{{},{},{{}}}}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test5() throws URISyntaxException {
		int expected = 1;

		int score = Day9Part1.score("{<a>,<a>,<a>,<a>}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test6() throws URISyntaxException {
		int expected = 9;

		int score = Day9Part1.score("{{<ab>},{<ab>},{<ab>},{<ab>}}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test7() throws URISyntaxException {
		int expected = 9;

		int score = Day9Part1.score("{{<!!>},{<!!>},{<!!>},{<!!>}}", 0, 0, false, false);

		assertEquals(expected, score);
	}

	@Test
	public void test8() throws URISyntaxException {
		int expected = 3;

		int score = Day9Part1.score("{{<a!>},{<a!>},{<a!>},{<ab>}}", 0, 0, false, false);

		assertEquals(expected, score);
	}

}
