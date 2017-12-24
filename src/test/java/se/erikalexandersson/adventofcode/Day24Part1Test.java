package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day24Part1;

public class Day24Part1Test {

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
		int expectedNumBridges = 11;
		int expectedStrength = 31;

		List<String> bridges = Day24Part1.buildBridges(path);

		int actualStrength = Day24Part1.findStrongest(bridges);

		assertEquals(expectedNumBridges, bridges.size());
		assertEquals(expectedStrength, actualStrength);
	}

	@Test
	public void test2() throws URISyntaxException {
		int expected = 1;
		String bridge = "0/1";

		int actual = Day24Part1.getBridgeStrength(bridge);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		int expected = 31;
		String bridge = "0/1--10/1--9/10";

		int actual = Day24Part1.getBridgeStrength(bridge);

		assertEquals(expected, actual);
	}

	@Test
	public void test4() throws URISyntaxException {
		String port = "2";
		String component2 = "2/3";
		String expected = "3";

		String availablePort = Day24Part1.isConnectable(port, component2);

		assertNotNull(availablePort);
		assertEquals(expected, availablePort);
	}

	@Test
	public void test5() throws URISyntaxException {
		String port = "2";
		String component2 = "3/5";

		String availablePort = Day24Part1.isConnectable(port, component2);

		assertNull(availablePort);
	}
}
