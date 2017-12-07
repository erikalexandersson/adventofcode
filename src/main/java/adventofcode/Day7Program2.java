package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Day7Program2 {

	private String name;
	private int weight;

	private Day7Disc standsOn;
	private List<Day7Disc> discs;

	public Day7Program2(String name, int weight) {
		this.name = name;
		this.weight = weight;
		this.discs = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Day7Disc> getDiscs() {
		return discs;
	}

	public void setDiscs(List<Day7Disc> discs) {
		this.discs = discs;
	}

	public Day7Disc getStandsOn() {
		return standsOn;
	}

	public void setStandsOn(Day7Disc standsOn) {
		this.standsOn = standsOn;
	}

}
