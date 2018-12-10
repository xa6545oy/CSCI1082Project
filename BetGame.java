package OneTwoThreeBet;

import java.util.Random;

public class BetGame {
	
	Random rand = new Random();
	AddToBalance balance = new AddToBalance();
	
	// Identifier 
	public int randomNum = rand.nextInt(2) + 1;
	public int guess;
	public double bet;
	
	// Constructor
	public BetGame() {
		
	}

	// Accessor Method
	public int getRandomNum() {
		return randomNum;
	}
	
	// Mutator Method
	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}
	
	// Play Game Method
		public void playGame(int guessNumber, double totalBalance, double bet) {
			
			if (randomNum == guessNumber) {
				totalBalance += bet;
				System.out.println("You win!\n");
				System.out.println(totalBalance + "\n");
			} else if (randomNum != guessNumber) {
					
				totalBalance -= bet;
				System.out.println("You lose!\n");
				System.out.println(totalBalance + "\n");
			}
				
		}
	
	@Override
	public String toString() {
		String randomNumString = Integer.toString(this.randomNum);
		return "Random Number: " + randomNumString + "\n";
	}

}
