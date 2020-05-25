package game;

/**
 * This class implements crops that can be grown in the farm
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Animal {
	/**
	 * The species of the animal
	 */
	private String type;
	/**
	 * The index of the animal arrayList
	 */
	private int index;
	/**
	 * The purchase price of the animal
	 */
	private int purchasePrice;
	/**
	 * The happiness of the animal
	 */
	private int happiness;
	/**
	 * The healthiness of the animal
	 */
	private int health;
	/**
	 * The rate of the growth of the animal's happiness everyday
	 */
	private int happinessGrowthRate;
	/**
	 * The amount of the animal
	 */
	private int amount = 0;
	
	/**
	 * Animal constructor
	 * 
	 * @param newType Species of the new animal
	 * @param newIndex Index of the animal arrayList
	 * @param newPrice Price of the new animal
	 * @param newHappiness Happiness of the new animal
	 * @param newHealth Health of the new animal
	 * @param newHappinessGR Rate of growth of happiness everyday for the new animal
	 */
	public Animal(String newType, int newIndex, int newPrice, int newHappiness, int newHealth, int newHappinessGR) {
		type = newType;
		index = newIndex;
		purchasePrice = newPrice;
		happiness = newHappiness;
		health = newHealth;
		happinessGrowthRate = newHappinessGR;
	}
	
	/**
	 * Returns the string representation of the animal object
	 * 
	 * @return The string representation of the animal object
	 */
	@Override
	public String toString() {
		return (amount + " " + type + " with happiness of " + happiness + " and health of " + health);
	}
	
	/**
	 * Returns the species of the animal
	 * 
	 * @return the species of the animal
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Returns the index of the arrayList of this animal
	 * 
	 * @return the index of the arrayList of this animal
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Returns the price of the animal
	 * 
	 * @return the purchase price of the animal
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Returns the money earned for tending the animal through feeding
	 * 
	 * @return the money reward for tending the animal
	 */
	public int getTendingReward() {
		return (happiness + health) / 5;
	}
	
	/**
	 * Returns the happiness level of the animal
	 * 
	 * @return the happiness level of the animal
	 */
	public int getHappiness() {
		return happiness;
	}
	
	/**
	 * Returns the healthiness level of the animal
	 * 
	 * @return the healthiness level of the animal
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Returns the growth rate of the happiness level everyday of the animal
	 * 
	 * @return the growth rate of the happiness level everyday of the animal
	 */
	public int getHappinessGrowthRate() {
		return happinessGrowthRate;
	}
	
	/**
	 * Returns the amount of the animal
	 * 
	 * @return the amount of the animal
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Add a certain amount of the animal through initializing or buying
	 * 
	 * @param addingAmount The amount that will be added
	 */
	public void addAnimals(int addingAmount) {
		amount += addingAmount;
	}
	
	/**
	 * Update the happiness level of the animal
	 * 
	 * @param amount The change to happiness level of the animal
	 */
	public void updateHappiness(int amount) {
		happiness += amount;
	}
	
	/**
	 * Update the growth rate of the happiness level
	 * 
	 * @param amount The change to the growth rate of the happiness level
	 */
	public void updateHappinessGrowth(int amount) {
		happinessGrowthRate += amount;
	}
	
	/**
	 * Update the healthiness of the animal
	 * 
	 * @param amount The change to the healthiness of the animal
	 */
	public void updateHealth(int amount) {
		health += amount;
	}
}
