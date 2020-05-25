package game;

/**
 * This class creates the FreshHay item using the method specified by the Item interface
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class FreshHay implements Item {
	/**
	 * The amount of FreshHay owned
	 */
	private int amount;
	/**
	 * The string name of FreshHay
	 */
	private String name = "Fresh Hay";
	/**
	 * The integer purchase price of FreshHay
	 */
	private int price = 2;
	
	/**
	 * FreshHay constructor
	 * 
	 * Sets the default amount to 0 when creating the farm
	 */
	public FreshHay() {
		amount = 0;
	}
	
	/**
	 * FreshHay constructor
	 * 
	 * @param initialAmount the initial amount when selecting the farm Type
	 */
	public FreshHay(int initialAmount) {
		amount = initialAmount;
	}
	
	/**
	 * Changes a given Animal type's Health and HappinessGrowth and lowers the amount of FreshHay remaining
	 * 
	 * @param inputFarm is the target Farm
	 * @param typeIndex is the target Animal type
	 */
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHealth(2);
			animal.updateHappinessGrowth(1);
		}
		this.changeAmount(-1);
	}
	
	/**
	 * Returns the amount of FreshHay owned
	 * 
	 * @return the amount of FreshHay owned
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Alters the amount of FreshHay remaining
	 * 
	 * @param the quantity by which the amount should be altered
	 */
	public void changeAmount(int change) {
		amount += change;
	}
	
	/**
	 * Returns the string name of FreshHay
	 * 
	 * @return the string name of FreshHay
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the integer price of FreshHay
	 * 
	 * @return the integer price of FreshHay
	 */
	public int getPrice() {
		return price;
	}
}

