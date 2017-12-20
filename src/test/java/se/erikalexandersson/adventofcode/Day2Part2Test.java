package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day2Part2;

public class Day2Part2Test {

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
		int arr[][] = { { 5, 9, 2, 8 }, { 9, 4, 7, 3 }, { 3, 8, 6, 5 } };
		int expected = 9;

		int checksum = Day2Part2.getChecksum(arr);

		assertEquals(expected, checksum);
	}

}
