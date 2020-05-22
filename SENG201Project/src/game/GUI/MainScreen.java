package game.GUI;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import game.*;
import java.util.*;



public class MainScreen {
	
	private JFrame MainGameWindow;
	private GameEnvironment game;
	
	
	
	public MainScreen(GameEnvironment newGameEnvironment) {
		game = newGameEnvironment;
		initialize();
		MainGameWindow.setVisible(true);
	}
	
	public void closeWindow() {
		MainGameWindow.dispose();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.MainGameWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainGameWindow = new JFrame();
		MainGameWindow.setTitle("Farm Simulator");
		MainGameWindow.setBounds(100, 100, 990, 540);
		MainGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainGameWindow.getContentPane().setLayout(null);
		
		JLabel farmName = new JLabel("");
		farmName.setHorizontalAlignment(SwingConstants.CENTER);
		farmName.setFont(new Font("Arial", Font.BOLD, 20));
		farmName.setBounds(400, 10, 200, 50);
		MainGameWindow.getContentPane().add(farmName);
		farmName.setText(game.getFarm().getName());
		
		JLabel farmStatus = new JLabel("Farm Status:");
		farmStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		farmStatus.setBounds(10, 70, 100, 30);
		MainGameWindow.getContentPane().add(farmStatus);
		
		JLabel cropField = new JLabel("");
		cropField.setFont(new Font("Arial", Font.BOLD, 15));
		cropField.setBounds(10, 110, 450, 30);
		MainGameWindow.getContentPane().add(cropField);
		cropField.setText(game.getFarm().cropFieldStatus());
		
		DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
		cropListModel.addAll(game.getFarm().getAllCrops());
		JList<Crop> cropList = new JList<>(cropListModel);
		cropList.setBounds(10, 140, 300, 150);
		MainGameWindow.getContentPane().add(cropList);
		
		JLabel animalFarm = new JLabel("");
		animalFarm.setFont(new Font("Arial", Font.BOLD, 15));
		animalFarm.setBounds(10, 300, 450, 30);
		MainGameWindow.getContentPane().add(animalFarm);
		animalFarm.setText(game.getFarm().animalFarmStatus());
		
		DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
		animalListModel.addAll(game.getFarm().getAllAnimals());
		JList<Animal> animalList = new JList<>(animalListModel);
		animalList.setBounds(10, 330, 300, 150);
		MainGameWindow.getContentPane().add(animalList);
		
		JLabel moneyOwned = new JLabel("");
		moneyOwned.setHorizontalAlignment(SwingConstants.RIGHT);
		moneyOwned.setFont(new Font("Arial", Font.PLAIN, 20));
		moneyOwned.setBounds(320, 430, 50, 50);
		MainGameWindow.getContentPane().add(moneyOwned);
		moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
		
		JLabel moneySign = new JLabel("");
		moneySign.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/Goldcoin.jpg")));
		moneySign.setBounds(380, 430, 50, 50);
		MainGameWindow.getContentPane().add(moneySign);
		
		JLabel dayInfo = new JLabel("");
		dayInfo.setFont(new Font("Arial", Font.PLAIN, 20));
		dayInfo.setBounds(10, 10, 200, 50);
		MainGameWindow.getContentPane().add(dayInfo);
		dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
		
		JLabel actionInfo = new JLabel("");
		actionInfo.setFont(new Font("Arial", Font.PLAIN, 20));
		actionInfo.setBounds(500, 430, 150, 50);
		MainGameWindow.getContentPane().add(actionInfo);
		actionInfo.setText(game.getActionTaken() + "/2 action taken");
		
		JButton nextDayButton = new JButton("Go to next day");
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money = game.moveToNextDay();
				JOptionPane.showMessageDialog(MainGameWindow, "Earned " + money + " dollar from your animals", "Result", JOptionPane.PLAIN_MESSAGE);
				
				//Updates
				cropField.setText(game.getFarm().cropFieldStatus());
				
				DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
				cropListModel.addAll(game.getFarm().getAllCrops());
				cropList.setModel(cropListModel);
				
				animalFarm.setText(game.getFarm().animalFarmStatus());
				
				DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
				animalListModel.addAll(game.getFarm().getAllAnimals());
				animalList.setModel(animalListModel);
				
				moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
				
				dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
				
				actionInfo.setText(game.getActionTaken() + "/2 action taken");
				//Updates end
			}
		});
		nextDayButton.setFont(new Font("Arial", Font.BOLD, 20));
		nextDayButton.setBounds(750, 420, 200, 60);
		MainGameWindow.getContentPane().add(nextDayButton);
		
		JButton vistStoreButton = new JButton("Visit store");
		vistStoreButton.setFont(new Font("Arial", Font.BOLD, 18));
		vistStoreButton.setBounds(500, 140, 200, 60);
		MainGameWindow.getContentPane().add(vistStoreButton);
		
		JButton tendFarmlandButton = new JButton("Tend farmland");
		tendFarmlandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					game.getFarm().tending();
					JOptionPane.showMessageDialog(MainGameWindow, "Farmland tended, max crop, animal, happiness incrased", "Result", JOptionPane.PLAIN_MESSAGE);
					game.takeAction();
					
					//Updates
					cropField.setText(game.getFarm().cropFieldStatus());
					
					DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
					cropListModel.addAll(game.getFarm().getAllCrops());
					cropList.setModel(cropListModel);
					
					animalFarm.setText(game.getFarm().animalFarmStatus());
					
					DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
					animalListModel.addAll(game.getFarm().getAllAnimals());
					animalList.setModel(animalListModel);
					
					moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
					
					dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
					
					actionInfo.setText(game.getActionTaken() + "/2 action taken");
					//Updates end
				} else {
					JOptionPane.showMessageDialog(MainGameWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tendFarmlandButton.setFont(new Font("Arial", Font.BOLD, 18));
		tendFarmlandButton.setBounds(750, 140, 200, 60);
		MainGameWindow.getContentPane().add(tendFarmlandButton);
		
		JButton tendCropButton = new JButton("Tend crops");
		tendCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String[] ownedCropList = game.getFarm().getCropArray();
					if (ownedCropList.length > 0) {
						String[] options = {"Watering", "Using an item", "Cancel"};
						int choice = JOptionPane.showOptionDialog(MainGameWindow, "How would you like to tend your crops?","Choose a method", 
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if (choice == 0) {
							String cropChoice = (String) JOptionPane.showInputDialog(MainGameWindow, "What type of crop do you want to water?", 
									"Choose type of crop", JOptionPane.QUESTION_MESSAGE, null, ownedCropList, null);
							if (cropChoice != null) {
								game.getFarm().waterCrops(game.getFarm().getCropIndex(cropChoice));
								JOptionPane.showMessageDialog(MainGameWindow, cropChoice + " in your farm have been watered, 1 day closer to be harvested", "Result", JOptionPane.PLAIN_MESSAGE);
								game.takeAction();
							} else {
								;
							}
						} else if (choice == 1) {
							String cropChoice = (String) JOptionPane.showInputDialog(MainGameWindow, "What type of crop do you want to water?", 
									"Choose type of crop", JOptionPane.QUESTION_MESSAGE, null, ownedCropList, null);
							if (cropChoice != null) {
								int cropIndex = game.getFarm().getCropIndex(cropChoice);
								String[] ownedItemList = game.getFarm().getCropItemArray();
								if (ownedItemList.length > 0) {
									String itemChoice = (String) JOptionPane.showInputDialog(MainGameWindow, "Which crop item do you want to use?", 
											"Choose item", JOptionPane.QUESTION_MESSAGE, null, ownedItemList, null);
									if (itemChoice != null) {
										int beforeTime = game.getFarm().getCropList().get(cropIndex).get(0).getDaysUntilHarvest();
										game.getFarm().getItemList().get(game.getFarm().getItemIndex(itemChoice)).useItem(game.getFarm(), cropIndex);
										int afterTime = game.getFarm().getCropList().get(cropIndex).get(0).getDaysUntilHarvest();
										int difference = beforeTime - afterTime;
										JOptionPane.showMessageDialog(MainGameWindow, itemChoice + " used on " + cropChoice + ", " + difference + " day closer to be harvested", "Result", JOptionPane.PLAIN_MESSAGE);
										game.takeAction();
									} else {
										;
									}
								} else {
									JOptionPane.showMessageDialog(MainGameWindow, "No crop item to use", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								;
							}
						} else {
							;
						}
					} else {
						JOptionPane.showMessageDialog(MainGameWindow, "No crop to tend to", "Error", JOptionPane.ERROR_MESSAGE);
					}
					//Updates
					cropField.setText(game.getFarm().cropFieldStatus());
					
					DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
					cropListModel.addAll(game.getFarm().getAllCrops());
					cropList.setModel(cropListModel);
					
					animalFarm.setText(game.getFarm().animalFarmStatus());
					
					DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
					animalListModel.addAll(game.getFarm().getAllAnimals());
					animalList.setModel(animalListModel);
					
					moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
					
					dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
					
					actionInfo.setText(game.getActionTaken() + "/2 action taken");
					//Updates end
				} else {
					JOptionPane.showMessageDialog(MainGameWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tendCropButton.setFont(new Font("Arial", Font.BOLD, 18));
		tendCropButton.setBounds(500, 230, 200, 60);
		MainGameWindow.getContentPane().add(tendCropButton);
		
		JButton feedAnimalButton = new JButton("Feed animals");
		feedAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String[] ownedAnimalList = game.getFarm().getAnimalArray();
					String[] ownedItemList = game.getFarm().getFoodItemArray();
					if (ownedAnimalList.length == 0) {
						JOptionPane.showMessageDialog(MainGameWindow, "No animal to be fed", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (ownedItemList.length == 0) {
						JOptionPane.showMessageDialog(MainGameWindow, "No food item to feed", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String animalChoice = (String) JOptionPane.showInputDialog(MainGameWindow, "What type of animal do you want to feed?", 
								"Choose type of animal", JOptionPane.QUESTION_MESSAGE, null, ownedAnimalList, null);
						if (animalChoice != null) {
							String itemChoice = (String) JOptionPane.showInputDialog(MainGameWindow, "Which food item do you want to use?", 
									"Choose item", JOptionPane.QUESTION_MESSAGE, null, ownedItemList, null);
							if (itemChoice != null) {
								int animalIndex = game.getFarm().getAnimalIndex(animalChoice);
								int itemIndex = game.getFarm().getItemIndex(itemChoice);
								game.getFarm().getItemList().get(itemIndex).useItem(game.getFarm(), animalIndex);
								JOptionPane.showMessageDialog(MainGameWindow, "Your " + Farm.animalReference[animalIndex] + "s' healthiness increased", "Result", JOptionPane.PLAIN_MESSAGE);
								game.takeAction();
								
								//Updates
								cropField.setText(game.getFarm().cropFieldStatus());
								
								DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
								cropListModel.addAll(game.getFarm().getAllCrops());
								cropList.setModel(cropListModel);
								
								animalFarm.setText(game.getFarm().animalFarmStatus());
								
								DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
								animalListModel.addAll(game.getFarm().getAllAnimals());
								animalList.setModel(animalListModel);
								
								moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
								
								dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
								
								actionInfo.setText(game.getActionTaken() + "/2 action taken");
								//Updates end
							} else {
								;
							}
						} else {
							;
						}
					}
				} else {
					JOptionPane.showMessageDialog(MainGameWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		feedAnimalButton.setFont(new Font("Arial", Font.BOLD, 18));
		feedAnimalButton.setBounds(500, 320, 200, 60);
		MainGameWindow.getContentPane().add(feedAnimalButton);
		
		JButton harvestCropButton = new JButton("Harvest crops");
		harvestCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String harvestMessage = game.getFarm().harvestableCrops();
					if (harvestMessage.length() == 0) {
						JOptionPane.showMessageDialog(MainGameWindow, "No crop to be harvested", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						int choice = JOptionPane.showConfirmDialog(MainGameWindow, "Are you sure you want to harvest the following crops:\n" + harvestMessage,  "Confirmation", JOptionPane.YES_NO_OPTION);
						if (choice == JOptionPane.YES_OPTION) {
							int money = game.getFarm().harvestCrops();
							JOptionPane.showMessageDialog(MainGameWindow, "Crops harvested, " + money + " dollars earned", "Result", JOptionPane.PLAIN_MESSAGE);
							game.takeAction();
							
							//Updates
							cropField.setText(game.getFarm().cropFieldStatus());
							
							DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
							cropListModel.addAll(game.getFarm().getAllCrops());
							cropList.setModel(cropListModel);
							
							animalFarm.setText(game.getFarm().animalFarmStatus());
							
							DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
							animalListModel.addAll(game.getFarm().getAllAnimals());
							animalList.setModel(animalListModel);
							
							moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
							
							dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
							
							actionInfo.setText(game.getActionTaken() + "/2 action taken");
							//Updates end
						} else {
							;
						}
					}
				} else {
					JOptionPane.showMessageDialog(MainGameWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		harvestCropButton.setFont(new Font("Arial", Font.BOLD, 18));
		harvestCropButton.setBounds(750, 230, 200, 60);
		MainGameWindow.getContentPane().add(harvestCropButton);
		
		JButton playWithAnimalButton = new JButton("Play with animals");
		playWithAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String[] ownedAnimalList = game.getFarm().getAnimalArray();
					if (ownedAnimalList.length > 0) {
						String choice = (String) JOptionPane.showInputDialog(MainGameWindow, "What type of animal do you want to play with?", 
								"Choose type of animal", JOptionPane.QUESTION_MESSAGE, null, ownedAnimalList, null);
						if (choice != null) {
							int animalIndex = game.getFarm().getAnimalIndex(choice);
							game.getFarm().playWithAnimals(animalIndex);
							JOptionPane.showMessageDialog(MainGameWindow, "Your " + Farm.animalReference[animalIndex] + "s' happiness increased", "Result", JOptionPane.PLAIN_MESSAGE);
							game.takeAction();
							
							//Updates
							cropField.setText(game.getFarm().cropFieldStatus());
							
							DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
							cropListModel.addAll(game.getFarm().getAllCrops());
							cropList.setModel(cropListModel);
							
							animalFarm.setText(game.getFarm().animalFarmStatus());
							
							DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
							animalListModel.addAll(game.getFarm().getAllAnimals());
							animalList.setModel(animalListModel);
							
							moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
							
							dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
							
							actionInfo.setText(game.getActionTaken() + "/2 action taken");
							//Updates end
						} else {
							;
						}
					} else {
						JOptionPane.showMessageDialog(MainGameWindow, "No animal to play with", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(MainGameWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		playWithAnimalButton.setFont(new Font("Arial", Font.BOLD, 18));
		playWithAnimalButton.setBounds(750, 320, 200, 60);
		MainGameWindow.getContentPane().add(playWithAnimalButton);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/MainScreen.jpg")));
		Background.setBounds(0, 0, 980, 500);
		MainGameWindow.getContentPane().add(Background);
	}
}
