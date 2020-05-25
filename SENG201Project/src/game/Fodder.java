package game;

/**
 * This class creates the Fodder item using the method specified by the Item interface
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Fodder implements Item {
	/**
	 * The amount of Fodder owned
	 */
	private int amount;
	/**
	 * The string name of Fodder
	 */
	private String name = "Fodder";
	/**
	 * The integer purchase price of Fodder
	 */
	private int price = 1;
	
	/**
	 * Fodder constructor
	 * 
	 * Sets the default amount to 0 when creating the farm
	 */
	public Fodder() {
		amount = 0;
	}
	
	/**
	 * Fodder constructor
	 * 
	 * @param initialAmount the initial amount when selecting the farm Type
	 */
	public Fodder(int initialAmount) {
		amount = initialAmount;
	}
	
	/**
	 * Changes a given Animal type's Health and HappinessGrowth and lowers the amount of Fodder remaining
	 * 
	 * @param inputFarm is the target Farm
	 * @param typeIndex is the target Animal type
	 */
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHealth(1);
		}
		this.changeAmount(-1);
	}
	
	/**
	 * Returns the amount of Fodder owned
	 * 
	 * @return the amount of Fodder owned
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Alters the amount of Fodder remaining
	 * 
	 * @param the quantity by which the amount should be altered
	 */
	public void changeAmount(int change) {
		amount += change;
	}
	
	/**
	 * Returns the string name of Fodder
	 * 
	 * @return the string name of Fodder
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the integer price of Fodder
	 * 
	 * @return the integer price of Fodder
	 */
	public int getPrice() {
		return price;
	}
}

