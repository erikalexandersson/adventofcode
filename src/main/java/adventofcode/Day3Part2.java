package adventofcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3Part2 {

	private static List<Integer> fromList;
	private static Map<Tuple, Integer> squares;

	private static class Tuple {
		int x;
		int y;

		public Tuple(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	public static int sumInSquare(int square) {
		int sum = 1;

		int ring = 0;

		fromList = new ArrayList<>();
		squares = new HashMap<>();

		int numElementsAtRingN = 1;
		int numElementsSoFar = 1;
		int from = 1;
		fromList.add(from);
		while (square > numElementsSoFar) {
			ring++;
			from = numElementsSoFar + 1;
			fromList.add(from);
			numElementsAtRingN = (((2 * ring) - 1) * 4) + 4;
			numElementsSoFar += numElementsAtRingN;
		}

		if (ring == 0) {
			sum = 1;
		} else {
			sum = getSum(square, ring, fromList.get(ring));
		}

		return sum;
	}

	private static int getSum(int square, int ring, int from) {
		if (ring == 0) {
			return 1;
		} else {
			int x = getX(square, ring, from);
			int y = getY(square, ring, from);
			squares.put(new Tuple(x, y), square);

			int previousRing = ring - 1;
			int previousFrom = fromList.get(previousRing);

			if (ring == 1 && from == square) {
				return getSum(square - 1, previousRing, previousFrom);
			} else if (from == square) {
				return getSum(square - 1, previousRing, previousFrom)
						+ getSum(previousFrom, previousRing, previousFrom);
			} else {

				int positionInRing = square - from;
				int side = (2 * ring) - 1;
				int div = Math.floorDiv(positionInRing, side + 1) + 1;
				int stepsToCorner = ((side + 1) - ((positionInRing + 1) % (side + 1))) % (side + 1);

				if (div == 1) {
					if (stepsToCorner == 0) {
						return getSum(square - 1, ring, from) + getSum(x - 1, y - 1, previousRing, previousFrom);
					} else if (stepsToCorner == 1) {
						return getSum(square - 1, ring, from) + getSum(x - 1, y - 1, previousRing, previousFrom)
								+ getSum(x - 1, y, previousRing, previousFrom);
					} else {
						return getSum(square - 1, ring, from) + getSum(x - 1, y - 1, previousRing, previousFrom)
								+ getSum(x - 1, y, previousRing, previousFrom)
								+ getSum(x - 1, y + 1, previousRing, previousFrom);
					}
				} else if (div == 2) {
					if (stepsToCorner == 0) {
						return getSum(square - 1, ring, from) + getSum(x + 1, y - 1, previousRing, previousFrom);
					} else if (stepsToCorner == side && side == 1) {
						return getSum(square - 1, ring, from) + getSum(square - 2, ring, from)
								+ getSum(x, y - 1, previousRing, previousFrom);
					} else if (stepsToCorner == side) {
						return getSum(square - 1, ring, from) + getSum(square - 2, ring, from)
								+ getSum(x, y - 1, previousRing, previousFrom)
								+ getSum(x - 1, y - 1, previousRing, previousFrom);
					} else if (stepsToCorner == 1) {
						return getSum(square - 1, ring, from) + getSum(x + 1, y - 1, previousRing, previousFrom)
								+ getSum(x, y - 1, previousRing, previousFrom);
					} else {
						return getSum(square - 1, ring, from) + getSum(x + 1, y - 1, previousRing, previousFrom)
								+ getSum(x, y - 1, previousRing, previousFrom)
								+ getSum(x - 1, y - 1, previousRing, previousFrom);
					}
				} else if (div == 3) {
					if (stepsToCorner == 0) {
						return getSum(square - 1, ring, from) + getSum(x + 1, y + 1, previousRing, previousFrom);
					} else if (stepsToCorner == side && side == 1) {
						return getSum(square - 1, ring, from) + getSum(square - 2, ring, from)
								+ getSum(x + 1, y, previousRing, previousFrom);
					} else if (stepsToCorner == side) {
						return getSum(square - 1, ring, from) + getSum(square - 2, ring, from)
								+ getSum(x + 1, y, previousRing, previousFrom)
								+ getSum(x + 1, y - 1, previousRing, previousFrom);
					} else if (stepsToCorner == 1) {
						return getSum(square - 1, ring, from) + getSum(x + 1, y + 1, previousRing, previousFrom)
								+ getSum(x + 1, y, previousRing, previousFrom);
					} else {
						return getSum(square - 1, ring, from) + getSum(x + 1, y + 1, previousRing, previousFrom)
								+ getSum(x + 1, y, previousRing, previousFrom)
								+ getSum(x + 1, y - 1, previousRing, previousFrom);
					}
				} else {
					if (stepsToCorner == 0) {
						return getSum(square - 1, ring, from) + getSum(x - 1, y + 1, previousRing, previousFrom)
								+ getSum(from, ring, from);
					} else if (stepsToCorner == side && ring == 1) {
						return getSum(square - 1, ring, from) + getSum(square - 2, ring, from)
								+ getSum(x, y + 1, previousRing, previousFrom) + getSum(from, ring, from);
					} else if (stepsToCorner == side) {
						return getSum(square - 1, ring, from) + getSum(square - 2, ring, from)
								+ getSum(x, y + 1, previousRing, previousFrom)
								+ getSum(x + 1, y + 1, previousRing, previousFrom);
					} else if (stepsToCorner == 1) {
						return getSum(square - 1, ring, from) + getSum(x - 1, y + 1, previousRing, previousFrom)
								+ getSum(x, y + 1, previousRing, previousFrom) + getSum(from, ring, from);
					} else {
						return getSum(square - 1, ring, from) + getSum(x - 1, y + 1, previousRing, previousFrom)
								+ getSum(x, y + 1, previousRing, previousFrom)
								+ getSum(x + 1, y + 1, previousRing, previousFrom);
					}
				}
			}
		}
	}

	private static int getSum(int x, int y, int ring, int from) {
		if (x == 0 && y == 0) {
			return 1;
		} else {
			return getSum(squares.get(new Tuple(x, y)), ring, from);
		}
	}

	private static int getX(int square, int ring, int from) {
		if (ring == 0) {
			return 0;
		} else {
			if (from == square) {
				return getX(square - 1, ring - 1, fromList.get(ring - 1)) + 1;
			} else {
				int positionInRing = square - from;
				int side = (2 * ring) - 1;
				int div = Math.floorDiv(positionInRing, side + 1) + 1;

				if (div == 1) {
					return getX(square - 1, ring, from);
				} else if (div == 2) {
					return getX(square - 1, ring, from) - 1;
				} else if (div == 3) {
					return getX(square - 1, ring, from);
				} else {
					return getX(square - 1, ring, from) + 1;
				}
			}
		}
	}

	private static int getY(int square, int ring, int from) {
		if (ring == 0) {
			return 0;
		} else {
			if (from == square) {
				return getY(square - 1, ring - 1, fromList.get(ring - 1));
			} else {
				int positionInRing = square - from;
				int side = (2 * ring) - 1;
				int div = Math.floorDiv(positionInRing, side + 1) + 1;

				if (div == 1) {
					return getY(square - 1, ring, from) + 1;
				} else if (div == 2) {
					return getY(square - 1, ring, from);
				} else if (div == 3) {
					return getY(square - 1, ring, from) - 1;
				} else {
					return getY(square - 1, ring, from);
				}
			}
		}
	}

	public static void main(String args[]) {
		int maxSum = 361527;

		int sum = 0;
		int square = 1;
		do {
			sum = sumInSquare(square++);
		} while (sum < maxSum);

		System.out.println(sum);
	}
}
