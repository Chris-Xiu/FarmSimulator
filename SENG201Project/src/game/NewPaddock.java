package game;

/**
 * This class creates the NewPaddock item using the method specified by the Item interface
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class NewPaddock implements Item {
	/**
	 * The amount of NewPaddock owned
	 */
	private int amount;
	/**
	 * The string name of NewPaddock
	 */
	private String name = "New Paddock";
	/**
	 * The integer purchase price of NewPaddock
	 */
	private int price = 4;
	
	/**
	 * NewPaddock constructor
	 * 
	 * Sets the default amount to 0 when creating the farm
	 */
	public NewPaddock() {
		amount = 0;
	}
	
	/**
	 * NewPaddock constructor
	 * 
	 * @param initialAmount the initial amount when selecting the farm Type
	 */
	public NewPaddock(int initialAmount) {
		amount = initialAmount;
	}
	
	/**
	 * Changes a given Animal type's Health and HappinessGrowth and lowers the amount of NewPaddock remaining
	 * 
	 * @param inputFarm is the target Farm
	 * @param typeIndex is the target Animal type
	 */
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHealth(4);
			animal.updateHappinessGrowth(2);
		}
		this.changeAmount(-1);
	}
	
	/**
	 * Returns the amount of NewPaddock owned
	 * 
	 * @return the amount of NewPaddock owned
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Alters the amount of NewPaddock remaining
	 * 
	 * @param the quantity by which the amount should be altered
	 */
	public void changeAmount(int change) {
		amount += change;
	}
	
	/**
	 * Returns the string name of NewPaddock
	 * 
	 * @return the string name of NewPaddock
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the integer price of NewPaddock
	 * 
	 * @return the integer price of NewPaddock
	 */
	public int getPrice() {
		return price;
	}
}

