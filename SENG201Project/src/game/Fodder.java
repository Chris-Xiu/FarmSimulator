package game;

public class Fodder implements Item {
	private int amount;
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHappiness(1);
			animal.updateHappinessGrowth(1);
		}
		this.changeAmount(-1);
	}
	
	public void setAmount(int initialAmount) {
		amount = initialAmount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void changeAmount(int change) {
		amount += change;
	}
	
}

