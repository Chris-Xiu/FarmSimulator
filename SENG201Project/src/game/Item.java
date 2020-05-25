package game;

/**
 * This interface defines the methods that the farm's items must use
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

import java.util.ArrayList;

public interface Item {
	/**
	 * This uses the item on a target type and applies the items effect
	 * 
	 * @param inputFarm The target Farm object
	 * @param typeIndex the type of Animal or Crop within the corresponding arrayList
	 */
	public void useItem(Farm inputFarm, int typeIndex);
	/**
	 * Returns the integer of how many of this item is owned
	 * 
	 * @return the integer of how many of this item is owned
	 */
	public int getAmount();
	/**
	 * Alters the amount of how many of this item is owned
	 * 
	 * @param change is the quantity the amount is altered by
	 */
	public void changeAmount(int change);
	/**
	 * Returns the String of the items name
	 * 
	 * @return the String of the items name
	 */
	public String getName();
	/**
	 * Returns the price of the item
	 * 
	 * @return the price of the item
	 */
	public int getPrice();
	}
