package game;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineApplication {
	
	private static int gameDuration;
	private static int currentDay = 1;
	private static int actionTaken = 0;
	private static boolean goingToNextDay = false;
	
	public static void setDuration() {
		Scanner input = new Scanner(System.in);
		System.out.println("How many days would you like the game to last? (Enter number of days between 5 to 10)");
		int days = input.nextInt();
		while ((days > 10) || (days < 5)) {
			System.out.println("You entered an invalid duration, try again.");
			days = input.nextInt();
		}
		gameDuration = days;
	}
	
	private static Farm setUpFarm() {
		Scanner input1 = new Scanner(System.in);
		System.out.println("What is your name?");
		String farmerName = input1.nextLine();
		
		Scanner input2 = new Scanner(System.in);
		System.out.println("How old are you?");
		int farmerAge = input2.nextInt();
		
		Farmer myFarmer = new Farmer(farmerName, farmerAge);
		
		Scanner input3 = new Scanner(System.in);
		System.out.println("There are two types of farms to choose from:");
		System.out.println("===================================================");
		System.out.println("Option 1: Cow Farm (You start the game with 5 cows)");
		System.out.println("Option 2: Millionaire Farm (You start the game with an extra 10 bucks)");
		int option = input3.nextInt();
		while ((option > 2) || (option < 1)) {
			System.out.println("You entered an invalid option number, try again.");
			option = input3.nextInt();
		}
		
		Scanner input4 = new Scanner(System.in);
		System.out.println("How would you like to name your farm?");
		String farmName = input4.nextLine();
		
		if (option == 1) {
			Farm myFarm = new Farm("Cow");
			myFarm.setFarmer(myFarmer);
			myFarm.setName(farmName);
			return myFarm;
		} else {
			Farm myFarm = new Farm("Goldmine");
			myFarm.setFarmer(myFarmer);
			myFarm.setName(farmName);
			return myFarm;
		}
	}
	
	public static void OptionOne(Farm myFarm) {
		System.out.println("Crop Overview:");
		myFarm.displayCropOverview();
		System.out.println("Animal Overview:");
		myFarm.displayAnimalOverview();
	}
	
	public static void OptionTwo(Farm myFarm) {
		System.out.println(myFarm);
	}
	
	public static void OptionThree(Farm myFarm) {
		boolean isFinished = false;
		
		while (!isFinished) {
			System.out.println("Welcome to the store, here is an overview of what you have:");
			CommandLineApplication.OptionOne(myFarm);
			CommandLineApplication.OptionTwo(myFarm);
			
			Scanner input1 = new Scanner(System.in);
			System.out.println("You can do the following things in store.");
			System.out.println("===================================================");
			System.out.println("Option 1: Buy goods.");
			System.out.println("Option 2: Leave the store.");
			
			int option = input1.nextInt();
			while ((option > 2) || (option < 1)) {
				System.out.println("You entered an invalid option number, try again.");
				option = input1.nextInt();
			}
			
			
			
			if (option == 1) {
				Scanner input2 = new Scanner(System.in);
				System.out.println("What type of good would you like to buy?");
				System.out.println("===================================================");
				System.out.println("Type 1: Crops");
				System.out.println("Type 2: Animals");
				System.out.println("Type 3: Items");
				int type = input2.nextInt();
				while ((type > 3) || (type < 1)) {
					System.out.println("You entered an invalid type number, try again.");
					type = input2.nextInt();
				}
				
				if (type == 1) {
					System.out.println("You can purchase the following crops:");
					for (int i = 0; i <6; i++) {
						System.out.println("Crop " + (i+1) + " : " + Farm.cropReference[i] + ". Each one cost 1 dollar");
					}
					Scanner input3 = new Scanner(System.in);
					System.out.println("Which crop would you like to buy");
					int typeCrop = input3.nextInt();
					while ((typeCrop > 6) || (typeCrop < 1)) {
						System.out.println("You entered an invalid crop type number, try again.");
						typeCrop = input3.nextInt();
						}
					
					Scanner input4 = new Scanner(System.in);
					System.out.println("How many would you like to buy?");
					int cropAmount = input4.nextInt();
					myFarm.buyCrops(cropAmount, typeCrop);
					
					
					
				} else if (type == 2){
					System.out.println("You can purchase the following animals:");
					for (int i = 0; i <3; i++) {
						System.out.println("Animal " + i + " : " + Farm.animalReference[i] + ". Each one cost 3 dollar");
					}
					Scanner input5 = new Scanner(System.in);
					System.out.println("Which animal would you like to buy");
					int typeAnimal = input5.nextInt();
					while ((typeAnimal > 3) || (typeAnimal < 1)) {
						System.out.println("You entered an invalid animal number, try again.");
						typeAnimal = input5.nextInt();
						}
					
					Scanner input6 = new Scanner(System.in);
					System.out.println("How many would you like to buy?");
					int animalAmount = input6.nextInt();
					myFarm.buyCrops(animalAmount, typeAnimal);
					
					
					
				} else {
					// Not yet implemented
					System.out.println("Not yet implemented");
				}
			
			
			
			} else {
				isFinished = true;
			}
		}
		System.out.println("Thank you for visiting the store!");
	}
	
	public static void OptionFour() {
		goingToNextDay = true;
	}
	
	public static void OptionFive(Farm myFarm) {
		Scanner input3 = new Scanner(System.in);
		System.out.println("Which of your crops would you like to tend:");
		System.out.println("===================================================");
		ArrayList<Integer> overviewList = myFarm.getCropTypeList();
		int typeIndex = Farm.selectType(overviewList, Farm.cropReference);
		
		System.out.println("Which action would you like to take:");
		System.out.println("===================================================");
		System.out.println("1. Water crop");
		System.out.println("2. Use an item");
		
		int option5 = input3.nextInt();
		while ((option5 > 2) || (option5 < 1)) {
			System.out.println("You entered an invalid option number, try again.");
			option5 = input3.nextInt();
		}
		
		if (option5 == 1) {
			//Modify that crops time to harvest
			myFarm.waterCrops(typeIndex);
		} else {
			//Show list of items
			ArrayList<Integer> itemList = myFarm.getItemAvailable(0, 3);
			int itemIndex = Farm.selectType(itemList, Farm.itemReference);
			//Use one item
			myFarm.getItemList().get(itemIndex).useItem(myFarm, typeIndex);
			System.out.println("You used " + Farm.itemReference[itemIndex] + " on your " + Farm.cropReference[typeIndex]);
		}
		
	}
	
	public static void OptionSix(Farm myFarm) {
		Scanner input3 = new Scanner(System.in);
		System.out.println("Which of your animals would you like to feed:");
		System.out.println("===================================================");
		ArrayList<Integer> overviewList = myFarm.getAnimalTypeList();
		int typeIndex = Farm.selectType(overviewList, Farm.animalReference);
		
		System.out.println("Which action would you like to take:");
		System.out.println("===================================================");
		System.out.println("1. Feed animal");
		System.out.println("2. Use an item");
		
		int option6 = input3.nextInt();
		while ((option6 > 2) || (option6 < 1)) {
			System.out.println("You entered an invalid option number, try again.");
			option6 = input3.nextInt();
		}
		
		if (option6 == 1) {
			//Modify that crops time to harvest
			myFarm.feedAnimals(typeIndex);
		} else {
			//Show list of items
			ArrayList<Integer> itemList = myFarm.getItemAvailable(3, 6);
			int itemIndex = Farm.selectType(itemList, Farm.itemReference);
			//Use one item
			myFarm.getItemList().get(itemIndex).useItem(myFarm, typeIndex);
			System.out.println("You used " + Farm.itemReference[itemIndex] + " on your " + Farm.animalReference[typeIndex]);
		}
	}
	
	public static void OptionSeven(Farm myFarm) {
		System.out.println("Which of your animals would you like to play with:");
		System.out.println("===================================================");
		ArrayList<Integer> overviewList = myFarm.getAnimalTypeList();
		int typeIndex = Farm.selectType(overviewList, Farm.animalReference);
		myFarm.playWithAnimals(typeIndex);
		System.out.println("You played with your " + Farm.animalReference[typeIndex]);
	}
	
	public static void OptionActions() {
		if (actionTaken < 2) {
			System.out.println("This one is not yet implemented! But it shall still count as an action taken, bad luck!");
			actionTaken += 1;
		} else {
			System.out.println("You have already taken two actions! No more allowed, stop being greedy!");
		}
	}
	
	public static void OptionEight(Farm myFarm) {
		int money = myFarm.harvestCrops();
	}
	
	public static void OptionNine(Farm myFarm) {
		myFarm.tending();
	}
	
	public static void main(String[] args) {
		setDuration();
		
		Farm myFarm = setUpFarm();
		
		// Main while loop of the game
		while (currentDay <= gameDuration) {
			System.out.println("Good morning! This is day " + currentDay);
			while (!goingToNextDay) {
				int remainingActions = 2 - actionTaken;
				System.out.println("===================================================");
				System.out.println("You have " + remainingActions + " action left for today.");
				Scanner choice = new Scanner(System.in);
				System.out.println("Which of the following things would you like to do:");
				System.out.println("===================================================");
				System.out.println("Option 1: View the status of your farm's crops and animals.");
				System.out.println("Option 2: Check your wallet.");
				System.out.println("Option 3: Visit the county's general store.");
				System.out.println("Option 4: Move on to the next day");
				System.out.println("Option 5: Tend to your crops. (Counts as one action of the day)");
				System.out.println("Option 6: Feed your animals. (Counts as one action of the day)");
				System.out.println("Option 7: Play with your animals. (Counts as one action of the day)");
				System.out.println("Option 8: Harvest your crops. (Counts as one action of the day)");
				System.out.println("Option 9: Tend to your farm land. (Counts as one action of the day)");
				System.out.println("===================================================");
				System.out.println("Which option would you like to select? (Enter one of the option number)");
				int option = choice.nextInt();
				while ((option > 9) || (option < 1)) {
					System.out.println("You entered an invalid option number, try again.");
					option = choice.nextInt();
				}
				
				if (option == 1) {
					CommandLineApplication.OptionOne(myFarm);
				} else if (option == 2) {
					CommandLineApplication.OptionTwo(myFarm);
				} else if (option == 3) {
					CommandLineApplication.OptionThree(myFarm);
				} else if (option == 4) {
					CommandLineApplication.OptionFour();
				} else if (option == 5) {
					CommandLineApplication.OptionFive(myFarm);
				} else if (option == 6) {
					CommandLineApplication.OptionSix(myFarm);
				} else if (option == 7) {
					CommandLineApplication.OptionSeven(myFarm);
				} else if (option == 8) {
					CommandLineApplication.OptionEight(myFarm);
				} else if (option == 9) {
					CommandLineApplication.OptionNine(myFarm);
				} else {
					CommandLineApplication.OptionActions();
				}
			}
			System.out.println("Day " + currentDay + " has ended, have a good night");
			currentDay += 1;
			actionTaken = 0;
			goingToNextDay = false;
		}
	}
}
