package game;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

import java.util.ArrayList;

public class TenEighty implements Item {
	private int amount;
	private String name = "1080";
	private int price = 1;
	
	public TenEighty() {
		amount = 0;
	}
	
	public TenEighty(int initialAmount) {
		amount = initialAmount;
	}


	public void useItem(Farm inputFarm, int typeIndex) {
		//Reduce time to harvest by 2
		for (Crop crop: inputFarm.getCropList().get(typeIndex)) {
			crop.updateDays(2);
		}
		//Reduce all animals health by 1 but only if it is larger than 0.
		for (ArrayList<Animal> list: inputFarm.getAnimalList()) {
			for (Animal animal: list) {
				if (animal.getHealth() > 0) {
					animal.updateHealth(-1);
				}
							}
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
