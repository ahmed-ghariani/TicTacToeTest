package main;

public class TicTacToe {
	 char[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
	    char player = 'X';
	    int moves = 0 ;
	    public String play(int x, int y){
	       checkAxis(x,'X');
	       checkAxis(y,'Y');
	       makeMove(x,y);
	       return checkGameState();

	    }

	    public char getPlayer() {
	        return player;
	    }
	    public void checkAxis(int i,char axis){
	        if(i<1 || i>3)
	            throw new RuntimeException(axis+" is outside of the board");
	    }

	    public void makeMove(int x, int y) {
	        if(board[x-1][y-1] != '\0')
	            throw new RuntimeException("Box is occupied");
	        board[x-1][y-1] = player;
	        moves++;
	        if(player == 'X')
	            player = 'O';
	        else
	            player = 'X';
	    }
	    public String checkGameState(){
	        char result = checkHorizontalWin();
	        if(result != '\0'){
	            player = '\0';
	            return result+" Wins";
	        }
	        result = checkVerticalWin();
	        if(result != '\0'){
	            player = '\0';
	            return result+" Wins";
	        }
	        result = checkFirstDiagonalWin();
	        if(result != '\0'){
	            player = '\0';
	            return result+" Wins";
	        }
	        result = checkSecondDiagonalWin();
	        if(result != '\0'){
	            player = '\0';
	            return result+" Wins";
	        }
	        if(moves == 9){
	            moves = 0;
	            board = new char[][]{{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
	            player= 'X';
	            return "Draw";
	        }
	        return "No Winner";
	    }

	    public char checkHorizontalWin(){
	        for (int i = 0; i < 3; i++) {
	            if(board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]!='\0')
	                return board[i][0];
	        }
	        return '\0';
	    }

	    public char checkVerticalWin(){
	        for (int j = 0; j < 3; j++) {
	            if(board[0][j]==board[1][j] && board[0][j]==board[2][j] && board[0][j]!='\0')
	                return board[0][j];
	        }
	        return '\0';
	    }

	    public char checkFirstDiagonalWin(){
	        if(board[0][0]==board[1][1] && board[0][0]==board[2][2])
	            return board[0][0];
	        return '\0';
	    }

	    public char checkSecondDiagonalWin(){
	        if(board[0][2]==board[1][1] && board[0][2]==board[2][0])
	            return board[0][2];
	        return '\0';
	    }

	    @Override
	    public String toString() {
	        String affiche ="";
	        for (int i = 0; i < 3; i++) {
	           affiche += board[i][0]+" | "+board[i][1]+" | "+board[i][2]+"\n";
	           if(i<2)
	               affiche += "--|---|--\n";
	        }
	        return affiche;
	    }
}
