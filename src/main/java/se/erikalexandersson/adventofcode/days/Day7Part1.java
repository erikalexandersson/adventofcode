package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Day7Program;

public class Day7Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(getTopProgram(Paths.get(ClassLoader.getSystemResource("Day7Input.txt").toURI())));
	}

	public static String getTopProgram(Path path) {
		List<Day7Program> programs = new ArrayList<>();

		Map<String, Day7Program> map = new HashMap<>();

		String patternNoDiscs = "(\\w+)\\s\\((\\d+)\\)";

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				String program;
				String discs[] = {};
				if (line.contains("->")) {
					program = line.split("->")[0].trim();
					discs = line.split("->")[1].replaceAll(",", "").split(" ");
				} else {
					program = line;
				}
				Pattern p = Pattern.compile(patternNoDiscs);
				Matcher m = p.matcher(program);
				m.matches();

				String programName = m.group(1);
				int weight = Integer.parseInt(m.group(2));
				Day7Program newP = new Day7Program(programName, weight);

				newP.getDiscs().addAll(Arrays.asList(discs));
				programs.add(newP);

				map.put(programName, newP);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		Set<String> allPrograms = map.keySet();
		Set<String> childPrograms = map.values().stream().map(p -> p.getDiscs()).flatMap(Collection::stream)
				.collect(Collectors.toSet());

		allPrograms.removeAll(childPrograms);

		return allPrograms.iterator().next();
	}
}
