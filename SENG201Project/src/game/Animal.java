package game;

public class Animal {
	
	private String type;
	private int purchasePrice;
	private int tendingReward;
	private int happiness;
	private int health;
	private int happinessGrowthRate;
	private int healthGrowthRate;
	private int amount = 0;
	
	public Animal(String newType, int newPrice, int newTendingReward, int newHappiness, int newHealth, int newHappinessGR, int newHealthGR) {
		type = newType;
		purchasePrice = newPrice;
		tendingReward = newTendingReward;
		happiness = newHappiness;
		health = newHealth;
		happinessGrowthRate = newHappinessGR;
		healthGrowthRate = newHealthGR;
	}
	
	public String toString() {
		return ("The name of the animal is " + type + ", currently you have " + amount + " in your farm. The price of it is " + purchasePrice + 
				" dollar and you earn " + tendingReward + " dollar by tending it. Their happiness is at level " + happiness 
				+ " and their health is at level " + health + ".");
	}
	
	public String getType() {
		return type;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getTendingReward() {
		return tendingReward;
	}
	
	public int getHappiness() {
		return happiness;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getHappinessGrowthRate() {
		return happinessGrowthRate;
	}
	
	public int getHealthGrowthRate() {
		return healthGrowthRate;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void addAnimals(int addingAmount) {
		amount += addingAmount;
	}
	
	public void updateHappiness(int amount) {
		happiness += amount;
	}
}
