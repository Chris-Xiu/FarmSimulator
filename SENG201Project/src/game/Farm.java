package game;
import java.util.*;

public class Farm {
	
	private String name;
	private Farmer player;
	private int moneyOwned;
	private ArrayList<ArrayList<Crop>> cropsOwned;
	private ArrayList<ArrayList<Animal>> animalsOwned;

	public static final String [] animalReference = {"Cow", "Sheep", "Deer"}; 
	public static final String [] cropReference = {"Corn", "Lettuce", "Potato", "Wheat"};
	public static final String [] itemReference = {"1080", "Fertilizer", "Irrigation", "Fodder", "Fresh Hay", "New Paddock"}; 
	
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
	
	public ArrayList<ArrayList<Animal>> getAnimalList() {
		return animalsOwned;
	}
	
	public ArrayList<ArrayList<Crop>> getCropList() {
		return cropsOwned;
	}
	
	public ArrayList<Item> getItemList() {
		return itemsOwned;
	}
	
	//Creates a list of type's that an item can be applied to. Needs an error condition if none are owned.
	public ArrayList<Integer> getCropTypeList() {
		ArrayList<Integer> queryList = new ArrayList<Integer>();
		for (int i = 0; i < cropsOwned.size(); i++) {
			if (!cropsOwned.get(i).isEmpty()) {
				queryList.add(i);
			}
		}
		return queryList;
	}
	
	//Creates a list of type's that an item can be applied to. Needs an error condition if none are owned.
	public ArrayList<Integer> getAnimalTypeList() {
		ArrayList<Integer> queryList = new ArrayList<Integer>();
		for (int i = 0; i < animalsOwned.size(); i++) {
			if (!animalsOwned.get(i).isEmpty()) {
				queryList.add(i);
			}
		}
		return queryList;
	}
	
	//Creates a list of items available. Needs an error condition if none are owned.
	public ArrayList<Integer> getItemAvailable(int start, int end) {
		ArrayList<Integer> queryList = new ArrayList<Integer>();
		for (int i = start; i < end; i++) {
			if (itemsOwned.get(i).getAmount() != 0) {
				queryList.add(i);
			}
		}
		return queryList;
	}
	
	//Returns the index of a user selected type,
	public static int selectType(ArrayList<Integer> queryList, String[] queryReference) {
		int index = 1;
		Scanner selector = new Scanner(System.in);
		System.out.println("Please select a type: ");
		for (int target: queryList) {
			System.out.println("\n" + index + " " + queryReference[target]);
			index++;
		}
		//User input is taken, converted to an integer, and the correct index for the storage list is retrieved.
		int getIndex = selector.nextInt();
		int typeIndex = queryList.get(getIndex -1);
		//Returns the index
		return typeIndex;
	}
	
	public void buyItem(Item newItem) {
		//newItem.amount +=1;
		newItem.changeAmount(1);
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
	
	// Should be more specific
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
	
	public void buyAnimals(int amount) {
		Cow newAnimal = new Cow();
		newAnimal.addAnimals(amount);
		animalsOwned.get(newAnimal.getIndex()).add(newAnimal);
	}
	
	public void playWithAnimals(int type) {
		for (Animal animal: animalsOwned.get(type)) {
			animal.updateHappiness(1);
		}
	}
	
	public void feedAnimals(int type) {
		for (Animal animal: animalsOwned.get(type)) {
			animal.updateHealth(1);
		}
		
	}
	
	public ArrayList<ArrayList<Crop>> listCrops() {
		return cropsOwned;
	}
	
	public ArrayList<ArrayList<Animal>> listAnimals() {
		return animalsOwned;
	}

}
