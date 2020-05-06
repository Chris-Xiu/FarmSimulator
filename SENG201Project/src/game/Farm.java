package game;
import java.util.ArrayList;
import java.util.List;

public class Farm {
	
	private String name;
	private Farmer player;
	private int moneyOwned;
	private ArrayList<Animal> animalsOwned;
	private ArrayList<Crop> cropsOwned;

	//The new Overview Lists
	private ArrayList<ArrayList<ArrayList<Integer>>> cropsOverview;
	private ArrayList<ArrayList<ArrayList<Integer>>> animalsOverview;
	private String [] animalReference = {"Cow", "Sheep", "Deer", "Pig"}; 
	private String [] cropReference = {"Corn", "Lettuce", "Potato", "Wheat"}; 
	
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
		
		//Creates empty overview lists
		createOverviewList();

		//Add starting Animals and Crops to the lists
		for (Animal newAnimal: animalsOwned) {
			addAnimalToOverview(newAnimal);
		}
		for (Crop newCrop: cropsOwned) {
			addCropToOverview(newCrop);
		}

	}
	
	public void createOverviewList() {
		//Create empty lists
		ArrayList<ArrayList<ArrayList<Integer>>> listStructureAnimals = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<ArrayList<Integer>>> listStructureCrops = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i < 4; i++) {
			listStructureCrops.add(new ArrayList<ArrayList<Integer>>());
			listStructureAnimals.add(new ArrayList<ArrayList<Integer>>());
			listStructureCrops.get(i).add(new ArrayList<Integer>());
			listStructureAnimals.get(i).add(new ArrayList<Integer>());
		}
		//Define crop and animal lists
		cropsOverview = listStructureCrops;
		animalsOverview = listStructureAnimals;
		
	}
	
	//Not generalized because they have different variables
	public void addAnimalToOverview(Animal newAnimal) {
		ArrayList<Integer> newAnimalList = new ArrayList<Integer>();
		newAnimalList.add(newAnimal.getAmount());
		newAnimalList.add(newAnimal.getHappiness());
		newAnimalList.add(newAnimal.getHealth());
		
		int index = getTypeIndex(newAnimal.getType(), animalReference);
		if (animalsOverview.get(index).get(0).isEmpty()) {
			animalsOverview.get(index).remove(0);
		}
		animalsOverview.get(index).add(newAnimalList);
	}
	
	public void addCropToOverview(Crop newCrop) {
		ArrayList<Integer> newCropList = new ArrayList<Integer>();
		newCropList.add(newCrop.getAmount());
		newCropList.add(newCrop.getDaysUntilHarvest());
		
		int index = getTypeIndex(newCrop.getType(), cropReference);
		
		//Remove the empty list when adding a list
		if (cropsOverview.get(index).get(0).isEmpty()) {
			cropsOverview.get(index).remove(0);
		}
		cropsOverview.get(index).add(newCropList);
	}
	
	public int getTypeIndex(String typeString, String[] reference) {
		for (int i = 0; i < reference.length; i++) {
			if (reference[i] == typeString) {
				return i;
			}
			
		}
		//It doesn't work if I return nothing outside of the if condition. Alter this to an error message
		return -1;
	}
	
	// Just an output test
	public void displayAnimalOverview() {
		for (int i = 0; i < animalsOverview.size(); i++) {
			if (!animalsOverview.get(i).get(0).isEmpty()) {
				for (ArrayList<Integer> j: animalsOverview.get(i)) {
					System.out.println("You own " + j.get(0) + " " + animalReference[i] + " which have a happiness of " + j.get(1) + " and a health of " + j.get(2) + ".");
				}
			}
		}
	}
	
	public void displayCropOverview() {
		for (int i = 0; i < cropsOverview.size(); i++) {
			if (!cropsOverview.get(i).get(0).isEmpty()) {
				for (ArrayList<Integer> j: cropsOverview.get(i)) {
					System.out.println("You own " + j.get(0) + " " + cropReference[i] + " which have " + j.get(1) + " days to harvest.");
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
	
	public void buyCrops(int amount) {
		Crop newCrop = new Corn();
		
		if (amount + amountOfCrops > maxCrops) {
			System.out.println("Not enough space to plant!");
		} else if (newCrop.getPurchasePrice() * amount > moneyOwned) {
			System.out.println("Not enough money to buy!");
		} else {
			newCrop.addCrops(amount);
			//New line
			addCropToOverview(newCrop);
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
		
		//New Line
		newCoW.addAnimals(amount);
		addAnimalToOverview(newCoW);
		animalsOwned.add(newCoW);
	}
	
	public void playWithAnimals() {
		for (Animal animal: animalsOwned) {
			animal.updateHappiness(1);
		}
	}
	
	public ArrayList<Crop> listCrops() {
		return cropsOwned;
	}
	
	public ArrayList<Animal> listAnimals() {
		return animalsOwned;
	}

}
