package game;

/**
 * This class stores the attributes of the Farm's Farmer
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Farmer {
	/**
	 * The Farmers name
	 */
	private String name;
	/**
	 * The Farmers age
	 */
	private int age;
	
	/**
	 * Farmer constructor 
	 * 
	 * @param playerName is the name of a new player
	 * @param playerAge is the age of a new player
	 */
	public Farmer(String playerName, int playerAge) {
		name = playerName;
		age = playerAge;
	}
	
	/**
	 * Returns a sentence of the Farmers attributes
	 * 
	 * @return a string of the Farmers attributes
	 */
	public String toString() {
		return (name + " is a " + age + " years old farmer.");
	}
	
	/**
	 * Returns the Farmers name
	 * 
	 * @return the Farmers name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the Farmers age
	 * 
	 * @return the Farmers age
	 */
	public int getAge() {
		return age;
	}
}
