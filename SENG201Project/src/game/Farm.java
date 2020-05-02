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
	
	public Farm(int startingMoney, ArrayList<Animal> startingAnimals, ArrayList<Crop> startingCrops, ArrayList<Item> startingItems, 
			int newGrowingBonus, int newHappinessBonus) {
		moneyOwned = startingMoney;
		animalsOwned = startingAnimals;
		cropsOwned = startingCrops;
		itemsOwned = startingItems;
		growingBonus = newGrowingBonus;
		happinessBonus = newHappinessBonus;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setFarmer(Farmer newFarmer) {
		player = newFarmer;
	}
	
	public void updateCrops(int amount) {
		Crop newCorn = new Corn();
		newCorn.updateAmount(amount);
		cropsOwned.add(newCorn);
	}
	
	public void printCrops() {
		for (Crop i: cropsOwned) {
			System.out.println(i.getAmount());
		}
	}
}
