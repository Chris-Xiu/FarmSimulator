package game;

import game.GUI.*;

public class GameEnvironment {
	
	private Farm theFarm;
	private int gameDuration;
	private int currentDay = 1;
	private int actionTaken = 0;
	
	public void setFarm(Farm newFarm) {
		theFarm = newFarm;
	}
	
	public void setDuration(int newGameDuration) {
		gameDuration = newGameDuration;
	}
	
	public Farm getFarm() {
		return theFarm;
	}
	
	public int getGameDuration() {
		return gameDuration;
	}
	
	public int getCurrentDay(){
		return currentDay;
	}
	
	public int getActionTaken() {
		return actionTaken;
	}
	
	public void takeAction() {
		actionTaken += 1;
	}
	
	public int moveToNextDay() {
		currentDay += 1;
		actionTaken = 0;
		int money = theFarm.moveToNextDay();
		return money;
	}
	
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
	}
}
