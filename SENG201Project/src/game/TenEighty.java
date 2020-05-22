package game;

public class TenEighty implements Item {
	private int amount;
	private String name = "1080";
	
	public TenEighty() {
		amount = 0;
	}
	
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
	
	public String getName() {
		return name;
	}
}
