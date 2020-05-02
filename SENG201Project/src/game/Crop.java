package game;

public class Crop {
	
	private String type;
	private int purchasePrice;
	private int sellPrice;
	private int daysUntilHarvest;
	private int amount = 0;
	
	public Crop(String newType, int newPPrice, int newSPrice, int maturity) {
		type = newType;
		purchasePrice = newPPrice;
		sellPrice = newSPrice;
		daysUntilHarvest = maturity;
	}
	
	public String toString() {
		return ("The name of the crop is " + type + ", currently you have " + amount + " in your farm. The price of it is " + purchasePrice 
				+ " dollar and you can sell it for " + sellPrice + " dollar. You can harvest it in " + daysUntilHarvest + " days.");
	}
	
	public String getType() {
		return type;
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
	
	public void updateAmount(int changedAmount) {
		amount += changedAmount;
	}
}
