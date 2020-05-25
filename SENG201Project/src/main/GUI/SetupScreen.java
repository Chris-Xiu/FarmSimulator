package main.GUI;

import javax.swing.*;

import main.*;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * 
 * @author Chris Xiu
 * @author Matthias Suppan
 */

public class SetupScreen {
	
	private JFrame setupWindow;
	private GameEnvironment game;
	private JTextField nameAnswer;
	private JTextField farmNameAnswer;
	
	public SetupScreen(GameEnvironment newGameEnvironment) {
		game = newGameEnvironment;
		initialize();
		setupWindow.setVisible(true);
	}
	
	public void closeWindow() {
		setupWindow.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.setupWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupWindow = new JFrame();
		setupWindow.setTitle("Setting Up the Game");
		setupWindow.setBounds(600, 100, 540, 540);
		setupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupWindow.getContentPane().setLayout(null);
		
		JLabel durationQuestion = new JLabel("How many days would you like the game to last?");
		durationQuestion.setFont(new Font("Arial", Font.BOLD, 15));
		durationQuestion.setBounds(10, 20, 350, 50);
		setupWindow.getContentPane().add(durationQuestion);
		
		JSlider durationAnswer = new JSlider();
		durationAnswer.setFont(new Font("Arial", Font.PLAIN, 12));
		durationAnswer.setMajorTickSpacing(1);
		durationAnswer.setSnapToTicks(true);
		durationAnswer.setPaintLabels(true);
		durationAnswer.setPaintTicks(true);
		durationAnswer.setValue(5);
		durationAnswer.setMinimum(5);
		durationAnswer.setMaximum(10);
		durationAnswer.setBounds(360, 20, 150, 50);
		setupWindow.getContentPane().add(durationAnswer);
		
		JLabel nameQuestion = new JLabel("What is your name?");
		nameQuestion.setFont(new Font("Arial", Font.BOLD, 15));
		nameQuestion.setBounds(10, 80, 150, 50);
		setupWindow.getContentPane().add(nameQuestion);
		
		nameAnswer = new JTextField();
		nameAnswer.setFont(new Font("Arial", Font.BOLD, 15));
		nameAnswer.setBounds(360, 80, 150, 50);
		setupWindow.getContentPane().add(nameAnswer);
		nameAnswer.setColumns(10);
		
		JLabel ageQuestion = new JLabel("How old are you?");
		ageQuestion.setFont(new Font("Arial", Font.BOLD, 15));
		ageQuestion.setBounds(10, 140, 150, 50);
		setupWindow.getContentPane().add(ageQuestion);
		
		JSpinner ageAnswer = new JSpinner();
		ageAnswer.setModel(new SpinnerNumberModel(20, 0, 150, 1));
		ageAnswer.setFont(new Font("Arial", Font.PLAIN, 12));
		ageAnswer.setBounds(360, 140, 50, 50);
		setupWindow.getContentPane().add(ageAnswer);
		
		JLabel typeQuestion = new JLabel("There are two types of farms to choose from:");
		typeQuestion.setFont(new Font("Arial", Font.BOLD, 15));
		typeQuestion.setBounds(10, 200, 350, 50);
		setupWindow.getContentPane().add(typeQuestion);
		
		JLabel cowFarm = new JLabel("Cow");
		cowFarm.setToolTipText("You the game with 5 cows. (Normally with 0)");
		cowFarm.setFont(new Font("Arial", Font.BOLD, 20));
		cowFarm.setBounds(10, 250, 100, 100);
		setupWindow.getContentPane().add(cowFarm);
		
		JLabel wheatFarm = new JLabel("Wheat");
		wheatFarm.setToolTipText("You start the game with 20 dollars. (Normally with 10)");
		wheatFarm.setFont(new Font("Arial", Font.BOLD, 20));
		wheatFarm.setBounds(120, 250, 100, 100);
		setupWindow.getContentPane().add(wheatFarm);
		
		JLabel vegetarianFarm = new JLabel("Vegetarian");
		vegetarianFarm.setToolTipText("You start the game with 20 dollars. (Normally with 10)");
		vegetarianFarm.setFont(new Font("Arial", Font.PLAIN, 15));
		vegetarianFarm.setBounds(230, 250, 100, 100);
		setupWindow.getContentPane().add(vegetarianFarm);
		
		JLabel lifestyleBlockFarm = new JLabel("Lifestyle Block");
		lifestyleBlockFarm.setToolTipText("You start the game with 20 dollars. (Normally with 10)");
		lifestyleBlockFarm.setFont(new Font("Arial", Font.PLAIN, 15));
		lifestyleBlockFarm.setBounds(340, 250, 100, 100);
		setupWindow.getContentPane().add(lifestyleBlockFarm);
		
		JRadioButton cowFarmChoice = new JRadioButton("");
		cowFarmChoice.setSelected(true);
		cowFarmChoice.setBounds(50, 350, 20, 20);
		setupWindow.getContentPane().add(cowFarmChoice);
		
		JRadioButton wheatFarmChoice = new JRadioButton("");
		wheatFarmChoice.setBounds(150, 350, 20, 20);
		setupWindow.getContentPane().add(wheatFarmChoice);
		
		JRadioButton vegetarianFarmChoice = new JRadioButton("");
		vegetarianFarmChoice.setBounds(250, 350, 20, 20);
		setupWindow.getContentPane().add(vegetarianFarmChoice);
		
		JRadioButton lifestyleBlockFarmChoice = new JRadioButton("");
		lifestyleBlockFarmChoice.setBounds(350, 350, 20, 20);
		setupWindow.getContentPane().add(lifestyleBlockFarmChoice);
		
		ButtonGroup group = new ButtonGroup();
		group.add(cowFarmChoice);
		group.add(wheatFarmChoice);
		group.add(vegetarianFarmChoice);
		group.add(lifestyleBlockFarmChoice);
		
		JLabel farmNameQuestion = new JLabel("How would you like to name your farm?");
		farmNameQuestion.setFont(new Font("Arial", Font.BOLD, 15));
		farmNameQuestion.setBounds(10, 380, 280, 50);
		setupWindow.getContentPane().add(farmNameQuestion);
		
		farmNameAnswer = new JTextField();
		farmNameAnswer.setFont(new Font("Arial", Font.BOLD, 15));
		farmNameAnswer.setBounds(360, 380, 150, 50);
		setupWindow.getContentPane().add(farmNameAnswer);
		farmNameAnswer.setColumns(10);
		
		JButton startButton = new JButton("Start");
		startButton.setFont(new Font("Arial", Font.PLAIN, 15));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int duration = durationAnswer.getValue();
				game.setDuration(duration);
				
				String name = nameAnswer.getText();
				int age = (Integer) ageAnswer.getValue();
				Farmer theFarmer = new Farmer(name, age);
				
				String farmName = farmNameAnswer.getText();
				String type;
				if (cowFarmChoice.isSelected()) {
					type = "Cow";
				} else if (wheatFarmChoice.isSelected()) {
					type = "Wheat";
				} else if (vegetarianFarmChoice.isSelected()) {
					type = "Vegetarian";
				} else {
					type = "Lifestyle Block";
				}
				
				Farm theFarm = new Farm(type);
				theFarm.setFarmer(theFarmer);
				theFarm.setName(farmName);
				game.setFarm(theFarm);
				
				finishedWindow();
			}
		});
		startButton.setBounds(360, 460, 150, 30);
		setupWindow.getContentPane().add(startButton);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(SetupScreen.class.getResource("/Images/SetupScreen.jpg")));
		background.setBounds(0, 0, 525, 500);
		setupWindow.getContentPane().add(background);
	}
}
