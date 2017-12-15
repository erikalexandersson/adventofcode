package adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day15Part1Test {

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
		long value = 1092455;
		long expected = 1181022009;

		long actual = Day15Part1.nextValueGeneratorA(value);

		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		long value = 430625591;
		long expected = 1233683848;

		long actual = Day15Part1.nextValueGeneratorB(value);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		long genA = 1181022009;
		long genB = 1233683848;

		boolean match = Day15Part1.match(genA, genB);

		assertFalse(match);
	}

	@Test
	public void test4() throws URISyntaxException {
		long genA = 245556042;
		long genB = 1431495498;

		boolean match = Day15Part1.match(genA, genB);

		assertTrue(match);
	}

	@Test
	public void test5() throws URISyntaxException {
		int expected = 588;

		int actual = Day15Part1.judge(65, 8921);

		assertEquals(expected, actual);
	}
}
