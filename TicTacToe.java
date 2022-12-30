package User;
import java.util.*;
public class TicTacToe {
	private static double x;// make a variable that will decide who will go first
	
public static void main (String[] args) {
	char[][] boardEx = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};// creating example board to show players where the numbers correspond to 
	char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};//creating empty 3x3 board
	System.out.println("Ready to play tic tac toe? When playing, input a number 1-9 to place your piece to the corresponding spot on the board");// statement to show users how the numbers correspond to the board spots
	printBoard(boardEx); // print example board
	Scanner scan = new Scanner (System.in); // taking in user input to start game and see who goes first
	System.out.println("Hit the enter button to see who goes first"); // prompt user to hit enter button to start whoFirst method
	whoFirst(board,scan); // whoFirst method
	printBoard(board); // print board to start game
	
	
	while (true) {
	playerMove(board, scan); // player first move
	if (isGameFinished(board)) { // check if anyone won or tie after players move
		break; // break out of loop if someone won or tie
	}
	printBoard(board); // print new board after the players move
	computerMove(board); // computer move
	if (isGameFinished(board)) { // check if anyone won or tie after computer moves
		break; // break out of loop if someone won or tie
	}
	printBoard(board); //print board after computer move then loop back to restart the process
	}
	
}

private static void whoFirst(char[][] board, Scanner scan) { //method to see who will go first
	String userInput = scan.nextLine(); // prompt user to type enter
	x=Math.random(); // assigning the variable x a random number between 0.0 and 1.0
	
	if (x<.5) { // making it 50/50 who goes first, if x<.5 then computer will go first
		System.out.println("Computer goes first!"); // print that computer goes first if x<.5 is true
		computerMove(board);// computer moves and return to original cycle
		
		
	}
	else {
		System.out.println("You go first!"); // if not, then player goes first and return to original cycle
		
	}
	
}
private static boolean isGameFinished(char[][] board) { //method to check if the game is finished
	if (whoWon(board, 'X')) { // calling the whoWon method to see if X (player) won
		printBoard(board); //if yes then print board
		System.out.println("You Win!"); // and say you won
		return true; //return true so that the other loop knows to stop
	}
	if (whoWon(board, 'O')) { //calling whoWon method to see if O (computer) won
		printBoard(board); //if true then print board
		System.out.println("Comuter Wins :/"); // say that the computer won
		return true; //return true so that the other loop knows to stop
		
	}
	
	
	for(int i=0;i<board.length;i++) { // make loop to check if each spot on the board is filled up 
		for (int j=0; j<board.length;j++) {
		if	(board[i][j]== ' ') { // if there is one spot that is open then return false
			return false;
		}
		}
	}
	printBoard(board); // if loop completes then print board
	System.out.println("You Tied!"); //state that you tie
	return true; // return true so that the loop knows to stop 
}
private static boolean whoWon(char[][] board, char symbol) {
	if    ((board[0][0] ==symbol && board[0][1] ==symbol && board[0][2] ==symbol)//rows
		|| (board[1][0] ==symbol && board[1][1] ==symbol && board[1][2] ==symbol)
		|| (board[2][0] ==symbol && board[2][1] ==symbol && board[2][2] ==symbol)
		|| (board[0][0] ==symbol && board[1][0] ==symbol && board[2][0] ==symbol)//columns
		|| (board[0][1] ==symbol && board[1][1] ==symbol && board[2][1] ==symbol)
		|| (board[0][2] ==symbol && board[1][2] ==symbol && board[2][2] ==symbol)
		|| (board[2][0] ==symbol && board[1][1] ==symbol && board[0][2] ==symbol)//diagonals
		|| (board[2][2] ==symbol && board[1][1] ==symbol && board[0][0] ==symbol)) {
		
		return true;
	}
	return false;
}
private static void computerMove(char[][] board) {
	
	
	Random rand = new Random();
	
	int computerMove;
	
	while (true) {
		// winning moves have to be done first
		if (x>.5 && isValidMove(board, "5")==true) { // if comp goes second then try to take middle if 1 is already taken
			computerMove=5;
			break;
		}
		if (isValidMove(board, "1")==true) { // Comp will take 1 if goes first or will try to if free after middle is taken when going second
			computerMove=1;
			break;
		}
		
		if (x<.5 && board[1][1]=='O'&&isValidMove(board, "3")==true) { // win if comp has 1 and middle and 3 is open 
			computerMove=3;
			break;
		}
		if (x<.5 && board[1][1]=='O'&&isValidMove(board, "9")==true) { // win if comp has 1 and middle and 9 is open 
			computerMove=9;
			break;
		}
		if (x<.5 && board[1][1]=='O'&&isValidMove(board, "7")==true) { // win if comp has 1 and middle and 9 is open 
			computerMove=7;
			break;
		}
		if(x<.5 && board[2][0]=='O'&& isValidMove(board, "4")==true) { // win if comp has 1 and 7 and 4 is open 
			computerMove=4;
			break;
			}
		if(x<.5 && board[0][2]=='O'&& isValidMove(board, "2")==true) { // win if comp has 1 and 3 and 2 is open 
			computerMove=2;
			break;
			}
		

		if (x<.5 && isValidMove(board, "3")==true && isValidMove(board, "2")==true) { // if computer goes first and 3 is free then take 3!
			computerMove=3;
			break;
		}
		if (x<.5 && board[0][1]=='X' && board[1][1]=='X' && isValidMove(board, "8")==true) { // blocks win from human if they have 2 and 5 and have 8 open
			computerMove=8;
			break;
		}
		if (x<.5 && board[0][1]=='X' && board[2][1]=='X' && isValidMove(board, "5")==true) { // blocks win from human if they go middle first
			computerMove=5;
			break;
		}
		if (x<.5 && board[0][2]=='X' && board[2][2]=='X' && isValidMove(board, "6")==true) { // if human goes middle then computer will block them at 8 if they have not already
			computerMove=6;
			break;
		}
		if (x<.5 && board[0][1]=='X' && board[1][0]=='X' && board[1][0]!='O' && isValidMove(board, "6")==true && isValidMove(board, "5")==false) { //  blocks win from human if they go middle first
			computerMove=6;
			break;
		}
		if (x<.5 && board[0][1]=='X' && board[1][2]=='X' && board[1][2]!='O' && board[1][1]=='X' && isValidMove(board, "4")==true) { // blocks win from human if they go middle first
			computerMove=4;
			break;
		}
		if (x<.5 && board[0][1]=='X' && board[2][1]=='X' && isValidMove(board, "5")==true) { // blocks win from human if they go middle first
			computerMove=5;
			break;
		}
		if (x<.5 && isValidMove(board, "7")==true && isValidMove(board, "4")==true)  { // if computer goes first and 3 is taken by X and 7 was not already taken, then take 7.  board[0][2]=='X' && board[2][0]!='O'
		computerMove=7;
		break;
		}
		
		if (x<.5 && isValidMove(board, "5")==true) { // if middle is open after being unable to do 3 2 7 or 4 then take it. 
			computerMove=5;
			break;
		}
		if (x<.5 && board[2][0]!='X'&& isValidMove(board,"3")==true) {
				computerMove=3;
				break;
			}
			if (x<.5 && board[2][0]!='X'&& isValidMove(board,"9")==true) {
				computerMove=9;
				break;
			}
			if (x<.5 && board[2][0]!='X'&& isValidMove(board,"7")==true) {
				computerMove=7;
				break;
			}
		if (x<.5 && board[1][1]=='O' && isValidMove(board, "9")==true) { // make sure that the human cant outsmart the computer if they take 7 as their first move. because then they can take 2 then 8 and then computer HAS to know it can win in this scenario
			computerMove=9;
			break;
		}
		if (x<.5 && isValidMove(board, "6")==true && isValidMove(board,"8")==false) { // worst case scenario go to 6 to ensure the tie, this would be if player takes 3 first. 
			computerMove = 6;
			break;
		}
	 computerMove = rand.nextInt(9) +1;
	if (isValidMove(board, Integer.toString(computerMove))) {
		break;
	}
	}
	System.out.println("Computer chose "+computerMove);
	placeMove(board,Integer.toString(computerMove),'O');
}
private static boolean isValidMove(char[][] board, String position) {
	switch(position) {
	case "1":
		return (board[0][0] == ' ');
		
	case "2":
		return (board[0][1] == ' '); 
		
	case "3":
		return (board[0][2] == ' ');
		
	case "4":
		return (board[1][0] == ' ');
		
	case "5":
		return (board[1][1] == ' ');
		
	case "6":
		return (board[1][2] == ' ');
		
	case "7":
		return (board[2][0] == ' ');
		
	case "8":
		return (board[2][1] == ' ');
		
	case "9":
		return (board[2][2] == ' '); 
		
	default:
		return false;
}
}

private static void playerMove(char[][] board, Scanner scan) {
	String x = "";
	while (true ) {
	System.out.println("Where would you like to play? (1-9)");
	String userInput = scan.nextLine();
	if (isValidMove(board,userInput)) {
		x=userInput;
		break;
	}
	else {
		System.out.println(userInput + " is not a valid move");
	}
	
	}
	placeMove(board, x, 'X');
}
private static void placeMove(char[][] board, String position, char symbol) {
	switch(position) {
		case "1":
			board[0][0] = symbol; 
			break;
		case "2":
			board[0][1] = symbol; 
			break;
		case "3":
			board[0][2] = symbol; 
			break;
		case "4":
			board[1][0] = symbol; 
			break;
		case "5":
			board[1][1] = symbol; 
			break;
		case "6":
			board[1][2] = symbol; 
			break;
		case "7":
			board[2][0] = symbol; 
			break;
		case "8":
			board[2][1] = symbol; 
			break;
		case "9":
			board[2][2] = symbol; 
			break;
		default:
			System.out.println(" :( ");
	}
}

private static void printBoard(char[][] board) {
	System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
	System.out.println("-----");
	System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
	System.out.println("-----");
	System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
}
}
