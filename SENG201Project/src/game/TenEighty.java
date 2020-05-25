package game;

/**
 * This class creates the TenEighty item using the method specified by the Item interface
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

import java.util.ArrayList;

public class TenEighty implements Item {
	/**
	 * The amount of TenEighty owned
	 */
	private int amount;
	/**
	 * The string name of TenEighty
	 */
	private String name = "1080";
	/**
	 * The integer purchase price of TenEighty
	 */
	private int price = 1;
	
	/**
	 * TenEighty constructor
	 * 
	 * Sets the default amount to 0 when creating the farm
	 */
	public TenEighty() {
		amount = 0;
	}
	
	/**
	 * TenEighty constructor
	 * 
	 * @param initialAmount the initial amount when selecting the farm Type
	 */
	public TenEighty(int initialAmount) {
		amount = initialAmount;
	}

	/**
	 * Changes a given Crop type's days until harvest and lowers the amount of TenEighty remaining
	 * 
	 * @param inputFarm is the target Farm
	 * @param typeIndex is the target Crop type
	 */
	public void useItem(Farm inputFarm, int typeIndex) {
		//Reduce time to harvest by 2
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(2);
		}
		//Reduce all animals health by 1 but only if it is larger than 0.
		for (ArrayList<Animal> list: inputFarm.getAnimalList()) {
			for (Animal animal: list) {
				if (animal.getHealth() > 0) {
					animal.updateHealth(-1);
				}
							}
		}
		this.changeAmount(-1);
	}
	
	/**
	 * Returns the amount of TenEighty owned
	 * 
	 * @return the amount of TenEighty owned
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Alters the amount of TenEighty remaining
	 * 
	 * @param the quantity by which the amount should be altered
	 */
	public void changeAmount(int change) {
		amount += change;
	}
	
	/**
	 * Returns the string name of TenEighty
	 * 
	 * @return the string name of TenEighty
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the integer price of TenEighty
	 * 
	 * @return the integer price of TenEighty
	 */
	public int getPrice() {
		return price;
	}
}
