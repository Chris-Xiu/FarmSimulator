package game;

import java.util.ArrayList;

public class Fodder implements Item {

	public void useItem(Farm currentFarm, String animalType) {
		int index = Farm.getTypeIndex(animalType, Farm.animalReference);
		ArrayList<ArrayList<Animal>> listAnimals = currentFarm.listAnimals();
		
		for (Animal animal: listAnimals.get(index)) {
			animal.updateHappiness(2);
		}
	}	
}
