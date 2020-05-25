package game.GUI;

import javax.swing.*;

import game.*;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.*;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class MainScreen {
	
	private JFrame mainWindow;
	private GameEnvironment game;
	private JLabel cropFieldLable;
	private JList cropListInfo;
	private JLabel animalFarmLabel;
	private JList animalListInfo;
	private JLabel moneyOwnedLabel;
	private JLabel dayInfoLabel;
	private JLabel actionInfoLabel;
	
	
	
	public MainScreen(GameEnvironment newGameEnvironment) {
		game = newGameEnvironment;
		initialize();
		mainWindow.setVisible(true);
	}
	
	public void closeWindow() {
		mainWindow.dispose();
	}
	
	public void pauseWindow() {
		mainWindow.setEnabled(false);
	}
	
	public void resumeWindow() {
		mainWindow.setEnabled(true);
	}
	
	public void updateWindow() {
		//Updates
		cropFieldLable.setText(game.getFarm().cropFieldStatus());
		
		DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
		cropListModel.addAll(game.getFarm().getAllCrops());
		cropListInfo.setModel(cropListModel);
		
		animalFarmLabel.setText(game.getFarm().animalFarmStatus());
		
		DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
		animalListModel.addAll(game.getFarm().getAllAnimals());
		animalListInfo.setModel(animalListModel);
		
		moneyOwnedLabel.setText(String.valueOf(game.getFarm().getMoneyOwned()));
		
		dayInfoLabel.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
		
		actionInfoLabel.setText(game.getActionTaken() + "/2 action taken");
		//Updates end
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.mainWindow.setVisible(true);
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
		mainWindow = new JFrame();
		mainWindow.setTitle("Farm Simulator");
		mainWindow.setBounds(380, 100, 990, 540);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JLabel farmName = new JLabel("");
		farmName.setHorizontalAlignment(SwingConstants.CENTER);
		farmName.setFont(new Font("Arial", Font.BOLD, 20));
		farmName.setBounds(400, 10, 200, 50);
		mainWindow.getContentPane().add(farmName);
		farmName.setText(game.getFarm().getName());
		
		JLabel farmStatus = new JLabel("Farm Status:");
		farmStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		farmStatus.setBounds(10, 70, 100, 30);
		mainWindow.getContentPane().add(farmStatus);
		
		JLabel cropField = new JLabel("");
		cropField.setFont(new Font("Arial", Font.BOLD, 15));
		cropField.setBounds(10, 110, 450, 30);
		mainWindow.getContentPane().add(cropField);
		cropField.setText(game.getFarm().cropFieldStatus());
		cropFieldLable = cropField;
		
		DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
		cropListModel.addAll(game.getFarm().getAllCrops());
		JList<Crop> cropList = new JList<>(cropListModel);
		cropList.setBounds(10, 140, 300, 150);
		mainWindow.getContentPane().add(cropList);
		cropListInfo = cropList;
		
		JLabel animalFarm = new JLabel("");
		animalFarm.setFont(new Font("Arial", Font.BOLD, 15));
		animalFarm.setBounds(10, 300, 450, 30);
		mainWindow.getContentPane().add(animalFarm);
		animalFarm.setText(game.getFarm().animalFarmStatus());
		animalFarmLabel = animalFarm;
		
		DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
		animalListModel.addAll(game.getFarm().getAllAnimals());
		JList<Animal> animalList = new JList<>(animalListModel);
		animalList.setBounds(10, 330, 300, 150);
		mainWindow.getContentPane().add(animalList);
		animalListInfo = animalList;
		
		JLabel moneyOwned = new JLabel("");
		moneyOwned.setHorizontalAlignment(SwingConstants.RIGHT);
		moneyOwned.setFont(new Font("Arial", Font.PLAIN, 20));
		moneyOwned.setBounds(320, 430, 50, 50);
		mainWindow.getContentPane().add(moneyOwned);
		moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
		moneyOwnedLabel = moneyOwned;
		
		JLabel moneySign = new JLabel("");
		moneySign.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/Goldcoin.jpg")));
		moneySign.setBounds(380, 430, 50, 50);
		mainWindow.getContentPane().add(moneySign);
		
		JLabel dayInfo = new JLabel("");
		dayInfo.setFont(new Font("Arial", Font.PLAIN, 20));
		dayInfo.setBounds(10, 10, 200, 50);
		mainWindow.getContentPane().add(dayInfo);
		dayInfo.setText("Day " + game.getCurrentDay() + " of " + game.getGameDuration() + " days");
		dayInfoLabel = dayInfo;
		
		JLabel actionInfo = new JLabel("");
		actionInfo.setFont(new Font("Arial", Font.PLAIN, 20));
		actionInfo.setBounds(500, 430, 150, 50);
		mainWindow.getContentPane().add(actionInfo);
		actionInfo.setText(game.getActionTaken() + "/2 action taken");
		actionInfoLabel = actionInfo;
		
		JButton nextDayButton = new JButton("Go to next day");
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCurrentDay() != game.getGameDuration()) {
					int money = game.moveToNextDay();
					JOptionPane.showMessageDialog(mainWindow, "Earned " + money + " dollar from your animals", "Result", JOptionPane.PLAIN_MESSAGE);
					
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
					int moneyOwned = game.getFarm().getMoneyOwned();
					int cropValue = game.getFarm().getCropValue();
					int animalValue = game.getFarm().getAnimalValue();
					int itemValue = game.getFarm().getAnimalValue();
					int cropScore = cropValue / 2;
					int itemScore = itemValue / 2;
					int finalScore = moneyOwned + animalValue + cropScore + itemScore;
					JOptionPane.showMessageDialog(mainWindow, "Victory Point Conversion:\nMoney Left: 1 dollar for 1 VP\nAnimal Farm Value: 1 dollar worth of animal for 1 VP\n"
							+ "Crop Field Value: 2 dollar worth of crop for 1 VP (Penalty for failed to harvest)\nItem Left: 2 dollar worth of item for 1 VP"
							+ " (Penalty for failed to harvest)\n\nYour Score:\nMoney Left: " + moneyOwned + "\nAnimal Value: " + animalValue + "\nCrop Value:"
							+ cropValue + "\nItem Value: " + itemValue + "\nFinal Score: " + moneyOwned + " + " + animalValue + " + " + cropScore + " + "
							+ itemScore + " = " + finalScore, "Final Score", JOptionPane.PLAIN_MESSAGE);
					closeWindow();
				}
			}
		});
		nextDayButton.setFont(new Font("Arial", Font.BOLD, 20));
		nextDayButton.setBounds(750, 420, 200, 60);
		mainWindow.getContentPane().add(nextDayButton);
		
		JButton vistStoreButton = new JButton("Visit store");
		vistStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.launchStoreScreen();
			}
		});
		vistStoreButton.setFont(new Font("Arial", Font.BOLD, 18));
		vistStoreButton.setBounds(500, 140, 200, 60);
		mainWindow.getContentPane().add(vistStoreButton);
		
		JButton tendFarmlandButton = new JButton("Tend farmland");
		tendFarmlandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					game.getFarm().tending();
					JOptionPane.showMessageDialog(mainWindow, "Farmland tended, capacities of holding crops and animals both increased by 5\nHappiness growth rate of animals increased by 1", "Result", JOptionPane.PLAIN_MESSAGE);
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
					JOptionPane.showMessageDialog(mainWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tendFarmlandButton.setFont(new Font("Arial", Font.BOLD, 18));
		tendFarmlandButton.setBounds(750, 140, 200, 60);
		mainWindow.getContentPane().add(tendFarmlandButton);
		
		JButton tendCropButton = new JButton("Tend crops");
		tendCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String[] ownedCropList = game.getFarm().getCropArray();
					if (ownedCropList.length > 0) {
						String[] options = {"Watering", "Using an item", "Cancel"};
						int choice = JOptionPane.showOptionDialog(mainWindow, "How would you like to tend your crops?","Choose a method", 
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if (choice == 0) {
							String cropChoice = (String) JOptionPane.showInputDialog(mainWindow, "What type of crop do you want to water?", 
									"Choose type of crop", JOptionPane.QUESTION_MESSAGE, null, ownedCropList, null);
							if (cropChoice != null) {
								game.getFarm().waterCrops(game.getFarm().getCropIndex(cropChoice));
								JOptionPane.showMessageDialog(mainWindow, cropChoice + " in your farm have been watered, 1 day closer to be harvested", "Result", JOptionPane.PLAIN_MESSAGE);
								game.takeAction();
							} else {
								;
							}
						} else if (choice == 1) {
							String cropChoice = (String) JOptionPane.showInputDialog(mainWindow, "What type of crop do you want to use item on?", 
									"Choose type of crop", JOptionPane.QUESTION_MESSAGE, null, ownedCropList, null);
							if (cropChoice != null) {
								int cropIndex = game.getFarm().getCropIndex(cropChoice);
								String[] ownedItemList = game.getFarm().getCropItemArray();
								if (ownedItemList.length > 0) {
									String itemChoice = (String) JOptionPane.showInputDialog(mainWindow, "Which crop item do you want to use?", 
											"Choose item", JOptionPane.QUESTION_MESSAGE, null, ownedItemList, null);
									if (itemChoice != null) {
										int beforeTime = game.getFarm().getCropList().get(cropIndex).get(0).getDaysUntilHarvest();
										game.getFarm().getItemList().get(game.getFarm().getItemIndex(itemChoice)).useItem(game.getFarm(), cropIndex);
										int afterTime = game.getFarm().getCropList().get(cropIndex).get(0).getDaysUntilHarvest();
										int difference = beforeTime - afterTime;
										JOptionPane.showMessageDialog(mainWindow, itemChoice + " used on " + cropChoice + ", " + difference + " day closer to be harvested", "Result", JOptionPane.PLAIN_MESSAGE);
										game.takeAction();
									} else {
										;
									}
								} else {
									JOptionPane.showMessageDialog(mainWindow, "No crop item to use", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								;
							}
						} else {
							;
						}
					} else {
						JOptionPane.showMessageDialog(mainWindow, "No crop to tend to", "Error", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(mainWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tendCropButton.setFont(new Font("Arial", Font.BOLD, 18));
		tendCropButton.setBounds(500, 230, 200, 60);
		mainWindow.getContentPane().add(tendCropButton);
		
		JButton feedAnimalButton = new JButton("Feed animals");
		feedAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String[] ownedAnimalList = game.getFarm().getAnimalArray();
					String[] ownedItemList = game.getFarm().getFoodItemArray();
					if (ownedAnimalList.length == 0) {
						JOptionPane.showMessageDialog(mainWindow, "No animal to be fed", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (ownedItemList.length == 0) {
						JOptionPane.showMessageDialog(mainWindow, "No food item to feed", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String animalChoice = (String) JOptionPane.showInputDialog(mainWindow, "What type of animal do you want to feed?", 
								"Choose type of animal", JOptionPane.QUESTION_MESSAGE, null, ownedAnimalList, null);
						if (animalChoice != null) {
							String itemChoice = (String) JOptionPane.showInputDialog(mainWindow, "Which food item do you want to use?", 
									"Choose item", JOptionPane.QUESTION_MESSAGE, null, ownedItemList, null);
							if (itemChoice != null) {
								int animalIndex = game.getFarm().getAnimalIndex(animalChoice);
								int itemIndex = game.getFarm().getItemIndex(itemChoice);
								game.getFarm().getItemList().get(itemIndex).useItem(game.getFarm(), animalIndex);
								JOptionPane.showMessageDialog(mainWindow, "Your " + Farm.animalReference[animalIndex] + "s' healthiness increased", "Result", JOptionPane.PLAIN_MESSAGE);
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
					JOptionPane.showMessageDialog(mainWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		feedAnimalButton.setFont(new Font("Arial", Font.BOLD, 18));
		feedAnimalButton.setBounds(500, 320, 200, 60);
		mainWindow.getContentPane().add(feedAnimalButton);
		
		JButton harvestCropButton = new JButton("Harvest crops");
		harvestCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String harvestMessage = game.getFarm().harvestableCrops();
					if (harvestMessage.length() == 0) {
						JOptionPane.showMessageDialog(mainWindow, "No crop to be harvested", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						int choice = JOptionPane.showConfirmDialog(mainWindow, "Are you sure you want to harvest the following crops:\n" + harvestMessage,  "Confirmation", JOptionPane.YES_NO_OPTION);
						if (choice == JOptionPane.YES_OPTION) {
							int money = game.getFarm().harvestCrops();
							JOptionPane.showMessageDialog(mainWindow, "Crops harvested, " + money + " dollars earned", "Result", JOptionPane.PLAIN_MESSAGE);
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
					JOptionPane.showMessageDialog(mainWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		harvestCropButton.setFont(new Font("Arial", Font.BOLD, 18));
		harvestCropButton.setBounds(750, 230, 200, 60);
		mainWindow.getContentPane().add(harvestCropButton);
		
		JButton playWithAnimalButton = new JButton("Play with animals");
		playWithAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getActionTaken() < 2) {
					String[] ownedAnimalList = game.getFarm().getAnimalArray();
					if (ownedAnimalList.length > 0) {
						String choice = (String) JOptionPane.showInputDialog(mainWindow, "What type of animal do you want to play with?", 
								"Choose type of animal", JOptionPane.QUESTION_MESSAGE, null, ownedAnimalList, null);
						if (choice != null) {
							int animalIndex = game.getFarm().getAnimalIndex(choice);
							game.getFarm().playWithAnimals(animalIndex);
							JOptionPane.showMessageDialog(mainWindow, "Your " + Farm.animalReference[animalIndex] + "s' happiness increased", "Result", JOptionPane.PLAIN_MESSAGE);
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
						JOptionPane.showMessageDialog(mainWindow, "No animal to play with", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(mainWindow, "No more actions allowed for today", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		playWithAnimalButton.setFont(new Font("Arial", Font.BOLD, 18));
		playWithAnimalButton.setBounds(750, 320, 200, 60);
		mainWindow.getContentPane().add(playWithAnimalButton);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/MainScreen.jpg")));
		background.setBounds(0, 0, 980, 500);
		mainWindow.getContentPane().add(background);
	}
}
