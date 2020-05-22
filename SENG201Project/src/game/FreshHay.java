package game;

public class FreshHay implements Item {
	private int amount;
	private String name = "Fresh Hay";
	
	public FreshHay() {
		amount = 0;
	}
	
	public FreshHay(int initialAmount) {
		amount = initialAmount;
	}
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHealth(2);
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
}

