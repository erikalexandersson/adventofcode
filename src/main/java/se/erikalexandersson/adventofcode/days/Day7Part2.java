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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Day7Disc;
import se.erikalexandersson.adventofcode.helpers.Day7Exception;
import se.erikalexandersson.adventofcode.helpers.Day7Program2;

public class Day7Part2 {

	static Day7Program2 bottomProgram;

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(findCorrectWeight(Paths.get(ClassLoader.getSystemResource("Day7Input.txt").toURI())));
	}

	public static void buildTower(Path path) {
		List<Day7Program2> programs = new ArrayList<>();

		Map<String, Day7Program2> map = new HashMap<>();

		String patternNoDiscs = "(\\w+)\\s\\((\\d+)\\)";

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				if (!line.contains("->")) {
					Pattern p = Pattern.compile(patternNoDiscs);
					Matcher m = p.matcher(line);
					m.matches();

					String programName = m.group(1);
					int weight = Integer.parseInt(m.group(2));
					Day7Program2 newP = new Day7Program2(programName, weight);

					programs.add(newP);

					map.put(programName, newP);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				if (line.contains("->")) {
					String program;
					String childPrograms[] = {};
					program = line.split("->")[0].trim();
					childPrograms = line.split("->")[1].trim().replaceAll(",", "").split(" ");
					Pattern p = Pattern.compile(patternNoDiscs);
					Matcher m = p.matcher(program);
					m.matches();

					String programName = m.group(1);
					int weight = Integer.parseInt(m.group(2));
					Day7Program2 newP = new Day7Program2(programName, weight);

					newP.getDiscs().addAll(Arrays.asList(childPrograms).stream().map(str -> {
						return new Day7Disc(programName, str);
					}).collect(Collectors.toList()));
					programs.add(newP);

					map.put(programName, newP);
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		map.values().forEach(program -> {
			program.getDiscs().forEach(disc -> {
				Day7Program2 heldBy = map.get(disc.getHeldByProgramName());
				disc.setHeldBy(heldBy);
				Day7Program2 p = map.get(disc.getProgramName());
				disc.setProgram(p);
			});
		});

		Set<String> allPrograms = map.keySet();
		Set<String> childPrograms = map.values().stream()
				.map(p -> p.getDiscs().stream().map(disc -> disc.getProgramName()).collect(Collectors.toList()))
				.flatMap(Collection::stream).collect(Collectors.toSet());

		allPrograms.removeAll(childPrograms);

		bottomProgram = map.get(allPrograms.iterator().next());
	}

	public static int findCorrectWeight(Path path) {
		buildTower(path);

		try {
			return balance(bottomProgram);
		} catch (Day7Exception e) {
			return e.weight;
		}
	}

	private static int balance(Day7Program2 program) throws Day7Exception {
		if (program.getDiscs() == null || program.getDiscs().isEmpty()) {
			return program.getWeight();
		} else {
			Map<Integer, Long> weightToCount = new HashMap<>();
			for (Day7Disc disc : program.getDiscs()) {
				int weight = balance(disc.getProgram());
				disc.setWeight(weight);
				if (!weightToCount.containsKey(weight)) {
					weightToCount.put(weight, (long) 0);
				}
				weightToCount.put(weight, weightToCount.get(weight) + 1);
			}
			if (weightToCount.size() == 1) {
				int weight = weightToCount.keySet().iterator().next();
				int count = weightToCount.get(weight).intValue();
				return program.getWeight() + (weight * count);
			} else {
				// UNBALANCED!
				int incorrectWeight = 0;
				int correctWeight = 0;
				Iterator<Integer> it = weightToCount.keySet().iterator();
				while (it.hasNext()) {
					int key = it.next();
					if (weightToCount.get(key) == 1) {
						incorrectWeight = key;
					} else {
						correctWeight = key;
					}
				}
				final int filterWeight = incorrectWeight;
				int adjustWeight = incorrectWeight - correctWeight;
				int programWeight = program.getDiscs().stream().filter(disc -> disc.getWeight() == filterWeight)
						.findFirst().get().getProgram().getWeight();
				throw new Day7Exception(programWeight - adjustWeight);
			}
		}
	}
}
