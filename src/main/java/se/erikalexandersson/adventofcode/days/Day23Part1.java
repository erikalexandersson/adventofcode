package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day23Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(runCode(Paths.get(ClassLoader.getSystemResource("Day23Input.txt").toURI())));
	}

	public static int runCode(Path path) {
		Map<String, Long> registers = new HashMap<>();

		int numMul = 0;

		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			for (int i = 0; i < lines.size(); i++) {
				String line = lines.get(i);
				if (line.startsWith("mul")) {
					numMul++;
				}
				int offset = runLine(registers, line);
				i += offset - 1;
			}
		} catch (IOException e) {
		}
		return numMul;
	}

	public static int runLine(Map<String, Long> registers, String line) {
		String instruction = line.split(" ")[0];
		String register = line.split(" ")[1];
		int offset = 1;
		long value;
		switch (instruction) {
		case "set":
			value = getValue(registers, line);
			registers.put(register, value);
			break;
		case "sub":
			value = getValue(registers, line);
			registers.put(register, getRegister(registers, register) - value);
			break;
		case "mul":
			value = getValue(registers, line);
			registers.put(register, getRegister(registers, register) * value);
			break;
		case "jnz":
			value = getValue(registers, line);
			if (isNumeric(register) && Integer.parseInt(register) != 0) {
				offset = (int) value;
			} else if (getRegister(registers, register) != 0) {
				offset = (int) value;
			}
			break;
		default:
			break;
		}
		return offset;
	}

	private static long getValue(Map<String, Long> registers, String line) {
		String val = line.split(" ")[2];
		return isNumeric(val) ? Long.parseLong(val) : getRegister(registers, val);
	}

	private static long getRegister(Map<String, Long> registers, String register) {
		if (!registers.containsKey(register)) {
			registers.put(register, 0L);
		}
		return registers.get(register);
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
