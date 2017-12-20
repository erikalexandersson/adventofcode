package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day1Part2;

public class Day1Part2Test {

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
	public void test1() throws Exception {
		String captcha = "1212";
		int expected = 6;

		int sum = Day1Part2.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test2() throws Exception {
		String captcha = "1221";
		int expected = 0;

		int sum = Day1Part2.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test3() throws Exception {
		String captcha = "123425";
		int expected = 4;

		int sum = Day1Part2.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test4() throws Exception {
		String captcha = "123123";
		int expected = 12;

		int sum = Day1Part2.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test5() throws Exception {
		String captcha = "12131415";
		int expected = 4;

		int sum = Day1Part2.getSum(captcha);

		assertEquals(expected, sum);
	}

}
