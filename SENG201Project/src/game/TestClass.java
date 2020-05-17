package game;
import java.util.*;


public class TestClass {	
	public static void main(String[] args) {
		Scanner stringInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		
		System.out.println("Enter a string:");
		String string1 = stringInput.nextLine();
		
		System.out.println("Enter a number:");
		int numebr1 = intInput.nextInt();
		
		ArrayList<Crop> cropList = new ArrayList<Crop>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		Farm myFarm = new Farm(10, cropList, animalList, itemList, 1, 1);
	}
}