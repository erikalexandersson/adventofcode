package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day16Part1 {

	public static void main(String args[]) throws URISyntaxException {
		String programs = "abcdefghijklmnop";
		System.out.println(dance(Paths.get(ClassLoader.getSystemResource("Day16Input.txt").toURI()), programs));
	}

	public static String dance(Path path, String programs) {
		try (Stream<String> stream = Files.lines(path)) {
			List<String> moves = stream.map(line -> line.split(",")).flatMap(x -> Arrays.stream(x))
					.collect(Collectors.toList());

			for (String move : moves) {
				switch (move.charAt(0)) {
				case 's':
					programs = spin(programs, Integer.valueOf(move.substring(1)));
					break;
				case 'x':
					programs = exchange(programs, Integer.valueOf(move.substring(1).split("/")[0]),
							Integer.valueOf(move.substring(1).split("/")[1]));
					break;
				case 'p':
					programs = partner(programs, move.charAt(1), move.charAt(3));
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return programs;
	}

	public static String spin(String programs, int length) {
		return programs.substring(programs.length() - length) + programs.substring(0, programs.length() - length);
	}

	public static String exchange(String programs, int p1, int p2) {
		char[] arr = programs.toCharArray();
		char c1 = arr[p1];
		char c2 = arr[p2];
		arr[p1] = c2;
		arr[p2] = c1;
		return new String(arr);
	}

	public static String partner(String programs, char c1, char c2) {
		int p1 = -1;
		int p2 = -1;
		for (int i = 0; i < programs.length(); i++) {
			if (programs.charAt(i) == c1) {
				p1 = i;
			} else if (programs.charAt(i) == c2) {
				p2 = i;
			}
		}
		return exchange(programs, p1, p2);
	}

}
