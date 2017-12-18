package adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day18Part2Test {

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
		int expected = 3;

		Path path = Paths.get(ClassLoader.getSystemResource("Day18TestInput2.txt").toURI());
		long actual = Day18Part2.sing(path);

		assertEquals(expected, actual);
	}
}
