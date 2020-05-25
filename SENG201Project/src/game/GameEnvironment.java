package game;

import javax.swing.*;

import game.GUI.*;

/**
 * This class implements game environment that handles all the GUI windows
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class GameEnvironment {
	
	/**
	 * The farm that the game runs one
	 */
	private Farm theFarm;
	/**
	 * The main screen of the game
	 */
	private MainScreen theMainScreen;
	/**
	 * The duration of the game
	 */
	private int gameDuration;
	/**
	 * The current day
	 */
	private int currentDay = 1;
	/**
	 * The actions taken on the given day
	 */
	private int actionTaken = 0;
	
	/**
	 * Set the farm the game runs on
	 * 
	 * @param newFarm The new farm created for the game
	 */
	public void setFarm(Farm newFarm) {
		theFarm = newFarm;
	}
	
	/**
	 * Set the duration of the game
	 * 
	 * @param newGameDuration Set the duration of the game
	 */
	public void setDuration(int newGameDuration) {
		gameDuration = newGameDuration;
	}
	
	/**
	 * Returns the farm that the game runs on
	 * 
	 * @return The farm that the game runs on
	 */
	public Farm getFarm() {
		return theFarm;
	}
	
	/**
	 * Returns the game duration
	 * 
	 * @return The duration of the game
	 */
	public int getGameDuration() {
		return gameDuration;
	}
	
	/**
	 * Returns the current day
	 * 
	 * @return The current day of the game
	 */
	public int getCurrentDay(){
		return currentDay;
	}
	
	/**
	 * Returns the actions taken today
	 * 
	 * @return The actions that has been taken today
	 */
	public int getActionTaken() {
		return actionTaken;
	}
	
	/**
	 * Take an action, add 1 to the actionTaken
	 * 
	 */
	public void takeAction() {
		actionTaken += 1;
	}
	
	/**
	 * Move to the next day, return the amount of money earned from animals
	 * 
	 * @return The amount of money earned from animals
	 */
	public int moveToNextDay() {
		currentDay += 1;
		actionTaken = 0;
		int money = theFarm.moveToNextDay();
		return money;
	}
	
	/**
	 * Launch the main screen of the game
	 * 
	 */
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
		theMainScreen = mainWindow;
	}
	
	/**
	 * Close the main screen of the game
	 * 
	 * @param mainWindow The main screen of the game
	 */
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	/**
	 * Launch the setup screen of the game
	 * 
	 */
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	/**
	 * Close the setup screen of the game
	 * 
	 * @param setupWindow The setup screen of the game
	 */
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Launch the setup store screen of the game
	 * 
	 */
	public void launchStoreScreen() {
		StoreScreen storeWindow = new StoreScreen(this, theMainScreen);
	}
	
	/**
	 * close the setup store screen of the game
	 * 
	 * @param storeWindow The store screen of the game
	 */
	public void closeStoreScreen(StoreScreen storeWindow) {
		storeWindow.closeWindow();
	}
	
	/**
	 * The main that get called to start the game off
	 * 
	 * @param args The string array for the main
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
	}
}
