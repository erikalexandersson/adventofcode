package adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day17Part1Test {

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
		int expected = 1;
		int steps = 3;
		int spins = 1;
		List<Integer> list = new LinkedList<>();
		list.add(0);

		int actual = Day17Part1.spins(list, startPos, steps, spins);

		assertEquals(expected, actual);
		assertEquals(0, list.get(0).intValue());
		assertEquals(1, list.get(1).intValue());
	}

	@Test
	public void test2() throws URISyntaxException {
		int startPos = 0;
		int expected = 1;
		int steps = 3;
		int spins = 2;
		List<Integer> list = new LinkedList<>();
		list.add(0);

		int actual = Day17Part1.spins(list, startPos, steps, spins);

		assertEquals(expected, actual);
		assertEquals(0, list.get(0).intValue());
		assertEquals(2, list.get(1).intValue());
		assertEquals(1, list.get(2).intValue());
	}

	@Test
	public void test3() throws URISyntaxException {
		int startPos = 0;
		int expected = 1;
		int steps = 3;
		int spins = 9;
		List<Integer> list = new LinkedList<>();
		list.add(0);

		int actual = Day17Part1.spins(list, startPos, steps, spins);

		assertEquals(expected, actual);
		assertEquals(0, list.get(0).intValue());
		assertEquals(9, list.get(1).intValue());
		assertEquals(5, list.get(2).intValue());
		assertEquals(7, list.get(3).intValue());
		assertEquals(2, list.get(4).intValue());
		assertEquals(4, list.get(5).intValue());
		assertEquals(3, list.get(6).intValue());
		assertEquals(8, list.get(7).intValue());
		assertEquals(6, list.get(8).intValue());
		assertEquals(1, list.get(9).intValue());
	}

	@Test
	public void test4() throws URISyntaxException {
		int startPos = 0;
		int expected = 638;
		int steps = 3;
		int spins = 2017;
		List<Integer> list = new LinkedList<>();
		list.add(0);

		int pos = Day17Part1.spins(list, startPos, steps, spins);

		assertEquals(expected, list.get(pos + 1).intValue());
	}
}
