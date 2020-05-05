package game;

import java.util.ArrayList;

public class Hoe implements Item {
	
	public void useItem(game.Farm currentFarm, String cropType) {
		ArrayList<Crop> crops = currentFarm.listCrops();
		for (Crop crop: crops) {
			if (crop.getType() == cropType) {
				crop.updateDays(2);
			}

		}
		
	}

}
