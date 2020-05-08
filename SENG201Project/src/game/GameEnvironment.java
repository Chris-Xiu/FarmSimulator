package game;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEnvironment {
	
	private static int gameDuration;
	private static int currentDay = 1;
	private static int actionTaken = 0;
	private static boolean goingToNextDay = false;
	
	public static void OptionOne(Farm myFarm) {
		System.out.println("Crop Overview:");
		myFarm.displayCropOverview();
		System.out.println("Animal Overview:");
		myFarm.displayAnimalOverview();
	}
	
	public static void OptionTwo(Farm myFarm) {
		System.out.println(myFarm);
	}
	
	public static void OptionThree() {
		System.out.println("This one is not yet implemented!");
	}
	
	public static void OptionFour() {
		goingToNextDay = true;
	}
	
	public static void OptionActions() {
		if (actionTaken < 2) {
			System.out.println("This one is not yet implemented! But it shall still count as an action taken, bad luck!");
			actionTaken += 1;
		} else {
			System.out.println("You have already taken two actions! No more allowed, stop being greedy!");
		}
	}
	
	public static void main(String[] args) {
		// Setting the game duration
		Scanner input1 = new Scanner(System.in);
		System.out.println("How many days would you like the game to last? (Enter number of days between 5 to 10)");
		int days = input1.nextInt();
		gameDuration = days;
		
		// Setting up the farm and farmer
		// Testing code starts here
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
		// Ends here
		
		// Main while loop of the game
		while (currentDay <= gameDuration) {
			System.out.println("Good morning! This is day " + currentDay);
			while (!goingToNextDay) {
				int remainingActions = 2 - actionTaken;
				System.out.println("===================================================");
				System.out.println("You have " + remainingActions + " action left for today.");
				Scanner input2 = new Scanner(System.in);
				System.out.println("Which of the following things would you like to do:");
				System.out.println("===================================================");
				System.out.println("Option 1: View the status of your farm's crops and animals.");
				System.out.println("Option 2: Check your wallet.");
				System.out.println("Option 3: Visit the county's general store.");
				System.out.println("Option 4: Move on to the next day");
				System.out.println("Option 5: Water your crops. (Counts as one action of the day)");
				System.out.println("Option 6: Feed your animals. (Counts as one action of the day)");
				System.out.println("Option 7: Play with your animals. (Counts as one action of the day)");
				System.out.println("Option 8: Harvest your crops. (Counts as one action of the day)");
				System.out.println("Option 9: Tend to your farm land. (Counts as one action of the day)");
				System.out.println("===================================================");
				System.out.println("Which option would you like to select? (Enter one of the option number)");
				int option = input2.nextInt();
				if ((option > 9) || (option < 0)) {
					System.out.println("You entered an invalid option number, try again.");
					option = input2.nextInt();
				}
				
				if (option == 1) {
					GameEnvironment.OptionOne(myFarm);
				} else if (option == 2) {
					GameEnvironment.OptionTwo(myFarm);
				} else if (option == 3) {
					GameEnvironment.OptionThree();
				} else if (option == 4) {
					GameEnvironment.OptionFour();
				} else {
					GameEnvironment.OptionActions();
				}
			}
			System.out.println("Day " + currentDay + " has ended, have a good night");
			currentDay += 1;
			actionTaken = 0;
			goingToNextDay = false;
		}
	}
}
