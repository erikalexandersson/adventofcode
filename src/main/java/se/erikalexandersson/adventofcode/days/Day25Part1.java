package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Day25Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(performDiagnostics(12399302));
	}

	private static int performDiagnostics(int steps) {
		State currentState = State.A;

		int currentPosition = 0;
		Map<Integer, Byte> tape = new HashMap<>();

		while (steps-- > 0) {
			switch (currentState) {
			case A:
				if (getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
					currentState = State.B;
				} else {
					tape.put(currentPosition, (byte) 0);
					currentPosition++;
					currentState = State.C;
				}
				break;
			case B:
				if (getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 0);
					currentPosition--;
					currentState = State.A;
				} else {
					tape.put(currentPosition, (byte) 0);
					currentPosition++;
					currentState = State.D;
				}
				break;
			case C:
				if (getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
					currentState = State.D;
				} else {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
					currentState = State.A;
				}
				break;
			case D:
				if (getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition--;
					currentState = State.E;
				} else {
					tape.put(currentPosition, (byte) 0);
					currentPosition--;
					currentState = State.D;
				}
				break;
			case E:
				if (getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
					currentState = State.F;
				} else {
					tape.put(currentPosition, (byte) 1);
					currentPosition--;
					currentState = State.B;
				}
				break;
			case F:
				if (getValue(tape, currentPosition) == 0) {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
					currentState = State.A;
				} else {
					tape.put(currentPosition, (byte) 1);
					currentPosition++;
					currentState = State.E;
				}
				break;
			default:
				break;
			}
		}

		return tape.values().stream().mapToInt(b -> b.intValue()).sum();
	}

	public static int getValue(Map<Integer, Byte> tape, int position) {
		if (!tape.containsKey(position)) {
			tape.put(position, (byte) 0);
		}
		return tape.get(position);
	}

	public enum State {
		A, B, C, D, E, F;
	}
}
