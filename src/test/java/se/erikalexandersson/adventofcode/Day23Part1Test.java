package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day23Part1;

public class Day23Part1Test {

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
		Map<String, Long> registers = new HashMap<>();
		String line = "";

		line = "set A 3";
		Day23Part1.runLine(registers, line);
		assertEquals(3L, registers.get("A").longValue());

		line = "set B 2";
		Day23Part1.runLine(registers, line);
		assertEquals(2L, registers.get("B").longValue());

		line = "sub A B";
		Day23Part1.runLine(registers, line);
		assertEquals(1L, registers.get("A").longValue());

		line = "set C 2";
		Day23Part1.runLine(registers, line);
		assertEquals(2L, registers.get("C").longValue());

		line = "mul C B";
		Day23Part1.runLine(registers, line);
		assertEquals(4L, registers.get("C").longValue());

		line = "jnz B C";
		int expected = 4;
		int offset = Day23Part1.runLine(registers, line);
		assertEquals(expected, offset);

		line = "jnz 1 5";
		expected = 5;
		offset = Day23Part1.runLine(registers, line);
		assertEquals(expected, offset);
	}
}
