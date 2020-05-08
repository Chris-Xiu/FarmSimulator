package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Hoe implements Item {
	
	public void useItem(Farm currentFarm, String cropType) {
		int index = Farm.getTypeIndex(cropType, Farm.cropReference);
		ArrayList<ArrayList<Crop>> listCrops = currentFarm.listCrops();
		
		for (Crop crop: listCrops.get(index)) {
			crop.updateDays(2);
		}
	}

	//Returns the index of a user selected type,
	public int selectType() {
		ArrayList<String> queryList = getTypeList(overviewList, reference);
		
		int index = 1;
		Scanner selectCrop = new Scanner(System.in);
		System.out.println("Please select a crop to use this item on: ");
		
		for (String target: queryList) {
			System.out.println("\n" + index + " " + target);
			index++;
		}
		
		//User input is taken, converted to an integer, and the correct index for the storage list is retrieved.
		String cropIndex = selectCrop.nextLine();
		int cropIndexInt = Integer.parseInt(cropIndex);
		int typeIndex = getIndex(queryList.get(cropIndexInt), reference);
		
		//Returns the index
		return typeIndex;
	}
	
	//Returns the index of a type's String.
	public int getIndex(String typeString, String[] reference) {
		for (int i = 0; i < 4; i++) {
			if (reference[i] == typeString) {
				return i;
			}
		}
		return -1;
	}
	
	//Creates a list of type's that an item can be applied to. Needs an error condition if none are owned.
	public ArrayList<String> getTypeList(ArrayList<ArrayList<Integer>> overviewList, String[] reference) {
		ArrayList<String> queryList = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			if (!overviewList.get(i).isEmpty()) {
				queryList.add(reference[i]);
			}
		}
		return queryList;
	}
	
}
