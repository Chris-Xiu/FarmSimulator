package game;

public class TenEighty implements Item {
	private int amount;
	
	public TenEighty(int initialAmount) {
		amount = initialAmount;
	}

	public void useItem(Farm inputFarm, int typeIndex) {
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(2);
		}
		this.changeAmount(-1);
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void changeAmount(int change) {
		amount += change;
	}
}
