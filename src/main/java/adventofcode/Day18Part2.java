package adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day18Part2 {

	private static Map<String, Long> registersP0;
	private static Map<String, Long> registersP1;

	private static Queue<Long> incomingP0;
	private static Queue<Long> incomingP1;

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(sing(Paths.get(ClassLoader.getSystemResource("Day18Input.txt").toURI())));
	}

	public static long sing(Path path) {
		registersP0 = new HashMap<>();
		registersP1 = new HashMap<>();

		incomingP0 = new LinkedList<>();
		incomingP1 = new LinkedList<>();

		registersP0.put("p", 0L);
		registersP1.put("p", 1L);

		List<String> program = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {

			program = stream.collect(Collectors.toList());
		} catch (IOException e) {
		}

		int p1sent = 0;

		int p0position = 0;
		int p1position = 0;
		boolean deadlocked = false;
		do {
			int oldP0Position = p0position;
			p0position = runProgram(registersP0, incomingP0, incomingP1, program, p0position);

			int currentOutgoing = incomingP0.size();
			int oldP1Position = p1position;
			p1position = runProgram(registersP1, incomingP1, incomingP0, program, p1position);
			p1sent += incomingP0.size() - currentOutgoing;

			deadlocked = (oldP0Position == p0position) && (oldP1Position == p1position) && incomingP0.isEmpty()
					&& incomingP1.isEmpty();

		} while (!deadlocked);

		return p1sent;
	}

	private static int runProgram(Map<String, Long> registers, Queue<Long> incoming, Queue<Long> outgoing,
			List<String> program, int p0position) {
		for (int i = p0position; i < program.size(); i++) {
			String line = program.get(i);
			String instruction = line.split(" ")[0];
			String register = line.split(" ")[1];
			long value;
			switch (instruction) {
			case "snd":
				outgoing.add(getRegister(registers, register));
				break;
			case "set":
				value = getValue(registers, line);
				registers.put(register, value);
				break;
			case "add":
				value = getValue(registers, line);
				registers.put(register, getRegister(registers, register) + value);
				break;
			case "mul":
				value = getValue(registers, line);
				registers.put(register, getRegister(registers, register) * value);
				break;
			case "mod":
				value = getValue(registers, line);
				registers.put(register, getRegister(registers, register) % value);
				break;
			case "rcv":
				if (incoming.isEmpty()) {
					return i;
				} else {
					value = incoming.remove();
					registers.put(register, value);
				}
				break;
			case "jgz":
				value = getValue(registers, line);
				if (getRegister(registers, register) > 0) {
					i += (value - 1);
				}
				break;
			default:
				break;
			}
		}
		return -1;
	}

	private static long getValue(Map<String, Long> registers, String line) {
		String val = line.split(" ")[2];
		return isNumeric(val) ? Long.parseLong(val) : getRegister(registers, val);
	}

	private static long getRegister(Map<String, Long> registers, String register) {
		if (isNumeric(register)) {
			return Long.parseLong(register);
		} else {
			if (!registers.containsKey(register)) {
				registers.put(register, 0L);
			}
			return registers.get(register);
		}
	}

	private static boolean isNumeric(String num) {
		try {
			Long.parseLong(num);
			return true;
		} catch (NumberFormatException ex) {
		}
		return false;
	}

}
