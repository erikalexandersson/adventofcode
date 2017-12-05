package adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day5Part1Test {

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
		int arr[] = { 0, 3, 0, 1, -3 };
		int pos = 0;
		int expectedSteps = 5;

		int actual = Day5Part1.countSteps(arr, pos, 0);

		assertEquals(expectedSteps, actual);
	}

}
