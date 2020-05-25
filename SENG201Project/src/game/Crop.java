package game;
import java.util.*;

/**
 * This class implements crops that can be grown in the farm
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Crop {
	/**
	 * The type of crop
	 */
	private String type;
	/**
	 * The index of the crop arrayList 
	 */
	private int index;
	/**
	 * The purchase price of the crop
	 */
	private int purchasePrice;
	/**
	 * The money gained from harvesting the crop
	 */
	private int sellPrice;
	/**
	 * The number of days until the crop can be harvested
	 */
	private int daysUntilHarvest;
	/**
	 * The amount purchased of the crop
	 */
	private int amount = 0;
	
	/**
	 * Crop constructor
	 * 
	 * @param newType type of the new animal
	 * @param newIndex Index of the crop arrayList
	 * @param newPrice Price of the new crop
	 * @param newSPrice Harvest value of the new crop
	 * @param maturity days until harvest for the new crop
	 */
	public Crop(String newType, int newIndex, int newPPrice, int newSPrice, int maturity) {
		type = newType;
		index = newIndex;
		purchasePrice = newPPrice;
		sellPrice = newSPrice;
		daysUntilHarvest = maturity;
	}
	
	/**
	 * Returns the string representation of the crop object
	 * 
	 * @return The string representation of the crop object
	 */
	public String toString() {
		return (amount + " " + type + " which can be harvested in " + daysUntilHarvest + "days");
	}
	
	/**
	 * Returns the string representation of the crop type
	 * 
	 * @return the string representation of the crop type
	 */	
	public String getType() {
		return type;
	}
	
	/**
	 * Returns the integer of the crop's index within the arrayList
	 * 
	 * @return the integer of the crop's index
	 */	
	public int getIndex() {
		return index;
	}
	
	/**
	 * Returns the integer of the crop's price in the shop
	 * 
	 * @return the integer of the crop's price
	 */	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Returns the integer of the money gained from harvesting the crop
	 * 
	 * @return the integer of harvest money gained
	 */	
	public int getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Returns the integer of the days remaining until the crop can be harvested
	 * 
	 * @return the integer of days until harvest
	 */
	public int getDaysUntilHarvest() {
		return daysUntilHarvest;
	}
	
	/**
	 * Returns the integer of the how many you own of this crop
	 * 
	 * @return the integer of how many you own of this crop
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Adds newly purchased crops to the amount
	 * 
	 * @param addingAmount the quantity of new crops purchased
	 */
	public void addCrops(int addingAmount) {
		amount += addingAmount;
	}
	
	/**
	 * Shortens the days remaining until a crop can be harvested by a given integer, and limits the minimum to 0. 
	 * 
	 * @param shortenBy the number of days the harvest moves closer
	 */
	public void updateDays(int shortenBy) {
		if (daysUntilHarvest - shortenBy < 0) {
			daysUntilHarvest = 0;
		} else {
			daysUntilHarvest -= shortenBy;
		}
	}
}
