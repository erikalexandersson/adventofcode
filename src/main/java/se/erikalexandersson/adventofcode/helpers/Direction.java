package se.erikalexandersson.adventofcode.helpers;

public enum Direction {
	SOUTH, NORTH, EAST, WEST;

	public Direction turnRight() {
		switch (this) {
		case SOUTH:
			return WEST;
		case WEST:
			return NORTH;
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		default:
			return this;
		}
	}

	public Direction turnLeft() {
		switch (this) {
		case SOUTH:
			return EAST;
		case EAST:
			return NORTH;
		case NORTH:
			return WEST;
		case WEST:
			return SOUTH;
		default:
			return this;
		}
	}
}
