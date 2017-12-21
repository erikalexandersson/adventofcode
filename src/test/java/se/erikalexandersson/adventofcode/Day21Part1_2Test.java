package se.erikalexandersson.adventofcode;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day21Part1_2;

public class Day21Part1_2Test {

	private Day21Part1_2 day21;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		day21 = new Day21Part1_2();
		day21.readManual(Paths.get(ClassLoader.getSystemResource("Day21TestInput.txt").toURI()));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRotateClockwise() throws URISyntaxException {
		char[][] input = { { '.', '#', '.' }, { '.', '.', '#' }, { '#', '#', '#' } };
		char[][] expected = { { '#', '.', '.' }, { '#', '.', '#' }, { '#', '#', '.' } };

		char[][] actual = Day21Part1_2.rotateClockwise(input);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testFlipVertical() throws URISyntaxException {
		char[][] input = { { '.', '#', '.' }, { '.', '.', '#' }, { '#', '#', '#' } };
		char[][] expected = { { '.', '#', '.' }, { '#', '.', '.' }, { '#', '#', '#' } };

		char[][] actual = Day21Part1_2.flipVertical(input);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test1() throws URISyntaxException {
		char[][] pattern = { { '.', '#', '.' }, { '.', '.', '#' }, { '#', '#', '#' } };
		char[][] expected = { { '#', '.', '.', '#' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' },
				{ '#', '.', '.', '#' } };

		char[][] actual = day21.next(pattern);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() throws URISyntaxException {
		char[][] pattern = { { '#', '.', '.', '#' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' },
				{ '#', '.', '.', '#' } };
		char[][] expected = { { '#', '#', '.', '#', '#', '.' }, { '#', '.', '.', '#', '.', '.' },
				{ '.', '.', '.', '.', '.', '.' }, { '#', '#', '.', '#', '#', '.' }, { '#', '.', '.', '#', '.', '.' },
				{ '.', '.', '.', '.', '.', '.' }, };

		char[][] actual = day21.next(pattern);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void test3() throws URISyntaxException {
		char[][] pattern = { { '.', '#', '.' }, { '.', '.', '#' }, { '#', '#', '#' } };
		int expected = 12;

		int actual = day21.onAfterIterations(pattern, 2);

		assertEquals(expected, actual);
	}
}
