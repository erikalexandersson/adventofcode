package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day1Part1;

public class Day1Part1Test {

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
		String captcha = "1122";
		int expected = 3;

		int sum = Day1Part1.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test2() throws Exception {
		String captcha = "1111";
		int expected = 4;

		int sum = Day1Part1.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test3() throws Exception {
		String captcha = "1234";
		int expected = 0;

		int sum = Day1Part1.getSum(captcha);

		assertEquals(expected, sum);
	}

	@Test
	public void test4() throws Exception {
		String captcha = "91212129";
		int expected = 9;

		int sum = Day1Part1.getSum(captcha);

		assertEquals(expected, sum);
	}

}
