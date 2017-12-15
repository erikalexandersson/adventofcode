package adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day15Part2Test {

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
		long value = 1352636452;
		long expected = 1992081072;

		long actual = Day15Part2.nextValueGeneratorA(value);

		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		long value = 1233683848;
		long expected = 862516352;

		long actual = Day15Part2.nextValueGeneratorB(value);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		int expected = 309;

		int actual = Day15Part2.judge(65, 8921);

		assertEquals(expected, actual);
	}
}
