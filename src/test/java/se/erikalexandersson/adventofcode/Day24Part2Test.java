package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day24Part2;

public class Day24Part2Test {

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
		Path path = Paths.get(ClassLoader.getSystemResource("Day24TestInput.txt").toURI());
		int expectedStrength = 19;

		List<String> bridges = Day24Part2.buildBridges(path);

		int actualStrength = Day24Part2.findLongestStrongest(bridges);

		assertEquals(expectedStrength, actualStrength);
	}
}
