package adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day16Part2Test {

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
		String programs = "abcde";
		String expected = "ceadb";
		Path path = Paths.get(ClassLoader.getSystemResource("Day16TestInput.txt").toURI());

		String actual = Day16Part2.dance(path, programs, 2);

		assertEquals(expected, actual);
	}

}
