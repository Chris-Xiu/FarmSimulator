package game;
import java.util.*;

/**
 * This class implements farm that can hold a farmer, their wealth, their crops, animals and items
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Farm {
	
	/**
	 * The name of the farm
	 */
	private String name;
	/**
	 * The farmer that lives in the farm
	 */
	private Farmer player;
	/**
	 * The amount of money the farmer has
	 */
	private int moneyOwned;
	/**
	 * The crops the farmer has in a nested list
	 */
	private ArrayList<ArrayList<Crop>> cropsOwned;
	/**
	 * The animals the farmer has in a nested list
	 */
	private ArrayList<ArrayList<Animal>> animalsOwned;
	/**
	 * The items the farmer has in a list
	 */
	private ArrayList<Item> itemsOwned;
	/**
	 * The maximum amount of crops that can be planted
	 */
	private int maxCrops = 10;
	/**
	 * The maximum amount of animals that can be raised
	 */
	private int maxAnimals = 10;
	/**
	 * The current amount of crops in the farm
	 */
	private int amountOfCrops = 0;
	/**
	 * The current amount of animal in the farm
	 */
	private int amountOfAnimals = 0;
	/**
	 * The name of the different types of animals
	 */
	public static final String [] animalReference = {"Cow", "Sheep", "Deer"}; 
	/**
	 * The name of the different types of crops
	 */
	public static final String [] cropReference = {"Corn", "Lettuce", "Potato", "Wheat", "Tomato", "Carrot"};
	/**
	 * The name of the different items
	 */
	public static final String [] itemReference = {"1080", "Fertilizer", "Irrigation", "Fodder", "Fresh Hay", "New Paddock"};
	
	
	
	/**
	 * Farm constructor
	 * 
	 * @param Type The type of the farm selected when creating the farm in setup Screen
	 */
	public Farm(String type) {
		moneyOwned = 10;
		cropsOwned = new ArrayList<ArrayList<Crop>>();
		animalsOwned = new ArrayList<ArrayList<Animal>>();
		itemsOwned = new ArrayList<Item>();
		
		for (int i = 0; i < 6; i++) {
			cropsOwned.add(new ArrayList<Crop>());
		}
		for (int i = 0; i < 3; i++) {
			animalsOwned.add(new ArrayList<Animal>());
		}
		itemsOwned.add(new TenEighty());
		itemsOwned.add(new Fertilizer());
		itemsOwned.add(new Irrigation());
		itemsOwned.add(new Fodder());
		itemsOwned.add(new FreshHay());
		itemsOwned.add(new NewPaddock());
		
		if (type == "Cow") {
			Cow myCow = new Cow();
			myCow.addAnimals(5);
			animalsOwned.get(0).add(myCow);
			amountOfAnimals += 5;
			
			moneyOwned += 5;
			
			this.getItemList().get(3).changeAmount(1);
			this.getItemList().get(4).changeAmount(2);
			
		} else if (type == "Wheat"){
			Wheat myWheat = new Wheat();
			myWheat.addCrops(6);
			cropsOwned.get(3).add(myWheat);
			amountOfCrops += 6;
			
			moneyOwned += 10;
			
			this.getItemList().get(1).changeAmount(2);
			
		} else if (type == "Vegetarian") {
			Corn myCorn = new Corn();
			myCorn.addCrops(1);
			Lettuce myLettuce = new Lettuce();
			myLettuce.addCrops(1);
			Potato myPotato = new Potato();
			myPotato.addCrops(1);
			Wheat myWheat = new Wheat();
			myWheat.addCrops(1);
			Tomato myTomato = new Tomato();
			myTomato.addCrops(1);
			Carrot myCarrot = new Carrot();
			myCarrot.addCrops(1);
			
			cropsOwned.get(0).add(myCorn);
			cropsOwned.get(1).add(myLettuce);
			cropsOwned.get(2).add(myPotato);
			cropsOwned.get(3).add(myWheat);
			cropsOwned.get(4).add(myTomato);
			cropsOwned.get(5).add(myCarrot);
			amountOfCrops += 6;
			
			moneyOwned += 5;
			
			this.getItemList().get(0).changeAmount(1);
			
		} else {
			Lettuce myLettuce = new Lettuce();
			myLettuce.addCrops(1);
			Potato myPotato = new Potato();
			myPotato.addCrops(1);
			Tomato myTomato = new Tomato();
			myTomato.addCrops(1);
			Carrot myCarrot = new Carrot();
			myCarrot.addCrops(1);
			
			cropsOwned.get(1).add(myLettuce);
			cropsOwned.get(2).add(myPotato);
			cropsOwned.get(4).add(myTomato);
			cropsOwned.get(5).add(myCarrot);
			amountOfCrops += 4;
			
			Sheep mySheep = new Sheep();
			mySheep.addAnimals(2);
			animalsOwned.get(1).add(mySheep);
			amountOfAnimals += 2;
			
			moneyOwned += 10;
			
			this.getItemList().get(0).changeAmount(1);
		}
	}
	
	/**
	 * Returns the nested list of animals
	 * 
	 * @return The nested list of animals
	 */
	public ArrayList<ArrayList<Animal>> getAnimalList() {
		return animalsOwned;
	}
	
	/**
	 * Returns the nested list of crops
	 * 
	 * @return The nested list of crops
	 */
	public ArrayList<ArrayList<Crop>> getCropList() {
		return cropsOwned;
	}
	
	/**
	 * Returns the nested list of items
	 * 
	 * @return The nested list of items
	 */
	public ArrayList<Item> getItemList() {
		return itemsOwned;
	}
	
	/**
	 * Returns the string representation of the farm object
	 * 
	 * @return The string representation of the farm object
	 */
	@Override
	public String toString() {
		return ("The farm has " + moneyOwned + " dollars.");
	}
	
	/**
	 * Sets the name of the farm
	 * 
	 * @param newName The name of the farm
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Sets the owner/farmer of the farm
	 * 
	 * @param newFarmer The owner of the farm
	 */
	public void setFarmer(Farmer newFarmer) {
		player = newFarmer;
	}
	
	/**
	 * Returns the name of the farm
	 * 
	 * @return The name of the farm
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the owner of the farm
	 * 
	 * @return The owner of the farm
	 */
	public Farmer getFarmer() {
		return player;
	}
	
	/**
	 * Returns the amount of money the farmer has
	 * 
	 * @return The amount of money the farmer has
	 */
	public int getMoneyOwned() {
		return moneyOwned;
	}
	
	/**
	 * Returns the maximum amount of crops that can be planted
	 * 
	 * @return The maximum amount of crops that can be planted
	 */
	public int getMaxCrops() {
		return maxCrops;
	}
	
	/**
	 * Returns the maximum amount of animals that can be raised
	 * 
	 * @return The maximum amount of animals that can be raised
	 */
	public int getMaxAnimals() {
		return maxAnimals;
	}
	
	/**
	 * Returns the current amount of crops in the field
	 * 
	 * @return The current amount of crops in the field
	 */
	public int getAmountOfCrops() {
		return amountOfCrops;
	}
	
	/**
	 * Returns the current amount of animals in the farm
	 * 
	 * @return The current amount of animals in the farm
	 */
	public int getAmountOfAnimals() {
		return amountOfAnimals;
	}
	
	/**
	 * Returns a string message of the status of the crop field, that tells the user how 
	 * many crops they own and how many more can be planted
	 * 
	 * @return A string message of the status of the crop field
	 */
	public String cropFieldStatus() {
		int available = maxCrops - amountOfCrops;
		return (amountOfCrops + " crops in the field, " + available + " more can be planted.");
	}
	
	/**
	 * Returns a string message of the status of the animal farm, that tells the user how 
	 * many animal they own and how many more can be raised
	 * 
	 * @return A string message of the status of the animal farm
	 */
	public String animalFarmStatus() {
		int available = maxAnimals - amountOfAnimals;
		return (amountOfAnimals + " animals in the farm, " + available + " more can be raised.");
	}
	
	/**
	 * Returns the index of the crop given its type
	 * 
	 * @param type The species of the crop
	 * @return The index of the crop's sublist in the nested list
	 */
	public int getCropIndex(String type) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (cropReference[i] == type) {
				result = i;
			}
		}
		return result;
	}
	
	/**
	 * Returns the index of the animal given its type
	 * 
	 * @param type The species of the animal
	 * @return The index of the animal's sublist in the nested list
	 */
	public int getAnimalIndex(String type) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			if (animalReference[i] == type) {
				result = i;
			}
		}
		return result;
	}
	
	/**
	 * Returns the index of the item given its type
	 * 
	 * @param type The name of the item
	 * @return The index of the item in the list
	 */
	public int getItemIndex(String type) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (itemReference[i] == type) {
				result = i;
			}
		}
		return result;
	}
	
	/**
	 * Returns the price of the crop given its type's index
	 * 
	 * @param type The index of the crop type
	 * @return The purchase price of the crop
	 */
	public int getCropPrice(int type) {
		ArrayList<Crop> cropTypeList = new ArrayList<Crop>();
		cropTypeList.add(new Corn());
		cropTypeList.add(new Lettuce());
		cropTypeList.add(new Potato());
		cropTypeList.add(new Wheat());
		cropTypeList.add(new Tomato());
		cropTypeList.add(new Carrot());
		return cropTypeList.get(type).getPurchasePrice();
	}
	
	/**
	 * Returns the price of the animal given its type's index
	 * 
	 * @param type The index of the animal type
	 * @return The purchase price of the animal
	 */
	public int getAnimalPrice(int type) {
		ArrayList<Animal> animalTypeList = new ArrayList<Animal>();
		animalTypeList.add(new Cow());
		animalTypeList.add(new Sheep());
		animalTypeList.add(new Deer());
		return animalTypeList.get(type).getPurchasePrice();
	}
	
	/**
	 * Returns the price of the item given its type's index
	 * 
	 * @param type The index of the item
	 * @return The purchase price of the item
	 */
	public int getItemPrice(int type) {
		return itemsOwned.get(type).getPrice();
	}
	
	/**
	 * Buy the specified amount of the specified crop
	 * 
	 * @param amount The amount of the crop to purchase
	 * @param index The index of crop
	 */
	public void buyCrops(int amount, int index) {
		Crop newCrop;
		if (index == 0) {
			newCrop = new Corn();
		} else if (index == 1) {
			newCrop = new Lettuce();
		} else if (index == 2) {
			newCrop = new Potato();
		} else if (index == 3) {
			newCrop = new Wheat();
		} else if (index == 4) {
			newCrop = new Tomato();
		} else {
			newCrop = new Carrot();
		}
		newCrop.addCrops(amount);
		cropsOwned.get(newCrop.getIndex()).add(newCrop);
		moneyOwned -= newCrop.getPurchasePrice() * amount;
		amountOfCrops += amount;
	}
	
	/**
	 * Returns a string message of what crops can be harvested
	 * 
	 * @return A message of what crop are allowed to be harvested
	 */
	public String harvestableCrops() {
		String returnString = "";
		for (int i = 0; i < 6; i++) {
			int amount = 0;
			for (Crop crop: cropsOwned.get(i)) {
				if (crop.getDaysUntilHarvest() == 0) {
					amount += crop.getAmount();
				}
			}
			if (amount > 0) {
				returnString += amount + " " +cropReference[i] + ", ";
			}
		}
		return returnString;
	}
	
	/**
	 * Harvest the matured crops in the farm and return the amount of money earned
	 * 
	 * @return The amount of money earned by harvesting
	 */
	public int harvestCrops() {
		int money = 0;
		for (ArrayList<Crop> list: cropsOwned) {
			
			for (Crop crop: new ArrayList<>(list)) {
				if (crop.getDaysUntilHarvest() == 0) {
					int price = crop.getSellPrice();
					int amount = crop.getAmount();
					int earning = price * amount;
					moneyOwned += earning;
					amountOfCrops -= amount;
					money += earning;
					list.remove(crop);
				}
			}
		}
		return money;
	}
	
	/**
	 * Water the crops of the given type in the farm, reduce the time until harvest
	 * 
	 * @param type The index of the crop type
	 */
	public void waterCrops(int type) {
		for (Crop crop: cropsOwned.get(type)) {
			crop.updateDays(1);
		}
	}
	
	/**
	 * Buy the specified amount of the specified animal
	 * 
	 * @param amount The amount to purchase
	 * @param index The index of the animal type
	 */
	public void buyAnimals(int amount, int index) {
		Animal newAnimal;
		if (index == 0) {
			newAnimal = new Cow();
		} else if (index == 1) {
			newAnimal = new Sheep();
		} else {
			newAnimal = new Deer();
		}
		newAnimal.addAnimals(amount);
		animalsOwned.get(newAnimal.getIndex()).add(newAnimal);
		moneyOwned -= newAnimal.getPurchasePrice() * amount;
		amountOfAnimals += amount;
	}
	
	/**
	 * Play with the animal of the given type
	 * 
	 * @param type The index of the animal type
	 */
	public void playWithAnimals(int type) {
		for (Animal animal: animalsOwned.get(type)) {
			animal.updateHappiness(5);
		}
	}
	
	/**
	 * Buy the specified amount of item
	 * 
	 * @param amount The amount to purchase
	 * @param index The index of the item
	 */
	public void buyItem(int amount, int index) {
		itemsOwned.get(index).changeAmount(amount);
		moneyOwned -= itemsOwned.get(index).getPrice() * amount;
	}
	
	/**
	 * Return all the crop objects in one array list
	 * 
	 * @return An array list of all the crop objects in the farm
	 */
	public ArrayList<Crop> getAllCrops(){
		ArrayList<Crop> allCrops = new ArrayList<Crop>();
		for (ArrayList<Crop> list: cropsOwned) {
			for (Crop crop: list) {
				allCrops.add(crop);
			}
		}
		return allCrops;
	}
	
	/**
	 * Return all the animal objects in one array list
	 * 
	 * @return An array list of all the animal objects in the farm
	 */
	public ArrayList<Animal> getAllAnimals(){
		ArrayList<Animal> allAnimals = new ArrayList<Animal>();
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				allAnimals.add(animal);
			}
		}
		return allAnimals;
	}
	
	/**
	 * Returns an array of all the crop objects in the nest listed
	 * 
	 * @return An array of all the crop objects in the nest listed
	 */
	public String[] getCropArray() {
		ArrayList<String> cropList = new ArrayList<String>();
		for (ArrayList<Crop> list: cropsOwned) {
			if (list.size() > 0) {
				cropList.add(list.get(0).getType());
			}
		}
		String[] cropArray = cropList.toArray(new String[0]);
		return cropArray;
	}
	
	/**
	 * Returns an array of all the animal objects in the nest listed
	 * 
	 * @return An array of all the animal objects in the nest listed
	 */
	public String[] getAnimalArray() {
		ArrayList<String> animalList = new ArrayList<String>();
		for (ArrayList<Animal> list: animalsOwned) {
			if (list.size() > 0) {
				animalList.add(list.get(0).getType());
			}
		}
		String[] animalArray = animalList.toArray(new String[0]);
		return animalArray;
	}
	
	/**
	 * Returns an array of all the item objects that are related to crops in the nest listed
	 * 
	 * @return An array of all the item objects that are related to crops in the nest listed
	 */
	public String[] getCropItemArray() {
		ArrayList<String> itemList = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			if (itemsOwned.get(i).getAmount() > 0) {
				itemList.add(itemsOwned.get(i).getName());
			}
		}
		String[] itemArray = itemList.toArray(new String[0]);
		return itemArray;
	}
	
	/**
	 * Returns an array of all the item objects that are related to animals in the nest listed
	 * 
	 * @return An array of all the item objects that are related to animals in the nest listed
	 */
	public String[] getFoodItemArray() {
		ArrayList<String> itemList = new ArrayList<String>();
		for (int i = 3; i < 6; i++) {
			if (itemsOwned.get(i).getAmount() > 0) {
				itemList.add(itemsOwned.get(i).getName());
			}
		}
		String[] itemArray = itemList.toArray(new String[0]);
		return itemArray;
	}
	
	/**
	 * Tending the farm, increase the capacities of maximum crops and animal that it can hold
	 * 
	 */
	public void tending() {
		maxCrops += 5;
		maxAnimals += 5;
		
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				animal.updateHappinessGrowth(1);
			}
		}
	}
	
	/**
	 * Move the the next day, reduce the days until harvest of the crops by 1, increment the happiness 
	 * of animal based on their happiness growth rate, return the daily bonus from animals
	 * 
	 * @return The daily bonus earned from all the animals in the farm
	 */
	public int moveToNextDay() {
		for (ArrayList<Crop> list: cropsOwned) {
			for (Crop crop: new ArrayList<>(list)) {
				crop.updateDays(1);
			}
		}
		
		int money = 0;
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				money += animal.getAmount() * animal.getTendingReward();
				animal.updateHappiness(animal.getHappinessGrowthRate());
			}
		}
		moneyOwned += money;
		return money;
	}
	
	/**
	 * Returns the value of all the crops in the field based on their selling price
	 * 
	 * @return The value of all the crops in the field based on their selling price
	 */
	public int getCropValue() {
		int worth = 0;
		for (ArrayList<Crop> list: cropsOwned) {
			for (Crop crop: new ArrayList<>(list)) {
				worth += crop.getAmount() * crop.getSellPrice();
			}
		}
		return worth;
	}
	
	/**
	 * Returns the value of all the animals in the farm based on their selling price
	 * 
	 * @return The value of all the animals in the farm based on their selling price
	 */
	public int getAnimalValue() {
		int worth = 0;
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				worth += (animal.getHappiness() + animal.getHealth()) / 2;
			}
		}
		return worth;
	}
	
	/**
	 * Returns the value of all the items unused
	 * 
	 * @return The value of all the items unused
	 */
	public int getItemValue() {
		int worth = 0;
		for (Item item: itemsOwned) {
			worth += item.getAmount() * item.getPrice();
		}
		return worth;
	}
}
