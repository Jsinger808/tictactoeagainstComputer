// Tic-Tac-Toe Game.
import java.util.*;
public class tictactoe {
	
	static String[] board;
	static String turn;
	
	static int difficulty = 0;
	static int firstTurn = 1;
	
	//HashMap for Counters for lines.
	static HashMap<String, Integer> counterSums = new HashMap<String, Integer>();	
	static {
		counterSums.put("row1", 0);
		counterSums.put("row2", 0);
		counterSums.put("row3", 0);
		counterSums.put("column1", 0);
		counterSums.put("column2", 0);
		counterSums.put("column3", 0);
		counterSums.put("diagonal1", 0);
		counterSums.put("diagonal2", 0);
	}
	
	// CheckWinner method will
	// decide the combination
	// of three box given below.
	static String checkWinner()
	{
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			//For X winner
			if (line.equals("XXX")) {
				return "X";
			}
			
			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		//Checks draws by looking for valid squares
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8){
				return "draw";
			}
		}

	// To enter the X Or O at the exact place on board.
		if (turn == "X") {
		System.out.println(
				"Computer's turn. Please wait.");
		return null;
		}
		else {
			System.out.println(
					"X's turn; enter a slot number to place X in:");
			return null;
		}
	}
	
	// To print out the board.
	/* |---|---|---|
	| 1 | 2 | 3 |
	|-----------|
	| 4 | 5 | 6 |
	|-----------|
	| 7 | 8 | 9 |
	|---|---|---|*/
	
	static void printBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | "
						+ board[1] + " | " + board[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | "
						+ board[4] + " | " + board[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | "
						+ board[7] + " | " + board[8]
						+ " |");
		System.out.println("|---|---|---|");
	}
	
	static boolean intelligenceTest () {
	//Determines odds if Computer will block two X's in a line. 
	//Easy sets it to 50%. 
	//Medium sets it to 75%. 
	//Hard sets it to 100%.
		Random rand = new Random();
	 int rand_int1 = rand.nextInt(3);
	 if (rand_int1 < difficulty) {
		 return true;
	 }
		 else {
			 return false;
		 }
	 }

	
	public static void difficultySelection () {
		while (difficulty == 0) {
		Scanner textscan = new Scanner(System.in);
		String playerDecision = textscan.nextLine();
		System.out.println(playerDecision);
		if (playerDecision.equals("Easy")) {
			difficulty = 1;
			System.out.println("You have selected 'Easy.'");
			break;
		}
		else if (playerDecision.equals("Medium")) {
			difficulty = 2;
			System.out.println("You have selected 'Medium.'");
			break;
		}
		else if (playerDecision.equals("Hard")) {
			difficulty = 3;
			System.out.println("You have selected 'Hard.'");
			break;
		}
		else {
			System.out.println("Please enter a valid difficulty:");
		}
		}
	}
	
	public static void counterAddOrSubtract (Integer numInput) {
		//Adds or subtracts unique values to lines
		//based on whether an X or an O
		//was placed on a square in those lines. 
		HashMap<Integer, Integer> counterTable = new HashMap<Integer, Integer>();
		counterTable.put(1, 12);
		counterTable.put(2, 11);
		counterTable.put(3, 13);
		counterTable.put(4, 14);
		counterTable.put(5, 15);
		counterTable.put(6, 16);
		counterTable.put(7, 17);
		counterTable.put(8, 18);
		counterTable.put(9, 19);
		counterTable.put(-1, -12);
		counterTable.put(-2, -11);
		counterTable.put(-3, -13);
		counterTable.put(-4, -14);
		counterTable.put(-5, -15);
		counterTable.put(-6, -16);
		counterTable.put(-7, -17);
		counterTable.put(-8, -18);
		counterTable.put(-9, -19);

		//Visual to show point values for each board[]..
		/* |------|------|------|
		   | 0:12 | 1:11 | 2:13 |
		   |--------------------|
		   | 3:14 | 4:15 | 5:16 |
		   |--------------------|
		   | 6:17 | 7:18 | 8:19 |
		   |------|------|------|*/
		
		int incrementAmount = counterTable.get(numInput); 
		
		switch (Math.abs(numInput)) {
		case 1:
			counterSums.put("row1", incrementAmount + counterSums.get("row1"));
			counterSums.put("column1", incrementAmount + counterSums.get("column1"));
			counterSums.put("diagonal1", incrementAmount + counterSums.get("diagonal1"));
			break;
		case 2:
			counterSums.put("row1", incrementAmount + counterSums.get("row1"));
			counterSums.put("column2", incrementAmount + counterSums.get("column2"));
			break;
		case 3:
			counterSums.put("row1", incrementAmount + counterSums.get("row1"));
			counterSums.put("column3", incrementAmount + counterSums.get("column3"));
			counterSums.put("diagonal2", incrementAmount + counterSums.get("diagonal2"));
			break;
		case 4:
			counterSums.put("row2", incrementAmount + counterSums.get("row2"));
			counterSums.put("column1", incrementAmount + counterSums.get("column1"));
			break;
		case 5:
			counterSums.put("row2", incrementAmount + counterSums.get("row2"));
			counterSums.put("column2", incrementAmount + counterSums.get("column2"));
			counterSums.put("diagonal1", incrementAmount + counterSums.get("diagonal1"));
			counterSums.put("diagonal2", incrementAmount + counterSums.get("diagonal2"));
			break;
		case 6:
			counterSums.put("row2", incrementAmount + counterSums.get("row2"));
			counterSums.put("column3", incrementAmount + counterSums.get("column3"));
			break;
		case 7:
			counterSums.put("row3", incrementAmount + counterSums.get("row3"));
			counterSums.put("column1", incrementAmount + counterSums.get("column1"));
			counterSums.put("diagonal2", incrementAmount + counterSums.get("diagonal2"));
			break;
		case 8:
			counterSums.put("row3", incrementAmount + counterSums.get("row3"));
			counterSums.put("column2", incrementAmount + counterSums.get("column2"));
			break;
		case 9:
			counterSums.put("row3", incrementAmount + counterSums.get("row3"));
			counterSums.put("column3", incrementAmount + counterSums.get("column3"));
			counterSums.put("diagonal1", incrementAmount + counterSums.get("diagonal1"));
			break;
		}
	}
	
	static void computerTurn() {
		
	//First turn is random. 
	//If the Computer passes intenlligenceTest, then
	//it'll look to win this turn.
	//If it can't, then it'll look to block
	//this turn. If there's nothing to block,
	//then it'll move randomly. 
		if (firstTurn == 1) {
			moveRandomly();
			firstTurn = 0;
		}
		else if (intelligenceTest()) {
			playToWin();
			}
		else {
			moveRandomly();
			}
	}
		
 
	public static void playToWin() {
		
		//Computer checks line counters to find two O's
		//without any X's in the same line. If it sees one,
		//it'll place an O in the missing square and win.
		
		//-23 is an important number since it's the lowest point sum
		//for two O's (-11 + -12).
		
		if (counterSums.get("row1") <= -23) {
			if (counterSums.get("row1") == -23) {
				board[2] = "O";
				counterAddOrSubtract(-3); //This could definitely be coded better.
			}
			else if (counterSums.get("row1") == -24) {
				board[0] = "O";
				counterAddOrSubtract(-1);
			}
			else if (counterSums.get("row1") == -25) {
				board[1] = "O";
				counterAddOrSubtract(-2);
			}
		}
		else if (counterSums.get("row2") <= -23) {
			if (counterSums.get("row2") == -29) {
				board[5] = "O";
				counterAddOrSubtract(-6);
			}
			else if (counterSums.get("row2") == -30) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("row2") == -31) {
				board[3] = "O";
				counterAddOrSubtract(-4);
			}
		}
		else if (counterSums.get("row3") <= -23) {
			if (counterSums.get("row3") == -35) {
				board[8] = "O";
				counterAddOrSubtract(-9);
			}
			else if (counterSums.get("row3") == -36) {
				board[7] = "O";
				counterAddOrSubtract(-8);
			}
			else if (counterSums.get("row3") == -37) {
				board[6] = "O";
				counterAddOrSubtract(-7);
			}
		}
		else if (counterSums.get("column1") <= -23) {
			if (counterSums.get("column1") == -26) {
				board[6] = "O";
				counterAddOrSubtract(-7);
			}
			else if (counterSums.get("column1") == -29) {
				board[3] = "O";
				counterAddOrSubtract(-4);
			}
			else if (counterSums.get("column1") == -31) {
				board[0] = "O";
				counterAddOrSubtract(-1);
			}
		}
		else if (counterSums.get("column2") <= -23) {
			if (counterSums.get("column2") == -26) {
				board[7] = "O";
				counterAddOrSubtract(-8);
			}
			else if (counterSums.get("column2") == -29) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("column2") == -33) {
				board[1] = "O";
				counterAddOrSubtract(-2);
			}
		}
		else if (counterSums.get("column3") <= -23) {
			if (counterSums.get("column3") == -29) {
				board[8] = "O";
				counterAddOrSubtract(-9);
			}
			else if (counterSums.get("column3") == -32) {
				board[5] = "O";
				counterAddOrSubtract(-6);
			}
			else if (counterSums.get("column3") == -35) {
				board[2] = "O";
				counterAddOrSubtract(-3);
			}
		}
		else if (counterSums.get("diagonal1") <= -23) {
			if (counterSums.get("diagonal1") == -27) {
				board[8] = "O";
				counterAddOrSubtract(-9);
			}
			else if (counterSums.get("diagonal1") == -31) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("diagonal1") == -35) {
				board[0] = "O";
				counterAddOrSubtract(-1);
			}
		}
		else if (counterSums.get("diagonal2") <= -23) {
			if (counterSums.get("diagonal2") == -28) {
				board[6] = "O";
				counterAddOrSubtract(-7);
			}
			else if (counterSums.get("diagonal2") == -30) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("diagonal2") == -32) {
				board[2] = "O";
				counterAddOrSubtract(-3);
			}
		}
		else {
			checkCountersToBlock();
		}
	}
	
	public static void checkCountersToBlock() {
			
		//Computer checks line counters to find two X's
		//without any O's in the same line. If it sees one,
		//it'll place an O in the missing square and prevent the user's win.
		
		if (counterSums.get("row1") >= 23) {
			if (counterSums.get("row1") == 23) {
				board[2] = "O";
				counterAddOrSubtract(-3);
			}
			else if (counterSums.get("row1") == 24) {
				board[0] = "O";
				counterAddOrSubtract(-1);
			}
			else if (counterSums.get("row1") == 25) {
				board[1] = "O";
				counterAddOrSubtract(-2);
			}
		}
		else if (counterSums.get("row2") >= 23) {
			if (counterSums.get("row2") == 29) {
				board[5] = "O";
				counterAddOrSubtract(-6);
			}
			else if (counterSums.get("row2") == 30) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("row2") == 31) {
				board[3] = "O";
				counterAddOrSubtract(-4);
			}
		}
		else if (counterSums.get("row3") >= 23) {
			if (counterSums.get("row3") == 35) {
				board[8] = "O";
				counterAddOrSubtract(-9);
			}
			else if (counterSums.get("row3") == 36) {
				board[7] = "O";
				counterAddOrSubtract(-8);
			}
			else if (counterSums.get("row3") == 37) {
				board[6] = "O";
				counterAddOrSubtract(-7);
			}
		}
		else if (counterSums.get("column1") >= 23) {
			if (counterSums.get("column1") == 26) {
				board[6] = "O";
				counterAddOrSubtract(-7);
			}
			else if (counterSums.get("column1") == 29) {
				board[3] = "O";
				counterAddOrSubtract(-4);
			}
			else if (counterSums.get("column1") == 31) {
				board[0] = "O";
				counterAddOrSubtract(-1);
			}
		}
		else if (counterSums.get("column2") >= 23) {
			if (counterSums.get("column2") == 26) {
				board[7] = "O";
				counterAddOrSubtract(-8);
			}
			else if (counterSums.get("column2") == 29) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("column2") == 33) {
				board[1] = "O";
				counterAddOrSubtract(-2);
			}
		}
		else if (counterSums.get("column3") >= 23) {
			if (counterSums.get("column3") == 29) {
				board[8] = "O";
				counterAddOrSubtract(-9);
			}
			else if (counterSums.get("column3") == 32) {
				board[5] = "O";
				counterAddOrSubtract(-6);
			}
			else if (counterSums.get("column3") == 35) {
				board[2] = "O";
				counterAddOrSubtract(-3);
			}
		}
		else if (counterSums.get("diagonal1") >= 23) {
			if (counterSums.get("diagonal1") == 27) {
				board[8] = "O";
				counterAddOrSubtract(-9);
			}
			else if (counterSums.get("diagonal1") == 31) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("diagonal1") == 35) {
				board[0] = "O";
				counterAddOrSubtract(-1);
			}
		}
		else if (counterSums.get("diagonal2") >= 23) {
			if (counterSums.get("diagonal2") == 28) {
				board[6] = "O";
				counterAddOrSubtract(-7);
			}
			else if (counterSums.get("diagonal2") == 30) {
				board[4] = "O";
				counterAddOrSubtract(-5);
			}
			else if (counterSums.get("diagonal2") == 32) {
				board[2] = "O";
				counterAddOrSubtract(-3);
			}
		}
		else {
			moveRandomly();
		}
	}
	
	static void moveRandomly() {
		//If inteligenceTest fails, 
		//or if Computer can't win this turn or see any two X's to block,
		//then it will default to moving randomly.
		int rand_int2 = -1;
		while (rand_int2 == -1 || (board[rand_int2] == "X" || board[rand_int2] == "O")) {
			Random rand = new Random();
			rand_int2 = rand.nextInt(8);
		}
		board[rand_int2] = "O";
		counterAddOrSubtract((rand_int2 + 1) * -1);
		
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		board = new String[9];
		turn = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}

		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		
		
		System.out.println("Type Difficulty: Easy, Medium, or Hard.");
		difficultySelection();
		
		printBoard();
		
		System.out.println(
			"X will play first. Enter a slot number to place X in:");

		while (winner == null) {
			int numInput;
			
		// Exception handling.
		// numInput will take input from user like from 1 to 9.
		// If it is not in range from 1 to 9.
		// then it will show you an error "Invalid input."
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println(
						"Invalid input; re-enter slot number:");
					continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(
					"Invalid input; re-enter slot number:");
				continue;
			}
			
			// X's turn.
			if (board[numInput - 1].equals(
					String.valueOf(numInput))) {
				board[numInput - 1] = turn;
				counterAddOrSubtract(numInput);
				printBoard();
				winner = checkWinner();
				if (winner == "X") {
					break;
				}
				//Computer's turn.
				turn = "O";
				computerTurn();
				printBoard();
				winner = checkWinner();
				turn = "X";
			}
			else {
				System.out.println(
					"Slot already taken; re-enter slot number:");
			}
		}
		
		// If no one wins or loses
		// then here is the logic to print "draw".
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println(
				"It's a draw! Thanks for playing.");
		}
		
		// A Congratulations! message for the winner.
		else {
			System.out.println(
				"Congratulations! " + winner
				+ "'s have won! Thanks for playing.");
		}
	}
}
