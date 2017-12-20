package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day8Part2 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(executeProgram(Paths.get(ClassLoader.getSystemResource("Day8Input.txt").toURI())));
	}

	public static int executeProgram(Path path) {
		Map<String, Integer> registers = new HashMap<>();

		String pattern = "(\\w+) (\\w+) (-?\\d+) (\\w+) (\\w+) (\\W+) (-?\\d+)";
		Pattern p = Pattern.compile(pattern);

		int maxSeen = 0;
		try (Stream<String> stream = Files.lines(path)) {
			maxSeen = stream.map(line -> {
				Matcher m = p.matcher(line);
				if (m.matches()) {
					String targetRegistry = m.group(1);
					String operation = m.group(2);
					int value = Integer.parseInt(m.group(3));
					// String condIf = m.group(4);
					String checkRegistry = m.group(5);
					String checkOperator = m.group(6);
					int checkValue = Integer.parseInt(m.group(7));

					if (!registers.containsKey(targetRegistry)) {
						registers.put(targetRegistry, 0);
					}
					if (!registers.containsKey(checkRegistry)) {
						registers.put(checkRegistry, 0);
					}

					boolean execute = false;

					switch (checkOperator) {
					case ">":
						execute = registers.get(checkRegistry) > checkValue;
						break;
					case ">=":
						execute = registers.get(checkRegistry) >= checkValue;
						break;
					case "<":
						execute = registers.get(checkRegistry) < checkValue;
						break;
					case "<=":
						execute = registers.get(checkRegistry) <= checkValue;
						break;
					case "!=":
						execute = registers.get(checkRegistry) != checkValue;
						break;
					case "==":
						execute = registers.get(checkRegistry) == checkValue;
						break;
					default:
						break;
					}

					int currentValue;
					if (execute) {
						switch (operation) {
						case "inc":
							currentValue = registers.get(targetRegistry);
							registers.put(targetRegistry, currentValue + value);
							break;
						case "dec":
							currentValue = registers.get(targetRegistry);
							registers.put(targetRegistry, currentValue - value);
							break;
						default:
							break;
						}
					}
					int currentMax = registers.values().stream().max(Integer::compare).get();
					return currentMax;
				} else {
					return 0;
				}
			}).max(Integer::compare).get();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return maxSeen;
	}
}
