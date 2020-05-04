package game;
import java.util.ArrayList;

public class TestClass {
	public static void main(String[] args) {
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		ArrayList<Crop> cropList = new ArrayList<Crop>(); 
		ArrayList<Item> itemList = new ArrayList<Item>();
		Farm Myfarm = new Farm(10, animalList, cropList, itemList, 1, 1);
	}
}