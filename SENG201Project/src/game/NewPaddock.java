package game;

public class NewPaddock implements Item {
	private int amount;
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHappinessGrowth(2);
			animal.updateHealthGrowth(1);
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

