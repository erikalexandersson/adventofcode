package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Day13Part2 {

	static Set<String> visitedPrograms;

	public static void main(String args[]) throws URISyntaxException {
		Map<Integer, Integer> layers = new HashMap<>();
		layers.put(0, 3);
		layers.put(1, 2);
		layers.put(2, 4);
		layers.put(4, 4);
		layers.put(6, 5);
		layers.put(8, 8);
		layers.put(10, 6);
		layers.put(12, 6);
		layers.put(14, 8);
		layers.put(16, 6);
		layers.put(18, 6);
		layers.put(20, 8);
		layers.put(22, 12);
		layers.put(24, 8);
		layers.put(26, 8);
		layers.put(28, 12);
		layers.put(30, 8);
		layers.put(32, 12);
		layers.put(34, 9);
		layers.put(36, 14);
		layers.put(38, 12);
		layers.put(40, 12);
		layers.put(42, 12);
		layers.put(44, 14);
		layers.put(46, 14);
		layers.put(48, 10);
		layers.put(50, 14);
		layers.put(52, 12);
		layers.put(54, 14);
		layers.put(56, 12);
		layers.put(58, 17);
		layers.put(60, 10);
		layers.put(64, 14);
		layers.put(66, 14);
		layers.put(68, 12);
		layers.put(70, 12);
		layers.put(72, 18);
		layers.put(74, 14);
		layers.put(78, 14);
		layers.put(82, 14);
		layers.put(84, 24);
		layers.put(86, 14);
		layers.put(94, 14);
		final long startTime = System.nanoTime();
		System.out.println(escapeFirewall(layers));
		final long endTime = System.nanoTime() - startTime;
		System.out.println(endTime / 1000.0 / 1000.0 / 1000.0 + " s");
	}

	public static int escapeFirewall(Map<Integer, Integer> layers) {

		int lastLayer = layers.keySet().stream().mapToInt(Integer::valueOf).max().getAsInt();

		Map<Integer, Boolean> directions = new HashMap<>();
		Map<Integer, Integer> scannerPositions = new HashMap<>();

		for (int j = 0; j <= lastLayer; j++) {
			directions.put(j, true);
			scannerPositions.put(j, 0);
		}

		int delay = 0;
		do {
			int currentLayer = 0;
			boolean caught = false;

			moveScanners(layers, scannerPositions, directions);

			Map<Integer, Boolean> startDirections = new HashMap<>(directions);
			Map<Integer, Integer> startScannerPositions = new HashMap<>(scannerPositions);

			do {
				if (layers.containsKey(currentLayer) && scannerPositions.get(currentLayer).intValue() == 0) {
					caught = true;
					break;
				}

				moveScanners(layers, scannerPositions, directions);

			} while (++currentLayer <= lastLayer);

			delay++;
			if (!caught) {
				break;
			}

			directions = new HashMap<>(startDirections);
			scannerPositions = new HashMap<>(startScannerPositions);
		} while (true);

		return delay;
	}

	private static void moveScanners(Map<Integer, Integer> layers, Map<Integer, Integer> scannerPositions,
			Map<Integer, Boolean> directions) {
		for (Entry<Integer, Integer> entry : layers.entrySet()) {
			int layer = entry.getKey();
			int position = scannerPositions.get(layer);
			int range = layers.get(layer);
			boolean direction = directions.get(layer);

			if (position == 0 && direction == false) {
				directions.put(layer, true);
				position = 1;
			} else if ((position == range - 1) && (direction == true)) {
				directions.put(layer, false);
				position = range - 2;
			} else {
				position = direction ? position + 1 : position - 1;
			}
			scannerPositions.put(layer, position);
		}
	}

}
