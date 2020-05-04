package game;
import java.util.ArrayList;

public class Farm {
	
	private String name;
	private Farmer player;
	private int moneyOwned;
	private ArrayList<Animal> animalsOwned;
	private ArrayList<Crop> cropsOwned;
	private ArrayList<Item> itemsOwned;
	private int growingBonus;
	private int happinessBonus;
	public static int maxCrops = 10;
	public static int amountOfCrops = 0;
	public static int maxHappiness = 10;
	
	public Farm(int startingMoney, ArrayList<Animal> startingAnimals, ArrayList<Crop> startingCrops, ArrayList<Item> startingItems, 
			int newGrowingBonus, int newHappinessBonus) {
		moneyOwned = startingMoney;
		animalsOwned = startingAnimals;
		cropsOwned = startingCrops;
		itemsOwned = startingItems;
		growingBonus = newGrowingBonus;
		happinessBonus = newHappinessBonus;
	}
	
	public String toString() {
		return ("The farm has " + moneyOwned + " dollars.");
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setFarmer(Farmer newFarmer) {
		player = newFarmer;
	}
	
	public void buyCrops(int amount) {
		Crop newCrop = new Corn();
		
		if (amount + amountOfCrops > maxCrops) {
			System.out.println("Not enough space to plant!");
		} else if (newCrop.getPurchasePrice() * amount > moneyOwned) {
			System.out.println("Not enough money to buy!");
		} else {
			newCrop.addCrops(amount);
			cropsOwned.add(newCrop);
			moneyOwned -= newCrop.getPurchasePrice() * amount;
			amountOfCrops += amount;
		}
	}
	
	public void harvestCrops() {
		for (Crop crop: cropsOwned) {
			if (crop.getDaysUntilHarvest() == 0) {
				String type = crop.getType();
				int price = crop.getSellPrice();
				int amount = crop.getAmount();
				int earning = price * amount;
				moneyOwned += earning;
				System.out.println(amount + type + "(s) sold, " + earning + "dollars earned");
				cropsOwned.remove(crop);
			}
		}
	}
	
	public void waterCrops(int index) {
		for (Crop crop: cropsOwned) {
			if (crop.getType() == Crop.allTypes.get(index)) {
				crop.updateDays(1);
			}
		}
	}
	
	public void buyAnimals(int amount) {
		Cow newCoW = new Cow();
		newCoW.addAnimals(amount);
		animalsOwned.add(newCoW);
	}
	
	public void playWithAnimals() {
		for (Animal animal: animalsOwned) {
			animal.updateHappiness();
		}
	}
}
