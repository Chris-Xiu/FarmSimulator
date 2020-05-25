package game;

/**
 * This class creates a Potato as a child of the Crop class
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Potato extends Crop {
	/**
	 * Potato constructor
	 * 
	 * Instantiates a Potato with the parameters required by the Crop parent
	 */
	public Potato() {
		super("Potato", 2, 2, 8, 5);
	}
}
