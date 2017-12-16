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

public class Day16Part1Test {

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
		String programs = "abcde";
		String expected = "eabcd";

		String actual = Day16Part1.spin(programs, 1);

		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		String programs = "eabcd";
		String expected = "eabdc";

		String actual = Day16Part1.exchange(programs, 3, 4);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		String programs = "eabdc";
		String expected = "baedc";

		String actual = Day16Part1.partner(programs, 'e', 'b');

		assertEquals(expected, actual);
	}

	@Test
	public void test4() throws URISyntaxException {
		String programs = "abcde";
		String expected = "baedc";
		Path path = Paths.get(ClassLoader.getSystemResource("Day16TestInput.txt").toURI());

		String actual = Day16Part1.dance(path, programs);

		assertEquals(expected, actual);
	}

}
