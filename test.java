
public class test {

	/**
	 * @param args
	 */
	 int[] winnersCount = {0,0,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test add method
		System.out.println("COMPUTING ALL POSSIBLE GAMES...");
		
		test test1 = new test();
		Game game1 = new Game( 1,1);
		game1.newGame();
		int cg1 = test1.countGames(game1);
		System.out.println("Possible Games with a board length of " +game1.size+ " needing " + game1.needtoconnect + " : "+ cg1);
		System.out.println("Won by player 1: " + test1.winnersCount[1]);
		System.out.println("Won by player 2: " + test1.winnersCount[2]);
		
		System.out.println();

		test test21 = new test();
		Game game21 = new Game(2,1);
		game21.newGame();
		int cg21 = test21.countGames(game21);
		System.out.println("Possible Games with a board length of " +game21.size+ " needing " + game21.needtoconnect + " : "+ cg21);
		System.out.println("Won by player 1: " + test21.winnersCount[1]);
		System.out.println("Won by player 2: " + test21.winnersCount[2]);
		System.out.println();

		test test22 = new test();
		Game game22 = new Game( 2,2);
		game22.newGame();
		int cg22 = test22.countGames(game22);
		System.out.println("Possible Games with a board length of " +game22.size+ " needing " + game22.needtoconnect + " : "+ cg22);
		System.out.println("Won by player 1: " + test22.winnersCount[1]);
		System.out.println("Won by player 2: " + test22.winnersCount[2]);
		System.out.println();

		test test3 = new test();
		Game game3 = new Game( 3,3);
		game3.newGame();
		int cg3 = test3.countGames(game3);
		System.out.println("Possible Games with a board length of " +game3.size+ " needing " + game3.needtoconnect + " : "+ cg3);
		System.out.println("Won by player 1: " + test3.winnersCount[1]);
		System.out.println("Won by player 2: " + test3.winnersCount[2]);

		test test4 = new test();
		Game game4 = new Game(4,3);
		game4.newGame();
		int cg4 = test4.countGames(game4);
		System.out.println();
		System.out.println("Possible Games with a board length of " +game4.size+ " needing " + game4.needtoconnect + " : " + cg4);
		System.out.println("Won by player 1: " + test4.winnersCount[1]);
		System.out.println("Won by player 2: " + test4.winnersCount[2]);
		System.out.println();

		Game game54 = new Game(5,4);
		game54.newGame();	
		test test54 = new test();
		int cg54 = test54.countGames(game54);
		System.out.println("Possible Games with a board length of " +game54.size+ " needing " + game54.needtoconnect + " : " + cg54);
		System.out.println("Won by player 1: " + test54.winnersCount[1]);
		System.out.println("Won by player 2: " + test54.winnersCount[2]);
		System.out.println();

		Game game53 = new Game(5,3);
		game53.newGame();	
		test test53 = new test();
		int cg53 = test53.countGames(game53);
		System.out.println("Possible Games with a board length of " +game53.size+ " needing " + game53.needtoconnect + " : " + cg53);
		System.out.println("Won by player 1: " + test53.winnersCount[1]);
		System.out.println("Won by player 2: " + test53.winnersCount[2]);

		System.out.println();

		Game game6 = new Game(6,3);
		game6.newGame();
	
		test test6 = new test();
		int cg6 = test6.countGames(game6);
		System.out.println("Possible Games with a board length of " +game6.size+ " needing " + game6.needtoconnect + " : " + cg6);
		System.out.println("Won by player 1: " + test6.winnersCount[1]);
		System.out.println("Won by player 2: " + test6.winnersCount[2]);
		System.out.println();

		Game game64 = new Game(6,4);
		test test64 = new test();
		int cg64 = test64.countGames(game64);
		System.out.println("Possible Games with a board length of " +game64.size+ " needing " + game64.needtoconnect + " : " + cg64);
		System.out.println("Won by player 1: " + test64.winnersCount[1]);
		System.out.println("Won by player 2: " + test64.winnersCount[2]);

		/*test.add(0);
		test.board[1][1] = 1;
		test.board[3][3] = 1;
		test.board[2][0] = 1;
		//test.board[0][3] = 1;
		test.add(2);
		test.add(2);
		//test.add(0);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(3);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(0);
		test.add(2);
		test.add(2);
		test.add(2);
		test.add(2);
		test.add(6);
		test.add(6);
		test.add(7);
		test.add(3);
		test.add(3);
		test.add(4);
		test.printGame();*/
		
		
		
	}
	public  void resetWinners(){
		winnersCount[1] = 0;
		winnersCount[2] = 0;
	}
	public  int countGames(Game g){
		Game[] games = new Game[g.size];
		int result = 0;

		for(int i = 0; i<g.size; i++){
			games[i] = new Game(g.size, g.needtoconnect);
			for(int x = 0; x < g.size; x++){
				for(int y = 0; y < g.size; y++){
					games[i].board[x][y] = g.board[x][y];
				}
			}
			games[i].turn = g.turn;
			result += countGames(games[i], i);
			}
		
		return result;
				/*countGames(games[0], 0) + countGames(games[1], 1) 
				+ countGames(games[2], 2) + countGames(games[3], 3) 
				+ countGames(games[4], 4) + countGames(games[5], 5) 
				+ countGames(games[6], 6);	*/
	}
	
	public int countGames(Game g, int x){
		//if WINNER return 1, if BADMOVE return 0, else countGames of size positions
		int move = g.add(x);
		if(move == g.BADMOVE){
			//System.out.println("BadMove");
			//winnersCount[0] += 1;
			return 0;
		}	
		//g.printGame();

		 if(move == -g.turn){
			//System.out.println("Winner");
			this.winnersCount[g.turn] += 1;
			return 1;
		}
		//System.out.println("No winner, no bad move");
		Game[] games = new Game[g.size];
		int result =0;
		for(int i = 0; i<g.size; i++){
			games[i] = new Game(g.size, g.needtoconnect);
			for(int x1 = 0; x1 < g.size; x1++){
				for(int y = 0; y<g.size; y++){
					games[i].board[x1][y] = g.board[x1][y];
				}
			}			
			games[i].turn = g.turn;
			result += countGames(games[i], i);

		}
		return result; /*countGames(games[0], 0) + countGames(games[1], 1) 
				+ countGames(games[2], 2) ; + countGames(games[3], 3) 
				+ countGames(games[4], 4) + countGames(games[5], 5) 
				+ countGames(games[6], 6);*/		
	}

}
