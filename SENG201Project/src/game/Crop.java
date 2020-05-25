package game;
import java.util.*;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Crop {
	
	private String type;
	private int index;
	private int purchasePrice;
	private int sellPrice;
	private int daysUntilHarvest;
	private int amount = 0;
	
	public Crop(String newType, int newIndex, int newPPrice, int newSPrice, int maturity) {
		type = newType;
		index = newIndex;
		purchasePrice = newPPrice;
		sellPrice = newSPrice;
		daysUntilHarvest = maturity;
	}
	
	public String toString() {
		return (amount + " " + type + " which can be harvested in " + daysUntilHarvest + " days");
	}
	
	public String getType() {
		return type;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getSellPrice() {
		return sellPrice;
	}
	
	public int getDaysUntilHarvest() {
		return daysUntilHarvest;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void addCrops(int addingAmount) {
		amount += addingAmount;
	}
	
	public void updateDays(int shortenBy) {
		if (daysUntilHarvest - shortenBy < 0) {
			daysUntilHarvest = 0;
		} else {
			daysUntilHarvest -= shortenBy;
		}
	}
}
