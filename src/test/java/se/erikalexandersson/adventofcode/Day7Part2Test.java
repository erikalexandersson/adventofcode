package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day7Part2;

public class Day7Part2Test {

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
	public void test() throws URISyntaxException {
		int expected = 60;

		int actual = Day7Part2.findCorrectWeight(Paths.get(ClassLoader.getSystemResource("Day7TestInput.txt").toURI()));

		assertEquals(expected, actual);
	}

}
