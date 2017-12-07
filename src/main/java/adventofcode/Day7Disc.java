package adventofcode;

public class Day7Disc {

	private int weight;
	private Day7Program2 heldBy;
	private String heldByProgramName;
	private Day7Program2 program;
	private String programName;

	public Day7Disc(String heldByProgramName, String programName) {
		this.heldByProgramName = heldByProgramName;
		this.programName = programName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Day7Program2 getProgram() {
		return program;
	}

	public void setProgram(Day7Program2 program) {
		this.program = program;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Day7Program2 getHeldBy() {
		return heldBy;
	}

	public void setHeldBy(Day7Program2 heldBy) {
		this.heldBy = heldBy;
	}

	public String getHeldByProgramName() {
		return heldByProgramName;
	}

	public void setHeldByProgramName(String heldByProgramName) {
		this.heldByProgramName = heldByProgramName;
	}

}
