package se.erikalexandersson.adventofcode.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Triplet {

	public int x;
	public int y;
	public int z;

	public Triplet(String str) {
		String regex = ".*<\\s*(-?\\d+),\\s*(-?\\d+),\\s*(-?\\d+).*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		matcher.matches();
		this.x = Integer.parseInt(matcher.group(1));
		this.y = Integer.parseInt(matcher.group(2));
		this.z = Integer.parseInt(matcher.group(3));
	}
}