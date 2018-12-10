package OneTwoThreeBet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OneTwoThreeGui extends JFrame {

	private String[] numberChoose = new String[] { "1", "2", "3" };

	// Java Labels
	private JLabel buyInLbl = new JLabel("Buy In:");
	private JLabel chooseNumberLbl = new JLabel("Choose your number:");
	private JLabel amountBetLbl = new JLabel("Bet Amount:");

	// Java Text Fields
	private JTextField buyInTxtFld = new JTextField(8);
	private JTextField amountBetTxtFld = new JTextField(8);
	private JTextArea outputArea = new JTextArea("Welcome to the OneTwoThreeBet game!\n"
			+ "-------------------------------------------------------------------------\n"
			+ "Rules\n"
			+ "1: Add balance\n"
			+ "2: Choose a number between 1-3\n"
			+ "3: Enter bet amount\n"
			+ "-------------------------------------------------------------------------\n"
			+ "If number picked is correct, the amount of bet will double to balance.\n"
			+ "If number picked is incorrect, the amount of bet will subtract to balance\n\n");
	
	// Java ComboBox
	private JComboBox<String> chooseNumber = new JComboBox<>(numberChoose);
	
	// Java Buttons
	private JButton addBuyInBtn = new JButton("Add Balance");
	private JButton betBtn = new JButton("Bet");
	private JButton balanceBtn = new JButton("Balance");
	private JButton rulesBtn = new JButton("Rules");
	private JButton clearBtn = new JButton("Clear");

	// Java ScrollPane
	private JScrollPane txtAreaView = new JScrollPane(outputArea);

	// Java Panels
	private JPanel buyInFlowLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel chooseNumberFlowLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel amountToBet = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel btnLayout = new JPanel(new FlowLayout());
	private JPanel TopFlowLayout = new JPanel(new BorderLayout());
	private JPanel CenterFlowLayout = new JPanel(new BorderLayout());
	private JPanel finalBorderLayout = new JPanel(new BorderLayout());
	private JPanel final1 = new JPanel(new BorderLayout());
	
	AddToBalance balance = new AddToBalance();
	BetGame Bet = new BetGame();

	// Constructor
	public OneTwoThreeGui() {
		
		super("The One Two Three Bet!!!!!");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		outputArea.setEditable(false);

		clearBtn.addActionListener(new AddBtnListener());
		addBuyInBtn.addActionListener(new AddBtnListener());
		balanceBtn.addActionListener(new AddBtnListener());
		rulesBtn.addActionListener(new AddBtnListener());
		betBtn.addActionListener(new AddBtnListener());
		
		createBuyInFlowLayout();
		createChooseNumber();
		createAmountToBet();
		createBtnLayout();
		addToFrame();
		add(final1);

	}

	// Java Layouts
	private void addToFrame() {
		
		TopFlowLayout.add(buyInFlowLayout, BorderLayout.NORTH);
		TopFlowLayout.add(chooseNumberFlowLayout, BorderLayout.CENTER);

		CenterFlowLayout.add(amountToBet, BorderLayout.NORTH);
		CenterFlowLayout.add(btnLayout, BorderLayout.CENTER);

		finalBorderLayout.add(TopFlowLayout, BorderLayout.NORTH);
		finalBorderLayout.add(CenterFlowLayout, BorderLayout.CENTER);

		final1.add(finalBorderLayout, BorderLayout.NORTH);
		final1.add(txtAreaView, BorderLayout.CENTER);
		
	}

	private void createBuyInFlowLayout() {
		
		buyInFlowLayout.add(buyInLbl);
		buyInFlowLayout.add(buyInTxtFld);
		buyInFlowLayout.add(addBuyInBtn);
		
	}

	private void createChooseNumber() {
		
		chooseNumberFlowLayout.add(chooseNumberLbl);
		chooseNumberFlowLayout.add(chooseNumber);
		
	}

	private void createAmountToBet() {
		
		amountToBet.add(amountBetLbl);
		amountToBet.add(amountBetTxtFld);
		
	}

	private void createBtnLayout() {
		
		btnLayout.add(betBtn);
		btnLayout.add(balanceBtn);
		btnLayout.add(rulesBtn);
		btnLayout.add(clearBtn);
		
	}
	
	// Action Button Listener
	private class AddBtnListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String callingBtn = e.getActionCommand();

			if (callingBtn.equals("Clear")) {
				
				outputArea.setText("");
				
			} else if (callingBtn.equals("Add Balance")) {
				
				try {
					double adding = Double.parseDouble(buyInTxtFld.getText());
					
					//Makes sure that the user doesn't input numbers less than 0
					if (adding > 0) {
						balance.addBalance(adding);
						outputArea.append(balance.toString() + "\n");
						buyInTxtFld.setText("");
					} else {
						outputArea.append("Please enter a number greater than zero!\n");
					}
					
				} catch (Exception ex) {
					
					outputArea.append("Please make sure you enter something greater than zero!\n");
					
				}
				
			} else if(callingBtn.equals("Balance")) {
				
				outputArea.append(balance.toString()+"\n");
				
			} else if(callingBtn.equals("Rules")) {
				
				outputArea.append("Rules\n"
					+ "1: Add balance\n"
					+ "2: Choose a number between 1-3\n"
					+ "3: Enter bet amount\n"
					+ "-------------------------------------------------------------------------\n"
					+ "If number picked is correct, the amount of bet will double to balance.\n"
					+ "If number picked is incorrect, the amount of bet will subtract to balance\n"
					+ "-------------------------------------------------------------------------\n");
			
			} else if(callingBtn.equals("Bet")) {
				
				int chooseNum = chooseNumber.getSelectedIndex();
				Double betAmount = Double.parseDouble(amountBetTxtFld.getText());
				amountBetTxtFld.setText("");
				Bet.playGame(chooseNum, balance.getBalance(), betAmount);
				
				outputArea.append(Bet.toString());
				
			}
		}
	}
		

	public static void main(String[] args) {
		
		OneTwoThreeGui Frame = new OneTwoThreeGui();
		Frame.setVisible(true);
		
	}

}