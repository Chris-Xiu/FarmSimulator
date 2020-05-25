package game.GUI;

import javax.swing.*;

import game.*;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.*;
import java.awt.Color;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class StoreScreen {

	private JFrame storeWindow;
	private GameEnvironment game;
	private MainScreen mainScreenWindow;
	private JLabel moneyOwnedLabel;
	private JLabel tenEightyOwnedLabel;
	private JLabel fertilizerOwnedLabel;
	private JLabel irrigationOwnedLabel;
	private JLabel fodderOwnedLabel;
	private JLabel freshHayOwnedLabel;
	private JLabel newPaddockOwnedLabel;
	
	public StoreScreen(GameEnvironment newGameEnvironment, MainScreen newMainScreen) {
		game = newGameEnvironment;
		mainScreenWindow = newMainScreen;
		initialize();
		storeWindow.setVisible(true);
		mainScreenWindow.pauseWindow();
	}
	
	public void closeWindow() {
		mainScreenWindow.resumeWindow();
		storeWindow.dispose();
	}
	
	public void finishedWindow() {
		game.closeStoreScreen(this);
	}
	
	private void buyCrop(int type) {
		String name = Farm.cropReference[type];
		int price = game.getFarm().getCropPrice(type);
		int money = game.getFarm().getMoneyOwned();
		int amountAffordable = money / price;
		int spaceAvailable = game.getFarm().getMaxCrops() - game.getFarm().getAmountOfCrops();
		if (amountAffordable > 0) {
			if (spaceAvailable > 0) {
				if (spaceAvailable >= amountAffordable) {
					String[] amount = new String[amountAffordable];
					for(int i = 0; i < amount.length; i++)
						amount[i] = String.valueOf(i + 1);
					String choice = (String) JOptionPane.showInputDialog(storeWindow, "You have " + money + " dollars\nThe price for one " + name + " is " + price + 
							" dollars\nHow many would you like to buy?", "Purchasing " + name, JOptionPane.QUESTION_MESSAGE, null, amount, null);
					if (choice != null) {
						int choiceAmount = Integer.parseInt(choice);
						game.getFarm().buyCrops(choiceAmount, type);
						JOptionPane.showMessageDialog(storeWindow, choiceAmount + " " + name + " have been purchased and planted", "Result", JOptionPane.PLAIN_MESSAGE);
						moneyOwnedLabel.setText(String.valueOf(game.getFarm().getMoneyOwned()));
						mainScreenWindow.updateWindow();
					} else {
						;
					}
				} else {
					String[] amount = new String[spaceAvailable];
					for(int i = 0; i < amount.length; i++)
						amount[i] = String.valueOf(i + 1);
					String choice = (String) JOptionPane.showInputDialog(storeWindow, "You have " + money + " dollars\nThe price for one " + name + " is " + price + 
							" dollars\nHowever, you can only purchase up to " + spaceAvailable + " " + name + "s, due to the space limitation of your farmland size\\nHow many would you like to buy?", 
							"Purchasing " + name, JOptionPane.QUESTION_MESSAGE, null, amount, null);
					if (choice != null) {
						int choiceAmount = Integer.parseInt(choice);
						game.getFarm().buyCrops(choiceAmount, type);
						JOptionPane.showMessageDialog(storeWindow, choiceAmount + " " + name + " have been purchased and planted", "Result", JOptionPane.PLAIN_MESSAGE);
						moneyOwnedLabel.setText(String.valueOf(game.getFarm().getMoneyOwned()));
						mainScreenWindow.updateWindow();
					} else {
						;
					}
				}
			} else {
				JOptionPane.showMessageDialog(storeWindow, "Not enough space in your farmland, please tend your farm to increase capaciy", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(storeWindow, "You cannot afford any", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void buyAnimal(int type) {
		String name = Farm.animalReference[type];
		int price = game.getFarm().getAnimalPrice(type);
		int money = game.getFarm().getMoneyOwned();
		int amountAffordable = money / price;
		int spaceAvailable = game.getFarm().getMaxAnimals() - game.getFarm().getAmountOfAnimals();
		if (amountAffordable > 0) {
			if (spaceAvailable > 0) {
				if (spaceAvailable >= amountAffordable) {
					String[] amount = new String[amountAffordable];
					for(int i = 0; i < amount.length; i++)
						amount[i] = String.valueOf(i + 1);
					String choice = (String) JOptionPane.showInputDialog(storeWindow, "You have " + money + " dollars\nThe price for one " + name + " is " + price + 
							" dollars\nHow many would you like to buy?", "Purchasing " + name, JOptionPane.QUESTION_MESSAGE, null, amount, null);
					if (choice != null) {
						int choiceAmount = Integer.parseInt(choice);
						game.getFarm().buyAnimals(choiceAmount, type);
						JOptionPane.showMessageDialog(storeWindow, choiceAmount + " " + name + " have been purchased", "Result", JOptionPane.PLAIN_MESSAGE);
						moneyOwnedLabel.setText(String.valueOf(game.getFarm().getMoneyOwned()));
						mainScreenWindow.updateWindow();
					} else {
						;
					}
				} else {
					String[] amount = new String[spaceAvailable];
					for(int i = 0; i < amount.length; i++)
						amount[i] = String.valueOf(i + 1);
					String choice = (String) JOptionPane.showInputDialog(storeWindow, "You have " + money + " dollars\nThe price for one " + name + " is " + price + 
							" dollars\nHowever, you can only purchase up to " + spaceAvailable + " " + name + "s, due to the space limitation of your farm\\nHow many would you like to buy?", 
							"Purchasing " + name, JOptionPane.QUESTION_MESSAGE, null, amount, null);
					if (choice != null) {
						int choiceAmount = Integer.parseInt(choice);
						game.getFarm().buyAnimals(choiceAmount, type);
						JOptionPane.showMessageDialog(storeWindow, choiceAmount + " " + name + " have been purchased", "Result", JOptionPane.PLAIN_MESSAGE);
						moneyOwnedLabel.setText(String.valueOf(game.getFarm().getMoneyOwned()));
						mainScreenWindow.updateWindow();
					} else {
						;
					}
				}
			} else {
				JOptionPane.showMessageDialog(storeWindow, "Not enough space in your farm, please tend your farm to increase capaciy", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(storeWindow, "You cannot afford any", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void buyItem(int type) {
		String name = Farm.itemReference[type];
		int price = game.getFarm().getItemPrice(type);
		int money = game.getFarm().getMoneyOwned();
		int amountAffordable = money / price;
		if (amountAffordable > 0) {
			String[] amount = new String[amountAffordable];
			for(int i = 0; i < amount.length; i++)
				amount[i] = String.valueOf(i + 1);
			String choice = (String) JOptionPane.showInputDialog(storeWindow, "You have " + money + " dollars\nThe price for one " + name + " is " + price + 
					" dollars\nHow many would you like to buy?", "Purchasing " + name, JOptionPane.QUESTION_MESSAGE, null, amount, null);
			if (choice != null) {
				int choiceAmount = Integer.parseInt(choice);
				game.getFarm().buyItem(choiceAmount, type);
				JOptionPane.showMessageDialog(storeWindow, choiceAmount + " " + name + " have been purchased", "Result", JOptionPane.PLAIN_MESSAGE);
				moneyOwnedLabel.setText(String.valueOf(game.getFarm().getMoneyOwned()));
				mainScreenWindow.updateWindow();
				tenEightyOwnedLabel.setText("(" + game.getFarm().getItemList().get(0).getAmount() + " owned)");
				fertilizerOwnedLabel.setText("(" + game.getFarm().getItemList().get(1).getAmount() + " owned)");
				irrigationOwnedLabel.setText("(" + game.getFarm().getItemList().get(2).getAmount() + " owned)");
				fodderOwnedLabel.setText("(" + game.getFarm().getItemList().get(3).getAmount() + " owned)");
				freshHayOwnedLabel.setText("(" + game.getFarm().getItemList().get(4).getAmount() + " owned)");
				newPaddockOwnedLabel.setText("(" + game.getFarm().getItemList().get(5).getAmount() + " owned)");
			} else {
				;
			}
		} else {
			JOptionPane.showMessageDialog(storeWindow, "You cannot afford any", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreScreen window = new StoreScreen();
					window.storeWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		storeWindow = new JFrame();
		storeWindow.setTitle("General Store");
		storeWindow.setBounds(700, 100, 990, 540);
		storeWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		storeWindow.getContentPane().setLayout(null);
		
		JButton quitButton = new JButton("Leave");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		quitButton.setFont(new Font("Arial", Font.PLAIN, 15));
		quitButton.setBounds(800, 440, 100, 30);
		storeWindow.getContentPane().add(quitButton);
		
		JLabel moneyOwned = new JLabel("");
		moneyOwned.setHorizontalAlignment(SwingConstants.RIGHT);
		moneyOwned.setFont(new Font("Arial", Font.PLAIN, 20));
		moneyOwned.setBounds(640, 420, 50, 50);
		storeWindow.getContentPane().add(moneyOwned);
		moneyOwned.setText(String.valueOf(game.getFarm().getMoneyOwned()));
		moneyOwnedLabel = moneyOwned;
		
		JLabel moneySign = new JLabel("");
		moneySign.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/Goldcoin.jpg")));
		moneySign.setBounds(700, 420, 50, 50);
		storeWindow.getContentPane().add(moneySign);
		
		JLabel tenEightyPrice = new JLabel("1080");
		tenEightyPrice.setHorizontalAlignment(SwingConstants.CENTER);
		tenEightyPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		tenEightyPrice.setBounds(50, 165, 100, 30);
		storeWindow.getContentPane().add(tenEightyPrice);
		
		JLabel fertilizerPrice = new JLabel("Fertilizer");
		fertilizerPrice.setHorizontalAlignment(SwingConstants.CENTER);
		fertilizerPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		fertilizerPrice.setBounds(200, 165, 100, 30);
		storeWindow.getContentPane().add(fertilizerPrice);
		
		JLabel irrigationPrice = new JLabel("Irrigation");
		irrigationPrice.setHorizontalAlignment(SwingConstants.CENTER);
		irrigationPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		irrigationPrice.setBounds(350, 165, 100, 30);
		storeWindow.getContentPane().add(irrigationPrice);
		
		JLabel fodderPrice = new JLabel("Fodder");
		fodderPrice.setHorizontalAlignment(SwingConstants.CENTER);
		fodderPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		fodderPrice.setBounds(500, 165, 100, 30);
		storeWindow.getContentPane().add(fodderPrice);
		
		JLabel freshHayPrice = new JLabel("Fresh Hay");
		freshHayPrice.setHorizontalAlignment(SwingConstants.CENTER);
		freshHayPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		freshHayPrice.setBounds(650, 165, 100, 30);
		storeWindow.getContentPane().add(freshHayPrice);
		
		JLabel newPaddockPrice = new JLabel("New Paddock");
		newPaddockPrice.setHorizontalAlignment(SwingConstants.CENTER);
		newPaddockPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		newPaddockPrice.setBounds(800, 165, 100, 30);
		storeWindow.getContentPane().add(newPaddockPrice);
		
		JLabel cornPrice = new JLabel("Corn");
		cornPrice.setHorizontalAlignment(SwingConstants.CENTER);
		cornPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		cornPrice.setBounds(50, 333, 100, 30);
		storeWindow.getContentPane().add(cornPrice);
		
		JLabel lettucePrice = new JLabel("Lettuce");
		lettucePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lettucePrice.setFont(new Font("Arial", Font.PLAIN, 25));
		lettucePrice.setBounds(200, 333, 100, 30);
		storeWindow.getContentPane().add(lettucePrice);
		
		JLabel potatoPrice = new JLabel("Potato");
		potatoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		potatoPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		potatoPrice.setBounds(350, 333, 100, 30);
		storeWindow.getContentPane().add(potatoPrice);
		
		JLabel wheatPrice = new JLabel("Wheat");
		wheatPrice.setHorizontalAlignment(SwingConstants.CENTER);
		wheatPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		wheatPrice.setBounds(500, 333, 100, 30);
		storeWindow.getContentPane().add(wheatPrice);
		
		JLabel tomatoPrice = new JLabel("Tomato");
		tomatoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		tomatoPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		tomatoPrice.setBounds(650, 333, 100, 30);
		storeWindow.getContentPane().add(tomatoPrice);
		
		JLabel carrotPrice = new JLabel("Carrot");
		carrotPrice.setHorizontalAlignment(SwingConstants.CENTER);
		carrotPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		carrotPrice.setBounds(800, 333, 100, 30);
		storeWindow.getContentPane().add(carrotPrice);
		
		JLabel cowPrice = new JLabel("Cow");
		cowPrice.setHorizontalAlignment(SwingConstants.CENTER);
		cowPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		cowPrice.setBounds(50, 470, 100, 30);
		storeWindow.getContentPane().add(cowPrice);
		
		JLabel sheepPrice = new JLabel("Sheep");
		sheepPrice.setHorizontalAlignment(SwingConstants.CENTER);
		sheepPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		sheepPrice.setBounds(200, 470, 100, 30);
		storeWindow.getContentPane().add(sheepPrice);
		
		JLabel deerPrice = new JLabel("Deer");
		deerPrice.setHorizontalAlignment(SwingConstants.CENTER);
		deerPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		deerPrice.setBounds(350, 470, 100, 30);
		storeWindow.getContentPane().add(deerPrice);
		
		JButton tenEightyButton = new JButton("");
		tenEightyButton.setToolTipText("1080 reduces days to harvest by 2 but reduces all your Animal's health by 1!");
		tenEightyButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/TenEighty.png")));
		tenEightyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(0);
			}
		});
		tenEightyButton.setFont(new Font("Arial", Font.PLAIN, 15));
		tenEightyButton.setBounds(50, 40, 100, 100);
		storeWindow.getContentPane().add(tenEightyButton);
		
		JButton fertilizerButton = new JButton("");
		fertilizerButton.setToolTipText("Fertilizer reduces days to harvest by 3 and has no side effects.");
		fertilizerButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Fertilizer.png")));
		fertilizerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(1);
			}
		});
		fertilizerButton.setFont(new Font("Arial", Font.PLAIN, 15));
		fertilizerButton.setBounds(200, 40, 100, 100);
		storeWindow.getContentPane().add(fertilizerButton);
		
		JButton irrigationButton = new JButton("");
		irrigationButton.setToolTipText("Irrigation reduces days to harvest by 5.");
		irrigationButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Irrigation.png")));
		irrigationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(2);
			}
		});
		irrigationButton.setFont(new Font("Arial", Font.PLAIN, 15));
		irrigationButton.setBounds(350, 40, 100, 100);
		storeWindow.getContentPane().add(irrigationButton);
		
		JButton fodderButton = new JButton("");
		fodderButton.setToolTipText("Fodder increases your Animal's health by 1.");
		fodderButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Fodder.png")));
		fodderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(3);
			}
		});
		fodderButton.setFont(new Font("Arial", Font.PLAIN, 15));
		fodderButton.setBounds(500, 40, 100, 100);
		storeWindow.getContentPane().add(fodderButton);
		
		JButton freshHayButton = new JButton("");
		freshHayButton.setToolTipText("Fresh hay increases your Animal;s health by 2 and makes their happiness increase by 1 every day.");
		freshHayButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/FreshHay.png")));
		freshHayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(4);
			}
		});
		freshHayButton.setFont(new Font("Arial", Font.PLAIN, 10));
		freshHayButton.setBounds(650, 40, 100, 100);
		storeWindow.getContentPane().add(freshHayButton);
		
		JButton newPaddockButton = new JButton("");
		newPaddockButton.setToolTipText("A New Paddock increases your Animal's health by 4 and increases their happiness by 2 every day!");
		newPaddockButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/NewPaddock.png")));
		newPaddockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(5);
			}
		});
		newPaddockButton.setFont(new Font("Arial", Font.PLAIN, 10));
		newPaddockButton.setBounds(800, 40, 100, 100);
		storeWindow.getContentPane().add(newPaddockButton);
		
		JButton cornButton = new JButton("");
		cornButton.setToolTipText("Corn takes 4 days to grow and sells for $9.");
		cornButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Corn.png")));
		cornButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCrop(0);
			}
		});
		cornButton.setFont(new Font("Arial", Font.PLAIN, 15));
		cornButton.setBounds(50, 225, 100, 100);
		storeWindow.getContentPane().add(cornButton);
		
		JButton lettuceButton = new JButton("");
		lettuceButton.setToolTipText("Lettuce takes 2 days to grow and sells for $4.");
		lettuceButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Lettuce.png")));
		lettuceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCrop(1);
			}
		});
		lettuceButton.setFont(new Font("Arial", Font.PLAIN, 15));
		lettuceButton.setBounds(200, 225, 100, 100);
		storeWindow.getContentPane().add(lettuceButton);
		
		JButton patatoButton = new JButton("");
		patatoButton.setToolTipText("Patatoes take 5 days to grow and sell for $8.");
		patatoButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Potato.png")));
		patatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCrop(2);
			}
		});
		patatoButton.setFont(new Font("Arial", Font.PLAIN, 15));
		patatoButton.setBounds(350, 225, 100, 100);
		storeWindow.getContentPane().add(patatoButton);
		
		JButton wheatButton = new JButton("");
		wheatButton.setToolTipText("Wheat takes 3 days to grow and sells for $5.");
		wheatButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Wheat.png")));
		wheatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCrop(3);
			}
		});
		wheatButton.setFont(new Font("Arial", Font.PLAIN, 15));
		wheatButton.setBounds(500, 225, 100, 100);
		storeWindow.getContentPane().add(wheatButton);
		
		JButton tomatoButton = new JButton("");
		tomatoButton.setToolTipText("Tomatoes take 2 days to grow and sells for $6.");
		tomatoButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Tomato.png")));
		tomatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCrop(4);
			}
		});
		tomatoButton.setFont(new Font("Arial", Font.PLAIN, 15));
		tomatoButton.setBounds(650, 225, 100, 100);
		storeWindow.getContentPane().add(tomatoButton);
		
		JButton carrotButton = new JButton("Carrots take 1 day to grow and sells for $3.");
		carrotButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Carrot.png")));
		carrotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCrop(5);
			}
		});
		carrotButton.setFont(new Font("Arial", Font.PLAIN, 15));
		carrotButton.setBounds(800, 225, 100, 100);
		storeWindow.getContentPane().add(carrotButton);
		
		JButton cowButton = new JButton("");
		cowButton.setToolTipText("Cows have a happiness of 2 and a health of 6. They lose 2 happiness a day. You should fix that as soon as you can!");
		cowButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Cow.png")));
		cowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyAnimal(0);
			}
		});
		cowButton.setFont(new Font("Arial", Font.PLAIN, 15));
		cowButton.setBounds(50, 370, 100, 100);
		storeWindow.getContentPane().add(cowButton);
		
		JButton sheepButton = new JButton("");
		sheepButton.setToolTipText("Sheep have a happiness of 4 and a health of 4. They don't require much maintenance.");
		sheepButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Sheep.png")));
		sheepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyAnimal(1);
			}
		});
		sheepButton.setFont(new Font("Arial", Font.PLAIN, 15));
		sheepButton.setBounds(200, 370, 100, 100);
		storeWindow.getContentPane().add(sheepButton);
		
		JButton deerButton = new JButton("");
		deerButton.setToolTipText("Deer have a happiness of 2 and a health of 2. They gain 2 health a day. Quite the investment!");
		deerButton.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/Deer.png")));
		deerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyAnimal(2);
			}
		});
		deerButton.setFont(new Font("Arial", Font.PLAIN, 15));
		deerButton.setBounds(350, 370, 100, 100);
		storeWindow.getContentPane().add(deerButton);
		
		JLabel tenEightyOwned = new JLabel("");
		tenEightyOwned.setForeground(Color.WHITE);
		tenEightyOwned.setHorizontalAlignment(SwingConstants.CENTER);
		tenEightyOwned.setFont(new Font("Arial", Font.PLAIN, 15));
		tenEightyOwned.setBounds(50, 140, 100, 25);
		storeWindow.getContentPane().add(tenEightyOwned);
		tenEightyOwned.setText("(" + game.getFarm().getItemList().get(0).getAmount() + " owned)");
		tenEightyOwnedLabel = tenEightyOwned;
		
		JLabel fertilizerOwned = new JLabel("");
		fertilizerOwned.setForeground(Color.WHITE);
		fertilizerOwned.setHorizontalAlignment(SwingConstants.CENTER);
		fertilizerOwned.setFont(new Font("Arial", Font.PLAIN, 15));
		fertilizerOwned.setBounds(200, 140, 100, 25);
		storeWindow.getContentPane().add(fertilizerOwned);
		fertilizerOwned.setText("(" + game.getFarm().getItemList().get(1).getAmount() + " owned)");
		fertilizerOwnedLabel = fertilizerOwned;
		
		JLabel irrigationOwned = new JLabel("");
		irrigationOwned.setForeground(Color.WHITE);
		irrigationOwned.setHorizontalAlignment(SwingConstants.CENTER);
		irrigationOwned.setFont(new Font("Arial", Font.PLAIN, 15));
		irrigationOwned.setBounds(350, 140, 100, 25);
		storeWindow.getContentPane().add(irrigationOwned);
		irrigationOwned.setText("(" + game.getFarm().getItemList().get(2).getAmount() + " owned)");
		irrigationOwnedLabel = irrigationOwned;
		
		JLabel fodderOwned = new JLabel("");
		fodderOwned.setForeground(Color.WHITE);
		fodderOwned.setHorizontalAlignment(SwingConstants.CENTER);
		fodderOwned.setFont(new Font("Arial", Font.PLAIN, 15));
		fodderOwned.setBounds(500, 140, 100, 25);
		storeWindow.getContentPane().add(fodderOwned);
		fodderOwned.setText("(" + game.getFarm().getItemList().get(3).getAmount() + " owned)");
		fodderOwnedLabel = fodderOwned;
		
		JLabel freshHayOwned = new JLabel("");
		freshHayOwned.setForeground(Color.WHITE);
		freshHayOwned.setHorizontalAlignment(SwingConstants.CENTER);
		freshHayOwned.setFont(new Font("Arial", Font.PLAIN, 15));
		freshHayOwned.setBounds(650, 140, 100, 25);
		storeWindow.getContentPane().add(freshHayOwned);
		freshHayOwned.setText("(" + game.getFarm().getItemList().get(4).getAmount() + " owned)");
		freshHayOwnedLabel = freshHayOwned;
		
		JLabel newPaddockOwned = new JLabel("");
		newPaddockOwned.setForeground(Color.WHITE);
		newPaddockOwned.setHorizontalAlignment(SwingConstants.CENTER);
		newPaddockOwned.setFont(new Font("Arial", Font.PLAIN, 15));
		newPaddockOwned.setBounds(800, 140, 100, 25);
		storeWindow.getContentPane().add(newPaddockOwned);
		newPaddockOwned.setText("(" + game.getFarm().getItemList().get(5).getAmount() + " owned)");
		newPaddockOwnedLabel = newPaddockOwned;
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(StoreScreen.class.getResource("/Images/StoreScreen.jpg")));
		background.setBounds(0, 0, 980, 500);
		storeWindow.getContentPane().add(background);
	}
}
