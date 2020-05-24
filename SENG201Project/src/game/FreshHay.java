package game;

public class FreshHay implements Item {
	private int amount;
	private String name = "Fresh Hay";
	private int price = 2;
	
	public FreshHay() {
		amount = 0;
	}
	
	public FreshHay(int initialAmount) {
		amount = initialAmount;
	}
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Animal animal: inputFarm.getAnimalList().get(typeIndex)) {
			animal.updateHealth(2);
			animal.updateHealthGrowth(1);
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

