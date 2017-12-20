package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Day12Part1 {

	static Set<String> visitedPrograms;

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(countPrograms(Paths.get(ClassLoader.getSystemResource("Day12Input.txt").toURI()), "0"));
	}

	public static int countPrograms(Path path, String programName) {

		Map<String, Set<String>> programsWithPipes = parseFile(path);

		visitedPrograms = new HashSet<>();

		countPrograms(programsWithPipes, programName);

		return visitedPrograms.size();
	}

	private static void countPrograms(Map<String, Set<String>> programsWithPipes, String programName) {

		programsWithPipes.get(programName).forEach(program -> {
			if (!visitedPrograms.contains(program)) {
				visitedPrograms.add(program);
				countPrograms(programsWithPipes, program);
			}
		});

	}

	private static Map<String, Set<String>> parseFile(Path path) {
		Map<String, Set<String>> programsWithPipes = new HashMap<>();

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				String programName = line.split("<->")[0].trim();

				String pipes[] = line.split("<->")[1].trim().split(", ");

				if (!programsWithPipes.containsKey(programName)) {
					programsWithPipes.put(programName, new HashSet<>());
				}
				Arrays.asList(pipes).forEach(pipe -> programsWithPipes.get(programName).add(pipe));
				Arrays.asList(pipes).forEach(pipe -> {
					if (!programsWithPipes.containsKey(pipe)) {
						programsWithPipes.put(pipe, new HashSet<>());
					}
					programsWithPipes.get(pipe).add(programName);
				});
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return programsWithPipes;
	}

}
