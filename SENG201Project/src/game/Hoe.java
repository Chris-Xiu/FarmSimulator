package game;

import java.util.ArrayList;

public class Hoe implements Item {
	
	public void useItem(Farm currentFarm, String cropType) {
		int index = Farm.getTypeIndex(cropType, Farm.cropReference);
		ArrayList<ArrayList<Crop>> listCrops = currentFarm.listCrops();
		
		for (Crop crop: listCrops.get(index)) {
			crop.updateDays(2);
		}
	}
}
