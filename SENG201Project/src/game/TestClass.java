package game;
import java.util.*;


public class TestClass {
	public static void main(String[] args) {
		
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		Cow myCow = new Cow();
		myCow.addAnimals(2000);
		animalList.add(myCow);
		
		ArrayList<Crop> cropList = new ArrayList<Crop>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		Farm myFarm = new Farm(10, cropList, animalList, itemList, 1, 1);

	}
}