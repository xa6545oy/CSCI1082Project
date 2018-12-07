package OneTwoThreeBet;

import java.util.Random;

public class BetGame {
	
	Random rand = new Random();
	AddToBalance balance = new AddToBalance();
	
	// Identifier 
	public double randomNum = rand.nextInt(6) + 5;
	
	// Constructor
	public BetGame() {
		
		
	}

	// Accessor Method
	public double getRandomNum() {
		
		return randomNum;
		
	}

	// Mutator Method
	public void setRandomNum(double randomNum) {
		
		this.randomNum = randomNum;
		
	}
	
	// Play Game Method
	public void playGame(double guessNumber, double totalBalance, double bet) {
		
		for(int count = 0; balance.getBalance() <= 0; count++) {
			
			if (randomNum == guessNumber) {
				
				totalBalance += bet;
				
			} else if (randomNum != guessNumber) {
				
				totalBalance -= bet;
				
			}
			
		}
		
	}

}
