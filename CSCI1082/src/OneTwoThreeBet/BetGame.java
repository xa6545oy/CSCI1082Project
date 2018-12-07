package OneTwoThreeBet;

import java.util.Random;

public class BetGame {
	
	Random rand = new Random();
	
	AddToBalance balance = new AddToBalance();
	
	public double randomNum = rand.nextInt(6) + 5;
	
	public BetGame() {
		
		
	}

	public double getRandomNum() {
		
		return randomNum;
		
	}

	public void setRandomNum(double randomNum) {
		
		this.randomNum = randomNum;
		
	}
	
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
