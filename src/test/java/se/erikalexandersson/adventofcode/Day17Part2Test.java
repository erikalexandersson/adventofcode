package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day17Part2;

public class Day17Part2Test {

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
		int startPos = 0;
		int steps = 3;
		int spins = 1;
		List<Integer> list = new LinkedList<>();
		list.add(0);

		Day17Part2.spins(list, startPos, steps, spins);

		assertEquals(0, list.get(0).intValue());
		assertEquals(1, list.get(1).intValue());
	}
}
