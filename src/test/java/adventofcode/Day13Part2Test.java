package adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day13Part2Test {

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
		Map<Integer, Integer> layers = new HashMap<>();
		int expected = 10;

		layers.put(0, 3);
		layers.put(1, 2);
		layers.put(4, 4);
		layers.put(6, 4);
		int actual = Day13Part2.escapeFirewall(layers);

		assertEquals(expected, actual);
	}

}
