package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day4Part1;

public class Day4Part1Test {

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
		String passphrase = "aa bb cc dd ee";

		boolean valid = Day4Part1.checkValidity(passphrase);

		assertTrue(valid);
	}

	@Test
	public void test2() {
		String passphrase = "aa bb cc dd aa";

		boolean valid = Day4Part1.checkValidity(passphrase);

		assertFalse(valid);
	}

	@Test
	public void test3() {
		String passphrase = "aa bb cc dd aaa";

		boolean valid = Day4Part1.checkValidity(passphrase);

		assertTrue(valid);
	}
}
