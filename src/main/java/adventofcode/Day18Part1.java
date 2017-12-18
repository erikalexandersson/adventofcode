package adventofcode;

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

public class Day18Part1 {

	private static Map<String, Long> registers;

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(sing(Paths.get(ClassLoader.getSystemResource("Day18Input.txt").toURI())));
	}

	public static long sing(Path path) {
		registers = new HashMap<>();
		long lastPlayed = -1;

		boolean recovered = false;

		long recoveredFrequency = -1;

		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			for (int i = 0; i < lines.size(); i++) {
				String line = lines.get(i);
				String instruction = line.split(" ")[0];
				String register = line.split(" ")[1];
				long value;
				switch (instruction) {
				case "snd":
					lastPlayed = getRegister(register);
					break;
				case "set":
					value = getValue(line);
					registers.put(register, value);
					break;
				case "add":
					value = getValue(line);
					registers.put(register, getRegister(register) + value);
					break;
				case "mul":
					value = getValue(line);
					registers.put(register, getRegister(register) * value);
					break;
				case "mod":
					value = getValue(line);
					registers.put(register, getRegister(register) % value);
					break;
				case "rcv":
					if (getRegister(register) != 0) {
						if (!recovered) {
							recovered = true;
							recoveredFrequency = lastPlayed;
							break;
						}
					}
					break;
				case "jgz":
					value = getValue(line);
					if (getRegister(register) > 0) {
						i += (value - 1);
					}
					break;
				default:
					break;
				}
				if (recovered) {
					break;
				}
			}
		} catch (IOException e) {
		}
		return recoveredFrequency;
	}

	private static long getValue(String line) {
		String val = line.split(" ")[2];
		return isNumeric(val) ? Long.parseLong(val) : getRegister(val);
	}

	private static long getRegister(String register) {
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
