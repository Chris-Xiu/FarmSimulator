package game;

public class Irrigation implements Item {
	private int amount;
	
	public void useItem(Farm inputFarm, int typeIndex) {
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(4);
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
