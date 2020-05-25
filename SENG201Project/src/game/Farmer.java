package game;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Farmer {
	private String name;
	private int age;
	
	public Farmer(String playerName, int playerAge) {
		name = playerName;
		age = playerAge;
	}
	
	public String toString() {
		return (name + " is a " + age + " years old farmer.");
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
