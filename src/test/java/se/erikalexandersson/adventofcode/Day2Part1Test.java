package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day2Part1;

public class Day2Part1Test {

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
	public void test() {
		int arr[][] = { { 5, 1, 9, 5 }, { 7, 5, 3 }, { 2, 4, 6, 8 } };
		int expected = 18;

		int checksum = Day2Part1.getChecksum(arr);

		assertEquals(expected, checksum);
	}

}
