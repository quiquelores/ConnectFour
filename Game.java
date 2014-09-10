
public class Game {
	
	boolean verbose = false;
	
	//CONSTANTS
	final static int WINNER = -100;
	final static int NOWINNER = -99;
	final static int BADMOVE = -98;
	
	final static int EMPTY = 0;
	final static int PLAYERONE = 1;
	final static int PLAYERTWO = 2;
	
	final static int[] directionsX = {0, 1, 1, 1};
	final static int[] directionsY = {1, 1, 0, -1};
	//class variables
	int size;
	int needtoconnect;
	int turn = PLAYERONE;
	int[][] board; 
	public Game(){
		this.size = 5;
		this.needtoconnect = 3;
		this.board = new int[this.size][this.size];
		newGame();
	}
	
	public Game(int size, int needtoconnect){
		this.size = size;
		this.needtoconnect = needtoconnect;
		this.board = new int[this.size][this.size];
		newGame();
	}
	
	
	public void newGame(){
		for(int i = 0; i<this.size;i++){
			for(int j=0; j<this.size;j++){
				this.board[i][j] = EMPTY;
			}
		}
	}
	public void changeTurn(){
		if(verbose){
			System.out.println("Turn changed.");
		}
		turn = turn%2 + 1;
	}
	
	public int checkWinner(int posX, int posY){
		if(posX < 0 || posX >= this.size || posY < 0 || posY >= this.size){
			return -1;
		}
		int player = this.board[posX][posY];
			for(int i = 0; i< 4; i++){
				
				int cwr = checkWinnerRecurs(posX, posY, player, 0, directionsX[i], directionsY[i]) + 1 + checkWinnerRecurs(posX, posY, player, 0, -directionsX[i], -directionsY[i]);
			if(checkWinnerRecurs(posX, posY, player, 0, directionsX[i], directionsY[i]) + 1 + checkWinnerRecurs(posX, posY, player, 0, -directionsX[i], -directionsY[i]) >= this.needtoconnect){
				return -player;
			}
			if(verbose){
			System.out.println("CWR: " + cwr );
			}

		}
		return NOWINNER;
	}
	public int checkWinnerRecurs(int posX, int posY, int player, int count, int dirX, int dirY){
		if(posX + dirX < 0 || posX + dirX >= size || posY + dirY < 0 || posY + dirY >= size){
			if(verbose){
				System.out.println("CheckWinnerRecurs: Reached side of board. Count = "+ count + ". Position = (" + posX + ", " + posY 
						+ "). Direction = (" + dirX + ", " + dirY + ").");
			}
			return count;
		}
		if(board[posX+dirX][posY+dirY]==player){
			return checkWinnerRecurs(posX+dirX, posY+dirY, player, count +1, dirX, dirY);
		}
		return count;
	}

	public int add(int x){
		if(x>=size){
			if(verbose){
				System.out.println("Attempted adding to a nonexisting column");
			}
			return BADMOVE;
		}
		int y = 0;
		while( y< this.size && this.board[x][y]!= EMPTY){
			y++;
		}
		if(y==size){
			if(verbose){
				System.out.println("Attempted adding to a full column");
			}
			return BADMOVE;
		}
		board[x][y] = turn;
		if(checkWinner(x,y) == -turn){
			//System.out.println("WINNER");
			return -turn;
		}
		this.changeTurn();
		return y;
	}
	
	public void printGame(){
		for(int i = board.length-1; i>=0; i--){
			for(int j = 0; j<board.length; j++){
				System.out.print("[" + board[j][i] + "]");
			}
			System.out.println();
		}
		System.out.println("Turn: " + turn);
	}	
}

