package game;

public class Animal {
	
	private String type;
	private int index;
	private int purchasePrice;
	private int happiness;
	private int health;
	private int happinessGrowthRate;
	private int healthGrowthRate;
	private int amount = 0;
	
	public Animal(String newType, int newIndex, int newPrice, int newHappiness, int newHealth, int newHappinessGR, int newHealthGR) {
		type = newType;
		index = newIndex;
		purchasePrice = newPrice;
		happiness = newHappiness;
		health = newHealth;
		happinessGrowthRate = newHappinessGR;
		healthGrowthRate = newHealthGR;
	}
	
	public String toString() {
		return (amount + " " + type + " with happiness of " + happiness + " and health of " + health);
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
	
	public int getTendingReward() {
		if (happiness + health >= 10) {
			return 2;
		}
		else {
			return 1;
		}
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
	
	public void updateHappinessGrowth(int amount) {
		happinessGrowthRate += amount;
	}
	
	public void updateHealth(int amount) {
		health += amount;
	}

	public void updateHealthGrowth(int amount) {
		healthGrowthRate += amount;
	}
}
