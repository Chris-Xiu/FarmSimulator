package game;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class Fertilizer implements Item {
	private int amount;
	private String name = "Fertilizer";
	private int price = 2;
	
	public Fertilizer() {
		amount = 0;
	}
	
	public Fertilizer(int initialAmount) {
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
	
	public int getPrice() {
		return price;
	}
}
