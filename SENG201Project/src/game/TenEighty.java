package game;

import java.util.ArrayList;

public class TenEighty implements Item {
	private int amount;

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
