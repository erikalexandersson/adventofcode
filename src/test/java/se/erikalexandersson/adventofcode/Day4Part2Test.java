package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day4Part2;

public class Day4Part2Test {

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
		String passphrase = "abcde fghij";

		boolean valid = Day4Part2.checkValidity(passphrase);

		assertTrue(valid);
	}

	@Test
	public void test2() {
		String passphrase = "abcde xyz ecdab";

		boolean valid = Day4Part2.checkValidity(passphrase);

		assertFalse(valid);
	}

	@Test
	public void test3() {
		String passphrase = "a ab abc abd abf abj";

		boolean valid = Day4Part2.checkValidity(passphrase);

		assertTrue(valid);
	}
	
	@Test
	public void test4() {
		String passphrase = "iiii oiii ooii oooi oooo";

		boolean valid = Day4Part2.checkValidity(passphrase);

		assertTrue(valid);
	}
	
	@Test
	public void test5() {
		String passphrase = "oiii ioii iioi iiio";

		boolean valid = Day4Part2.checkValidity(passphrase);

		assertFalse(valid);
	}
}
