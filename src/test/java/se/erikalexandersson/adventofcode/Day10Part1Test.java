package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day10Part1;

public class Day10Part1Test {

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
		Integer[] arr = { 0, 1, 2, 3, 4 };
		Integer[] expected = { 2, 1, 0, 3, 4 };
		int position = 0;
		int length = 3;

		Integer[] actual = Day10Part1.pinchAndTwist(arr, position, length);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		Integer[] arr = { 2, 1, 0, 3, 4 };
		Integer[] expected = { 4, 3, 0, 1, 2 };
		int position = 3;
		int length = 4;

		Integer[] actual = Day10Part1.pinchAndTwist(arr, position, length);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		Integer[] arr = { 4, 3, 0, 1, 2 };
		Integer[] expected = { 4, 3, 0, 1, 2 };
		int position = 3;
		int length = 1;

		Integer[] actual = Day10Part1.pinchAndTwist(arr, position, length);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test4() throws URISyntaxException {
		Integer[] arr = { 4, 3, 0, 1, 2 };
		Integer[] expected = { 3, 4, 2, 1, 0 };
		int position = 1;
		int length = 5;

		Integer[] actual = Day10Part1.pinchAndTwist(arr, position, length);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRun() throws URISyntaxException {
		Integer[] arr = { 0, 1, 2, 3, 4 };
		Integer[] lengths = { 3, 4, 1, 5 };
		Integer[] expected = { 3, 4, 2, 1, 0 };

		Integer[] actual = Day10Part1.run(arr, lengths);

		assertArrayEquals(expected, actual);
	}

}
