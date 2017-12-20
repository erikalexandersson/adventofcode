package se.erikalexandersson.adventofcode.helpers;

public class Velocity {

	private int vx;
	private int vy;
	private int vz;

	public Velocity(int vx, int vy, int vz) {
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
	}

	public int getVx() {
		return vx;
	}

	public int getVy() {
		return vy;
	}

	public int getVz() {
		return vz;
	}

	public void update(Acceleration acceleration) {
		this.vx += acceleration.getAx();
		this.vy += acceleration.getAy();
		this.vz += acceleration.getAz();
	}

}
