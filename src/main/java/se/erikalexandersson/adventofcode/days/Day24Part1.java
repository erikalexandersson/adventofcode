package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day24Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(
				findStrongest(buildBridges(Paths.get(ClassLoader.getSystemResource("Day24Input.txt").toURI()))));
	}

	public static int getBridgeStrength(String bridge) {
		int strength = 0;
		String[] components = bridge.split("--");
		for (int i = 0; i < components.length; i++) {
			String[] ports = components[i].split("/");
			strength += Integer.parseInt(ports[0]) + Integer.parseInt(ports[1]);
		}
		return strength;
	}

	public static List<String> buildBridges(Path path) {
		List<String> bridges = new ArrayList<>();

		List<String> components = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			components = stream.collect(Collectors.toList());
		} catch (IOException e) {
		}

		List<Integer> startComponents = new ArrayList<>();
		for (String component : components) {
			int port1 = Integer.parseInt(component.split("/")[0]);
			int port2 = Integer.parseInt(component.split("/")[1]);
			if (port1 == 0 || port2 == 0) {
				startComponents.add(components.indexOf(component));
			}
		}

		for (Integer start : startComponents) {
			String currentBridge = components.get(start);
			List<String> otherComponents = new ArrayList<>(components);
			otherComponents.remove(currentBridge);
			build(currentBridge, currentBridge.split("/")[1], bridges, otherComponents);
		}

		return bridges;
	}

	public static void build(String currentBridge, String availablePort, List<String> bridges,
			List<String> components) {
		bridges.add(currentBridge);
		for (String component : components) {
			String nextAvailablePort = isConnectable(availablePort, component);
			if (nextAvailablePort != null) {
				List<String> otherComponents = new ArrayList<>(components);
				otherComponents.remove(component);
				build(currentBridge + "--" + component, nextAvailablePort, bridges, otherComponents);
			}
		}
	}

	public static int findStrongest(List<String> bridges) {
		return bridges.stream().mapToInt(bridge -> getBridgeStrength(bridge)).max().getAsInt();
	}

	public static String isConnectable(String port, String component2) {
		String component2Port1 = component2.split("/")[0];
		String component2Port2 = component2.split("/")[1];

		if (port.equals(component2Port1)) {
			return component2Port2;
		} else if (port.equals(component2Port2)) {
			return component2Port1;
		} else {
			return null;
		}
	}

}
