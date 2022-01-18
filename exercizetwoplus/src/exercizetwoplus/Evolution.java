package exercizetwoplus;
import java.util.Random;
import java.util.Scanner;

public class Evolution {
	static Random rand =new Random();
	public static int score = 0;
	public static Monkey[][] board = new Monkey[4][4];
	public static Monkey[][] boardBack = new Monkey[4][4] ;
	public static int bestScore = 0;
	public static int continueAfterWin = 0;
	public static boolean gameOver = false;
	public static Scanner sc = new Scanner(System.in);
	public static int money = 0;

	public static int maxAge = rand.nextInt(4)+5;
	public static void main(String[] args) {
		
		resetBoard();
		startGame();
		while (gameOver==false) { 
			printBoard();
			nextMove();
			checkWinOrLose();
		}
	}
	public static void startGame() { //asking if user want to start.
		System.out.println("Welcome, would you like to start the game?");
		String ans = sc.next();
		if(ans.equals("n")) {
			gameOver=true;
		}
		else if (ans.equals("y")){
			System.out.println("The max age is: " + maxAge );
			return;
		}
	}
	public static void resetBoard() { // making the board null and adding 2 random monkeys.
		score = 0;
		money=0;
		for(int i=0;i<4;i++) {
			for (int j =0;j<4;j++) {
				board[i][j] = null;
			}
		}
		addRandomMonkey();
		addRandomMonkey();
	}
	public static void printBoard() { //printing the board at the time
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if (board[i][j] == null) {
					System.out.print("#     ");
				}
				else {
					System.out.print(board[i][j].getName()+ board[i][j].getAge() + "    "); 
				}
			}
			System.out.println();
		}
	}

		public static void checkWinOrLose() { 
			int countLose = 0;
			int countWin = 0;
			for(int i=0;i<4;i++) { // check if the board is full
				for(int j=0;j<4;j++) {
					if(board[i][j]!=null) {
						countLose++;
					}
					if (board[i][j] instanceof Human) {
						if (board[i][j].getAge()>= maxAge) {
							countWin=1;
						}
					}
				}
			}
			if(countLose==16 && canSum()== false) { //if the board fuul and the user cant move.
				System.out.println("Game over your score is " + score + ". For a new game press y, n if not");
				String input = sc.next();
				if(input.equals("n")) { //quit
					gameOver=true;
				}
				if(input.equals("y")) { //start new game.
					resetBoard();
				}
				else { //if other option ask him again.
					checkWinOrLose();
				}
			}
			if(countWin==1 && continueAfterWin==0){ //if human at max age at the first time.
				System.out.println("You won! Old Human! would you like to continue? Press y if yes, n if not");
				String input = sc.next();
				if(input.equals("n")) {
					gameOver=true;
				}
				if(input.equals("y")) { //the user continue and will not ask him again never.
					continueAfterWin = 1;
					
				}
			}
		}
		public static boolean canSum() { 
			if(canSumLeft()==false && canSumRight()==false && canSumUp()==false && canSumDown()==false) {
				return false;
			}
			return true;
		}
		public static boolean canSumDown() {
			for (int i=3;i>=1;i--) {
				for(int j=0;j<=3;j++) {
					if(board[i][j] != null && board[i-1][j] != null && board[i][j].getAge()==board[i-1][j].getAge() && board[i][j].getName().equals(board[i-1][j].getName()) ) {
						return true; 
					}
				}
			}
			return false;
		}
		public static boolean canSumUp() {
			for (int i=0;i<=2;i++) {
				for(int j=0;j<=3;j++) {
					if(board[i][j] != null && board[i+1][j] != null && board[i][j].getAge()==board[i+1][j].getAge()&& board[i][j].getName().equals(board[i+1][j].getName())) {
						return true;
					}
				}
			}
			return false;
		}
		public static boolean canSumRight() {
			for (int i=0;i<=3;i++) {
				for(int j=3;j>=1;j--) {
					if(board[i][j] != null && board[i][j-1] != null && board[i][j].getAge()==board[i][j-1].getAge()&& board[i][j].getName().equals(board[i][j-1].getName())) {
						return true;
					}
				}
			}
			return false;
		}
		public static boolean canSumLeft() {
			for (int i=0;i<=3;i++) {
				for(int j=0;j<=2;j++) {
					if(board[i][j] != null && board[i][j+1] != null && board[i][j].getAge()==board[i][j+1].getAge()&& board[i][j].getName().equals(board[i][j+1].getName())) {
						return true;
					}
				}
			}
			return false;
		}
		public static int[] randEmptyBlock () { // giving back one of the places with null from board.
			int [] choosen = new int [2];
			int [][] emptyArr =new int [16][2]; 
			int n = 0;
			for (int i = 0; i < board.length; i++ ) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == null) {
						emptyArr[n][0]=i;
						emptyArr[n][1]=j;
						n++;
					}
				}
			}
			if (n != 0) { // if board have empty blocks.
				Random rand = new Random();
				int val = rand.nextInt(n);
				choosen[0] = emptyArr[val][0];
				choosen[1] = emptyArr[val][1];
			}
			return choosen;
		}

		public static void addRandomMonkey () {
			int [] arr = randEmptyBlock ();
			Monkey alon = new Monkey();
			alon.randAge();
			board[arr[0]][arr[1]] = alon ;
		} 

		public static void nextMove() { // what the user wants to do now.
			String step = userDisplay();
			if(step.equals("r")) {
				switchBoard();
				return;
			}
			copyBoard();
			if(step.equals("s")) {
				moveDown();
			}
			if(step.equals("w")) {
				moveUp();
			}
			if(step.equals("a")) {
				moveLeft();
			}
			if(step.equals("d")) {
				moveRight();
			}
			if(step.equals("e")) { //exit
				gameOver=true;
			}
			if(step.equals("n")) { //start new game.
				resetBoard();
				printBoard();
				nextMove();
			}
			addRandomMonkey();
		}
		public static void checkPossibleDown() {
			if( canMoveDown() == false && canSumDown() == false) {
				System.out.println("oh no! cant possible my friend. please choole different direction ;) ");
				printBoard();
				nextMove();
			}	
		}
		public static void checkPossibleUp() {
			if( canMoveUp() == false && canSumUp() == false) {
				System.out.println("oh no! cant possible my friend. please choole different direction ;) ");
				printBoard();
				nextMove();
			}	
		}
		public static void checkPossibleRight() {
			if( canMoveRight() == false && canSumRight() == false) {
				System.out.println("oh no! cant possible my friend. please choole different direction ;) ");
				printBoard();
				nextMove();
			}
			
		}
		public static void checkPossibleLeft() {
			if( canMoveLeft() == false && canSumLeft() == false) {
				System.out.println("oh no! cant possible my friend. please choole different direction ;) ");
				printBoard();
				nextMove();
			}	
		}
		public static boolean canMoveDown() {
			for (int i=0;i<=2;i++) {
				for(int j=0;j<=3;j++) {
					if(board[i][j] != null && board[i+1][j] == null) {
						return true;
					}
				}
			}
			return false;
		}
		public static boolean canMoveUp() {
			for (int i=3;i>=1;i--) {
				for(int j=0;j<=3;j++) {
					if(board[i][j] != null && board[i-1][j] == null) {
						return true;
					}
				}
			}
			return false;
		}
		public static boolean canMoveRight() {
			for (int i=0;i<=3;i++) {
				for(int j=0;j<=2;j++) {
					if(board[i][j] != null && board[i][j+1] == null) {
						return true;
					}
				}
			}
			return false;
		}
		public static boolean canMoveLeft() {
			for (int i=0;i<=3;i++) {
				for(int j=3;j>=1;j--) {
					if(board[i][j] != null && board[i][j-1] == null) {
						return true;
					}
				}
			}
			return false;
		}
		public static void copyBoard() {
			for (int i=0;i<=3;i++) {
				for(int j=0;j<=3;j++) {
					boardBack[i][j]=board[i][j];
				}
			}
		}
		public static void switchBoard() { //
			Monkey [][] temp = boardBack;
			boardBack = board;
			board = temp;
		}
		public static void moveLeft() {
			checkPossibleLeft();
			monkeyLeft();
			sumLeft();
			monkeyLeft();
		}
		public static void moveRight() {
			checkPossibleRight();
			monkeyRight();
			sumRight();
			monkeyRight();
		}
		public static void moveUp() {
			checkPossibleUp();
			monkeyUp();
			sumUp();
			monkeyUp();
		}
		public static void moveDown() {
			checkPossibleDown();
			MonkeyDown();
			sumDown();
			MonkeyDown();
		}
		public static void MonkeyDown() { // taking  the relevant numbers down
			for(int k=0;k<=2;k++) {
				for (int i=0;i<=2;i++) {
					for(int j=0;j<=3;j++) {
						if(board[i][j] != null && board[i+1][j] == null) {
							board[i+1][j]= board[i][j];
							board[i][j]=null;
						}
					}
				}
			}
		}
		public static void sumDown() { ////sum  the relevant monkeys
			for (int i=3;i>=1;i--) {
				for(int j=0;j<=3;j++) {
					if(board[i][j] !=null && board[i-1][j] !=null && board[i][j].getName().equals(board[i-1][j].getName()) && board[i][j].getAge()==board[i-1][j].getAge()) { 
						board[i][j].sumAge();
						board[i-1][j]=null;
						
						if ( board[i][j] instanceof Flinston) {
							for(int k=0;k<4;k++) {
								for(int m=0;m<4;m++) {
									if (board[k][m]!=null && board[k][m].getName().equals("M")) {
										board[k][m].sumAge();
										if(board[k][m].getAge() >= maxAge) {
											board [k][m] = board[k][m].evolution();		
										}
									}	
								}
							}
						}
						if(board[i][j] instanceof Human) {
							((Human) board[i][j]).sumMoney();
							money = money + ((Human) board [i][j]).getMoney();
						}
						if(board[i][j].getAge() >= maxAge) {
							if (!(board[i][j] instanceof Human)) {
								board [i][j] = board[i][j].evolution();
							}
							if (board[i][j] instanceof Human) {
								money = money+ ((Human) board[i][j]).getMoney();
							}
						}
						
						score = score +board[i][j].getScore(); //calc the new score
						if( bestScore <= score ) {
							bestScore = score;
						}
					}
				}
			}
		}
		public static void monkeyUp() {
			for(int k=0;k<=2;k++) {
				for (int i=3;i>=1;i--) {
					for(int j=0;j<=3;j++) {
						if(board[i][j] != null && board[i-1][j] == null) {
							board[i-1][j]= board[i][j];
							board[i][j]=null;
						}
					}
				}
			}
		}
		public static void sumUp() {
			for (int i=0;i<=2;i++) {
				for(int j=0;j<=3;j++) {
					if(board[i][j] !=null && board[i+1][j] !=null && board[i][j].getName().equals(board[i+1][j].getName()) && board[i][j].getAge()==board[i+1][j].getAge()) {
						board[i][j].sumAge();
						board[i+1][j]=null;
						if ( board[i][j] instanceof Flinston) {
							for(int k=0;k<4;k++) {
								for(int m=0;m<4;m++) {
									if (board[k][m]!=null && board[k][m].getName().equals("M")) {
										board[k][m].sumAge();
										if(board[k][m].getAge() >= maxAge) {
											board [k][m] = board[k][m].evolution();
									}
									}
								}
							}
						}
						if(board[i][j] instanceof Human) {
							((Human) board[i][j]).sumMoney();
							money = money + ((Human) board [i][j]).getMoney();
						}
						if(board[i][j].getAge() >= maxAge) {
							if (!(board[i][j] instanceof Human)) {
								board [i][j] = board[i][j].evolution();
							}
							if (board[i][j] instanceof Human) {
								money =money+ ((Human) board[i][j]).getMoney();
							}
						}
						score = score +board[i][j].getScore();
						if( bestScore <= score ) {
							bestScore = score;
						}
					}
				}
			}
		}
		public static void monkeyRight() {
			for(int k=0;k<=2;k++) {
				for (int i=0;i<=3;i++) {
					for(int j=0;j<=2;j++) {
						if(board[i][j] != null && board[i][j+1] == null) {
							board[i][j+1]= board[i][j];
							board[i][j]=null;
						}
					}
				}
			}
		}
		public static void sumRight() {
			for (int i=0;i<=3;i++) {
				for(int j=3;j>=1;j--) {
					if(board[i][j] !=null && board[i][j-1] !=null &&board[i][j].getName().equals(board[i][j-1].getName()) && board[i][j].getAge()==board[i][j-1].getAge()) {
						board[i][j].sumAge();
						board[i][j-1]=null;
						if ( board[i][j] instanceof Flinston) {
							for(int k=0;k<4;k++) {
								for(int m=0;m<4;m++) {
									if (board[k][m]!=null && board[k][m].getName().equals("M")) {
										board[k][m].sumAge();
										if(board[k][m].getAge() >= maxAge) {
											board [k][m] = board[k][m].evolution();
									}
									}
								}
							}
						}
						if(board[i][j] instanceof Human) {
							((Human) board[i][j]).sumMoney();
							money = money + ((Human) board [i][j]).getMoney();
						}
						if(board[i][j].getAge() >= maxAge ) {
							if (!(board[i][j] instanceof Human)) {
								board [i][j] = board[i][j].evolution();
							}
							if (board[i][j] instanceof Human) {
								money =money+ ((Human) board[i][j]).getMoney();
							}
						}
						score = score +board[i][j].getScore();
						if( bestScore <= score ) {
							bestScore = score;
						}
					}
				}
			}
		}
		public static void monkeyLeft() {
			for(int k=0;k<=2;k++) {
				for (int i=0;i<=3;i++) {
					for(int j=3;j>=1;j--) {
						if(board[i][j] != null && board[i][j-1] == null) {
							board[i][j-1]= board[i][j];
							board[i][j]=null;
						}
					}
				}
			}
		}
		public static void sumLeft() {
			for (int i=0;i<=3;i++) {
				for(int j=0;j<=2;j++) {
					if(board[i][j] != null && board[i][j+1] !=null && board[i][j].getName().equals(board[i][j+1].getName()) && board[i][j].getAge()==board[i][j+1].getAge()) {
						board[i][j].sumAge();
						board[i][j+1]=null;
						if ( board[i][j] instanceof Flinston) {
							for(int k=0;k<4;k++) {
								for(int m=0;m<4;m++) {
									if (board[k][m]!=null && board[k][m].getName().equals("M")) {
										board[k][m].sumAge();
										if(board[k][m].getAge() >= maxAge) {
											board [k][m] = board[k][m].evolution();
										}
									}
								}
							}
						}
						if(board[i][j] instanceof Human) {
							((Human) board[i][j]).sumMoney();
							money = money + ((Human) board [i][j]).getMoney();
						}
						if(board[i][j].getAge() >= maxAge) {
							if (!(board[i][j] instanceof Human)) {
								board [i][j] = board[i][j].evolution();
							}
							if (board[i][j] instanceof Human) {
								money =money+ ((Human) board[i][j]).getMoney();
							}
						}
						score = score +board[i][j].getScore();
						if( bestScore <= score ) {
							bestScore = score;
						}
					}
				}
			}
		}
		public static String userDisplay() { //showing the user options of the game.
			System.out.println("money: " + money);
			System.out.println("score:" + score);
			System.out.println("best score:" + bestScore);
			System.out.println("Press s to move down");
			System.out.println("Press a to move left");
			System.out.println("Press d to move right");
			System.out.println("Press w to move up");
			System.out.println("Press r to return");
			System.out.println("Press e to exit");
			String userInput = sc.next();
			return userInput;
		}
	}
