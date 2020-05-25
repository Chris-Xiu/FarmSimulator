package game;

/**
 * This class creates the Irrigation item using the method specified by the Item interface
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Irrigation implements Item {
	/**
	 * The amount of Irrigation owned
	 */
	private int amount;
	/**
	 * The string name of Irrigation
	 */
	private String name = "Irrigation";
	/**
	 * The integer purchase price of Irrigation
	 */
	private int price = 4;
	
	/**
	 * Irrigation constructor
	 * 
	 * Sets the default amount to 0 when creating the farm
	 */
	public Irrigation() {
		amount = 0;
	}
	
	/**
	 * Irrigation constructor
	 * 
	 * @param initialAmount the initial amount when selecting the farm Type
	 */
	public Irrigation(int initialAmount) {
		amount = initialAmount;
	}
	
	/**
	 * Changes a given Crop type's days until harvest and lowers the amount of Irrigation remaining
	 * 
	 * @param inputFarm is the target Farm
	 * @param typeIndex is the target Crop type
	 */
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(4);
		}
		this.changeAmount(-1);
	}
	
	/**
	 * Returns the amount of Irrigation owned
	 * 
	 * @return the amount of Irrigation owned
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Alters the amount of Irrigation remaining
	 * 
	 * @param the quantity by which the amount should be altered
	 */
	public void changeAmount(int change) {
		amount += change;
	}
	
	/**
	 * Returns the string name of Irrigation
	 * 
	 * @return the string name of Irrigation
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the integer price of Irrigation
	 * 
	 * @return the integer price of Irrigation
	 */
	public int getPrice() {
		return price;
	}
}
