import java.util.Random;
import java.util.Scanner;

class Game{
	int systemInput;
	int userInput;
	int noOfGuesses=0;
	//generating random number in dafault constructore
	Game(){
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
		
	}
	
	//method to take user guesses
	public boolean takeUserInput() {
		if(noOfGuesses <10) {
			System.out.println("Guess the number:");
			this.userInput =GuessTheNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
			
			
		}
		
	}
	
	//method to check user guess status
	
	public boolean isCorrectGuess()
	{
		
		if ( systemInput == userInput ) {
			System.out.println("Congratulations, you guess the number " + systemInput +
			  		" in " + noOfGuesses + " guesses");
		
			
			      switch(noOfGuesses) {
			      
			      
			      case 1:
			       System.out.println("Your score is 100");
			       break;
			       
			       case 2:
			       System.out.println("Your score is 90");
			         break;
			         
			           case 3:
						System.out.println("Your score is 80");
						break;
						case 4:
							
						System.out.println("Your score is 70");
						break;
						
						case 5:		
						System.out.println("Your score is 60");
						break;
						
						case 6:
							
						System.out.println("Your score is 50");
						break;
						
						case 7:
							
						System.out.println("Your score is 40");
						break;
						
						
						case 8:
							System.out.println("Your score is 30");
							break;
							
							case 9:
							System.out.println("Your score is 20");
							break;
							
							case 10:
							System.out.println("Your score is 10");
							break;
			
		}
			      
        System.out.println();
        return true;
        
	}
		else if(noOfGuesses <10 && userInput > systemInput) {
			if ( userInput - systemInput > 10 ) {
				System.out.println("Too High");
			
		}
			else {
				
				System.out.println("Little High");
			}
			
			
		}
		
		else if( noOfGuesses < 10 && userInput < systemInput) {
				
			
			
			if ( systemInput - userInput > 10 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
	 return false;
	 
}
}




//main class 

public class GuessTheNumber {
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc= new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
			
				
			if(flag && input > limit || input <1) {
				System.out.println("choose the number between 1 to  " + limit);
				flag = false;
			}
			}catch(Exception e) {
				System.out.println("Enter only intger value");
				flag = false;		
						
						
			}
			
		}
		return input;
		
		
		
	}
	
//main method
	
	public static void main(String[] args) {
		
		System.out.println("1. Start the Game \n2. Exit");
		System.out.print("Enter your choice : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		if (choice == 1) {
			
			while (nextRound == 1) {
				Game game = new Game();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound" +  ++noOfRound + "starts");
				
				while (!isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
					
					
				}
				//input for next Round 
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("enter your choice :");
				nextRound = takeIntegerInput(2);
				if(nextRound !=1) {
					System.exit(0);
				}
			}
		}
		else {
			
			
			System.exit(0);
		}
		
	}

}
