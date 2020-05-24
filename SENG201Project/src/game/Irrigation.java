package game;

public class Irrigation implements Item {
	private int amount;
	private String name = "Irrigation";
	private int price = 4;
	
	public Irrigation() {
		amount = 0;
	}
	
	public Irrigation(int initialAmount) {
		amount = initialAmount;
	}
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(4);
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
