package game;

/**
 * This class creates the Fertilizer item using the method specified by the Item interface
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Fertilizer implements Item {
	/**
	 * The amount of Fertilizer owned
	 */
	private int amount;
	/**
	 * The string name of Fertilizer
	 */
	private String name = "Fertilizer";
	/**
	 * The integer purchase price of Fertilizer
	 */
	private int price = 2;
	
	/**
	 * Fertilizer constructor
	 * 
	 * Sets the default amount to 0 when creating the farm
	 */
	public Fertilizer() {
		amount = 0;
	}
	
	/**
	 * Fertilizer constructor
	 * 
	 * @param initialAmount the initial amount when selecting the farm Type
	 */
	public Fertilizer(int initialAmount) {
		amount = initialAmount;
	}
	
	/**
	 * Changes a given Crop type's days until harvest and lowers the amount of Fertilizer remaining
	 * 
	 * @param inputFarm is the target Farm
	 * @param typeIndex is the target Crop type
	 */
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(2);
		}
		this.changeAmount(-1);
	}
	
	/**
	 * Returns the amount of Fertilizer owned
	 * 
	 * @return the amount of Fertilizer owned
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Alters the amount of Fertilizer remaining
	 * 
	 * @param the quantity by which the amount should be altered
	 */
	public void changeAmount(int change) {
		amount += change;
	}
	
	/**
	 * Returns the string name of Fertilizer
	 * 
	 * @return the string name of Fertilizer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the integer price of Fertilizer
	 * 
	 * @return the integer price of Fertilizer
	 */
	public int getPrice() {
		return price;
	}
}
