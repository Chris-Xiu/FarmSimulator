package game;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class NewPaddock implements Item {
	private int amount;
	private String name = "New Paddock";
	private int price = 4;
	
	public NewPaddock() {
		amount = 0;
	}
	
	public NewPaddock(int initialAmount) {
		amount = initialAmount;
	}
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHealth(2);
			animal.updateHappinessGrowth(1);
		}
		this.changeAmount(-1);
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void changeAmount(int change) {
		amount += change;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}

