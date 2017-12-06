package adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day6Part1Test {

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
		int arr[] = { 0, 2, 7, 0 };
		int expected[] = { 2, 4, 1, 2 };

		int[] actual = Day6Part1.reallocate(arr);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int arr[] = { 0, 2, 7, 0 };
		int expected = 5;

		int actual = Day6Part1.redistribute(arr);

		assertEquals(expected, actual);
	}

}
