package game;
import java.util.*;

public class Farm {
	
	private String name;
	private Farmer player;
	private int moneyOwned;
	private ArrayList<ArrayList<Crop>> cropsOwned;
	private ArrayList<ArrayList<Animal>> animalsOwned;

	public static final String [] animalReference = {"Cow", "Sheep", "Deer"}; 
	public static final String [] cropReference = {"Corn", "Lettuce", "Potato", "Wheat", "Tomato", "Carrot"};
	public static final String [] itemReference = {"Hoe", "Fertilizer", "Irrigation", "Fodder", "FreshHay", "NewPaddock"};
	
	private ArrayList<Item> itemsOwned;
	private int growingBonus;
	private int happinessBonus;
	public static int maxCrops = 10;
	public static int amountOfCrops = 0;
	public static int maxHappiness = 10;
	
	
	
	public Farm(int startingMoney, ArrayList<Crop> startingCrops, ArrayList<Animal> startingAnimals, ArrayList<Item> startingItems, 
			int newGrowingBonus, int newHappinessBonus) {
		moneyOwned = startingMoney;
		itemsOwned = startingItems;
		growingBonus = newGrowingBonus;
		happinessBonus = newHappinessBonus;
		
		cropsOwned = new ArrayList<ArrayList<Crop>>();
		animalsOwned = new ArrayList<ArrayList<Animal>>();
		for (int i = 0; i < 3; i++) {
			cropsOwned.add(new ArrayList<Crop>());
		}
		for (int i = 0; i < 6; i++) {
			animalsOwned.add(new ArrayList<Animal>());
		}

		if (!startingCrops.isEmpty()) {
			for (Crop crop: startingCrops) {
				cropsOwned.get(crop.getIndex()).add(crop);
			}

		}
		if (!startingAnimals.isEmpty()) {
			for (Animal animal: startingAnimals) {
				animalsOwned.get(animal.getIndex()).add(animal);
			}
		}
	}
	
	public static int getTypeIndex(String typeString, String[] reference) {
		for (int i = 0; i < reference.length; i++) {
			if (reference[i] == typeString) {
				return i;
			}
		}
		//It doesn't work if I return nothing outside of the if condition. Alter this to an error message
		return -1;
	}
	
	public void displayCropOverview() {
		for (ArrayList<Crop> list: cropsOwned) {
			if (!list.isEmpty()) {
				for (Crop crop: list) {
					System.out.println("You own " + crop.getAmount() + " " + crop.getType() + " which have " + crop.getDaysUntilHarvest() + " days to harvest.");
				}
			}
		}
	}
	
	public void displayAnimalOverview() {
		for (ArrayList<Animal> list: animalsOwned) {
			if (!list.isEmpty()) {
				for (Animal animal: list) {
					System.out.println("You own " + animal.getAmount() + " " + animal.getType() + " which have a happiness of " + animal.getHappiness() + " and a health of " + animal.getHealth() + ".");
				}
			}
		}
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
	
	public void buyCrops(int amount, int index) {
		Crop newCrop;
		if (index == 1) {
			newCrop = new Corn();
		} else {
			newCrop = new Corn();
		}
		
		if (amount + amountOfCrops > maxCrops) {
			System.out.println("Not enough space to plant!");
		} else if (newCrop.getPurchasePrice() * amount > moneyOwned) {
			System.out.println("Not enough money to buy!");
		} else {
			newCrop.addCrops(amount);
			cropsOwned.get(newCrop.getIndex()).add(newCrop);
			moneyOwned -= newCrop.getPurchasePrice() * amount;
			amountOfCrops += amount;
		}
	}
	
	public void harvestCrops() {
		for (ArrayList<Crop> list: cropsOwned) {
			
			for (Crop crop: new ArrayList<>(list)) {
				if (crop.getDaysUntilHarvest() == 0) {
					String type = crop.getType();
					int price = crop.getSellPrice();
					int amount = crop.getAmount();
					int earning = price * amount;
					moneyOwned += earning;
					System.out.println(amount + type + "(s) sold, " + earning + "dollars earned");
					list.remove(crop);
				}
			}
		}
	}
	
	public void waterCrops(int index) {
		for (Crop crop: cropsOwned.get(index)) {
			crop.updateDays(1);
		}
	}
	
	public void buyAnimals(int amount, int index) {
		Animal newAnimal;
		if (index == 1) {
			newAnimal = new Cow();
		} else {
			newAnimal = new Cow();
		}
		
		if (newAnimal.getPurchasePrice() * amount > moneyOwned) {
			System.out.println("Not enough money to buy!");
		} else {
			newAnimal.addAnimals(amount);
			animalsOwned.get(newAnimal.getIndex()).add(newAnimal);
			moneyOwned -= newAnimal.getPurchasePrice() * amount;
		}
	}
	
	public void playWithAnimals() {
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				animal.updateHappiness(1);
			}
		}
	}
	
	public ArrayList<ArrayList<Crop>> listCrops() {
		return cropsOwned;
	}
	
	public ArrayList<ArrayList<Animal>> listAnimals() {
		return animalsOwned;
	}
	
	public static void tending() {
		maxCrops += 5;
		maxHappiness += 5;
	}
}
