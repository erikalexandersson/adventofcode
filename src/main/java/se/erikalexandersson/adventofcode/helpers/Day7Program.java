package se.erikalexandersson.adventofcode.helpers;

import java.util.ArrayList;
import java.util.List;

public class Day7Program {

	private String name;
	private int weight;

	private List<String> discs;

	public Day7Program(String name, int weight) {
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

	public List<String> getDiscs() {
		return discs;
	}

	public void setDiscs(List<String> discs) {
		this.discs = discs;
	}

}
