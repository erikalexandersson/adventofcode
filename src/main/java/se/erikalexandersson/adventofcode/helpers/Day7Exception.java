package se.erikalexandersson.adventofcode.helpers;

@SuppressWarnings("serial")
public class Day7Exception extends Exception {

	public int weight;

	public Day7Exception(int weight) {
		this.weight = weight;
	}

}
