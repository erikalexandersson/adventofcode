package se.erikalexandersson.adventofcode.helpers;

public class Point {

	private int id;
	private int x;
	private int y;
	private int z;

	private Velocity velocity;
	private Acceleration acceleration;

	public Point(int id, int x, int y, int z, Velocity velocity, Acceleration acceleration) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
		this.velocity = velocity;
		this.acceleration = acceleration;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public Acceleration getAcceleration() {
		return acceleration;
	}

	public void update() {
		velocity.update(acceleration);
		this.x += velocity.getVx();
		this.y += velocity.getVy();
		this.z += velocity.getVz();
	}

	public int getDistanceFromOrigin() {
		return Math.abs(x) + Math.abs(y) + Math.abs(z);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Point other = (Point) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
