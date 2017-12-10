package adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day10Part2Test {

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
		String input = "";
		String expected = "a2582a3a0e66e6e86e3812dcb672a272";

		String actual = Day10Part2.knotHash(input);

		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		String input = "AoC 2017";
		String expected = "33efeb34ea91902bb2f59c9920caa6cd";

		String actual = Day10Part2.knotHash(input);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		String input = "1,2,3";
		String expected = "3efbe78a8d82f29979031a4aa0b16a9d";

		String actual = Day10Part2.knotHash(input);

		assertEquals(expected, actual);
	}

	@Test
	public void test4() throws URISyntaxException {
		String input = "1,2,4";
		String expected = "63960835bcdc130f0b66d7ff4f6a5a8e";

		String actual = Day10Part2.knotHash(input);

		assertEquals(expected, actual);
	}
}
