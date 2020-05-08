package game;
import java.util.*;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		Cow myCow = new Cow();
		myCow.addAnimals(2000);
		animalList.add(myCow);
		
		ArrayList<Crop> cropList = new ArrayList<Crop>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		Farm myFarm = new Farm(10, cropList, animalList, itemList, 1, 1);
		
		myFarm.buyCrops(3);
		Hoe myHoe = new Hoe();
		myHoe.useItem(myFarm, "Corn");
		myFarm.buyCrops(3);
		
		myFarm.displayAnimalOverview();
		myFarm.displayCropOverview();
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some string:");
		String someString = input.nextLine();
		System.out.println("The string is : " + someString);
	}
}