package game;
import java.util.*;

public class Farm {
	
	private String name;
	private Farmer player;
	private int moneyOwned;
	
	private ArrayList<ArrayList<Crop>> cropsOwned;
	private ArrayList<ArrayList<Animal>> animalsOwned;
	private ArrayList<Item> itemsOwned;
	
	private int maxCrops = 10;
	private int maxAnimals = 10;
	private int amountOfCrops = 0;
	private int amountOfAnimals = 0;
	
	public static final String [] animalReference = {"Cow", "Sheep", "Deer"}; 
	public static final String [] cropReference = {"Corn", "Lettuce", "Potato", "Wheat", "Tomato", "Carrot"};
	public static final String [] itemReference = {"1080", "Fertilizer", "Irrigation", "Fodder", "Fresh Hay", "New Paddock"};
	
	
	
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
	
	public ArrayList<ArrayList<Animal>> getAnimalList() {
		return animalsOwned;
	}
	
	public ArrayList<ArrayList<Crop>> getCropList() {
		return cropsOwned;
	}
	
	public ArrayList<Item> getItemList() {
		return itemsOwned;
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
	
	public String getName() {
		return name;
	}
	
	public Farmer getFarmer() {
		return player;
	}
	
	public int getMoneyOwned() {
		return moneyOwned;
	}
	
	public int getMaxCrops() {
		return maxCrops;
	}
	
	public int getMaxAnimals() {
		return maxAnimals;
	}
	
	public int getAmountOfCrops() {
		return amountOfCrops;
	}
	
	public int getAmountOfAnimals() {
		return amountOfAnimals;
	}
	
	public String cropFieldStatus() {
		int available = maxCrops - amountOfCrops;
		return (amountOfCrops + " crops in the field, " + available + " more can be planted.");
	}
	
	public String animalFarmStatus() {
		int available = maxAnimals - amountOfAnimals;
		return (amountOfAnimals + " animals in the farm, " + available + " more can be raised.");
	}
	
	public int getCropIndex(String type) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (cropReference[i] == type) {
				result = i;
			}
		}
		return result;
	}
	
	public int getAnimalIndex(String type) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			if (animalReference[i] == type) {
				result = i;
			}
		}
		return result;
	}
	
	public int getItemIndex(String type) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (itemReference[i] == type) {
				result = i;
			}
		}
		return result;
	}
	
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
	
	public int getAnimalPrice(int type) {
		ArrayList<Animal> animalTypeList = new ArrayList<Animal>();
		animalTypeList.add(new Cow());
		animalTypeList.add(new Sheep());
		animalTypeList.add(new Deer());
		return animalTypeList.get(type).getPurchasePrice();
	}
	
	public int getItemPrice(int type) {
		return itemsOwned.get(type).getPrice();
	}
	
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
	
	public void waterCrops(int index) {
		for (Crop crop: cropsOwned.get(index)) {
			crop.updateDays(1);
		}
	}
	
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
	
	public void playWithAnimals(int type) {
		for (Animal animal: animalsOwned.get(type)) {
			animal.updateHappiness(5);
		}
	}
	
	public void buyItem(int amount, int index) {
		itemsOwned.get(index).changeAmount(amount);
		moneyOwned -= itemsOwned.get(index).getPrice() * amount;
	}
	
	public ArrayList<Crop> getAllCrops(){
		ArrayList<Crop> allCrops = new ArrayList<Crop>();
		for (ArrayList<Crop> list: cropsOwned) {
			for (Crop crop: list) {
				allCrops.add(crop);
			}
		}
		return allCrops;
	}
	
	public ArrayList<Animal> getAllAnimals(){
		ArrayList<Animal> allAnimals = new ArrayList<Animal>();
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				allAnimals.add(animal);
			}
		}
		return allAnimals;
	}
	
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
	
	public void tending() {
		maxCrops += 5;
		maxAnimals += 5;
	}
	
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
	
	public int getCropValue() {
		int worth = 0;
		for (ArrayList<Crop> list: cropsOwned) {
			for (Crop crop: new ArrayList<>(list)) {
				worth += crop.getAmount() * crop.getSellPrice();
			}
		}
		return worth;
	}
	
	public int getAnimalValue() {
		int worth = 0;
		for (ArrayList<Animal> list: animalsOwned) {
			for (Animal animal: list) {
				worth += (animal.getHappiness() + animal.getHealth()) / 2;
			}
		}
		return worth;
	}
	
	public int getItemValue() {
		int worth = 0;
		for (Item item: itemsOwned) {
			worth += item.getAmount() * item.getPrice();
		}
		return worth;
	}
	
	//Codes for command line program
	
	public void feedAnimals(int type) {
		for (Animal animal: animalsOwned.get(type)) {
			animal.updateHealth(1);
		}
		
	}
	
		public ArrayList<Integer> getCropTypeList() {
			ArrayList<Integer> queryList = new ArrayList<Integer>();
			for (int i = 0; i < cropsOwned.size(); i++) {
				if (!cropsOwned.get(i).isEmpty()) {
					queryList.add(i);
				}
			}
			return queryList;
		}
		
		public ArrayList<Integer> getAnimalTypeList() {
			ArrayList<Integer> queryList = new ArrayList<Integer>();
			for (int i = 0; i < animalsOwned.size(); i++) {
				if (!animalsOwned.get(i).isEmpty()) {
					queryList.add(i);
				}
			}
			return queryList;
		}
		
		public ArrayList<Integer> getItemAvailable(int start, int end) {
			ArrayList<Integer> queryList = new ArrayList<Integer>();
			for (int i = start; i < end; i++) {
				if (itemsOwned.get(i).getAmount() != 0) {
					queryList.add(i);
				}
			}
			return queryList;
		}
		
		public static int selectType(ArrayList<Integer> queryList, String[] queryReference) {
			int index = 1;
			Scanner selector = new Scanner(System.in);
			System.out.println("Please select a type: ");
			for (int target: queryList) {
				System.out.println("\n" + index + " " + queryReference[target]);
				index++;
			}
			int getIndex = selector.nextInt();
			int typeIndex = queryList.get(getIndex -1);
			return typeIndex;
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
}
