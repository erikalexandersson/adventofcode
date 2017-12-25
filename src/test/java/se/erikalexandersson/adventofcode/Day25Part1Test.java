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

import se.erikalexandersson.adventofcode.days.Day25Part1;
import se.erikalexandersson.adventofcode.days.Day25Part1.State;

public class Day25Part1Test {

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
		State currentState = State.A;

		int steps = 6;
		int currentPosition = 0;
		Map<Integer, Byte> tape = new HashMap<>();

		while (steps-- > 0) {
			switch (currentState) {
			case A:
				if (Day25Part1.getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
				} else {
					tape.put(currentPosition, (byte) 0);
					currentPosition--;
				}
				currentState = State.B;
				break;
			case B:
				if (Day25Part1.getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition--;
				} else {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
				}
				currentState = State.A;
				break;
			default:
				break;
			}
		}

		int actual = tape.values().stream().mapToInt(b -> b.intValue()).sum();

		assertEquals(expected, actual);
	}

}
