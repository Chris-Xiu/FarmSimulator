package game;

/**
 * This class creates Wheat as a child of the Crop class
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Wheat extends Crop {
	/**
	 * Wheat constructor
	 * 
	 * Instantiates Wheat with the parameters required by the Crop parent
	 */
	public Wheat() {
		super("Wheat", 3, 2, 5, 3);
	}
}
