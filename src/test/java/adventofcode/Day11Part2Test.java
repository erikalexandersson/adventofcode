package adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day11Part2Test {

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
		String path = "ne,ne,ne";
		int expected = 3;

		int actual = Day11Part2.furthestAway(path);

		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		String path = "ne,ne,sw,sw";
		int expected = 2;

		int actual = Day11Part2.furthestAway(path);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		String path = "ne,ne,s,s";
		int expected = 2;

		int actual = Day11Part2.furthestAway(path);

		assertEquals(expected, actual);
	}

	@Test
	public void test4() throws URISyntaxException {
		String path = "se,sw,se,sw,sw";
		int expected = 3;

		int actual = Day11Part2.furthestAway(path);

		assertEquals(expected, actual);
	}

}
