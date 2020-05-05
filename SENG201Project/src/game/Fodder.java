package game;

import java.util.ArrayList;

public class Fodder implements Item {

	public void useItem(game.Farm currentFarm, String animalType) {
		ArrayList<Animal> animals = currentFarm.listAnimals();
		for (Animal animal: animals) {
			if (animal.getType() == animalType) {
				animal.updateHappiness(2);
			}
		}
	}
	
}
