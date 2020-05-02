package game;
import java.util.ArrayList;

public class TestClass {
	public static void main(String[] args) {
		Crop Mycorn = new Corn();
		System.out.println(Mycorn);
		
		Animal myCow = new Cow();
		System.out.println(myCow);
		
		Farmer myFarmer = new Farmer("Chris", 21);
		System.out.println(myFarmer);
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		ArrayList<Crop> cropList = new ArrayList<Crop>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Farm Myfarm = new Farm(10, animalList, cropList, itemList, 1, 1);
		Myfarm.updateCrops(1);
		Myfarm.updateCrops(2);
		Myfarm.updateCrops(1);
		Myfarm.printCrops();
	}
}
