package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
	    String gameState = "No Winner";
	    Scanner s = new Scanner(System.in);
	    while(gameState.equals("No Winner") || gameState.equals("Draw")){
	    	System.out.println(game);
	    	System.out.println("current player: "+game.getPlayer()+"\nmake a move");
	    	System.out.print("x: ");
	    	int x = Integer.parseInt(s.nextLine());
	    	System.out.print("y: ");
	    	int y = Integer.parseInt(s.nextLine());
	        try{
	        	gameState = game.play(x,y);
	            if(gameState.equals("Draw"))
	            	System.out.println(game);
	            	System.out.println(gameState);
	        }catch (RuntimeException e){
	        	System.out.println(e.getMessage());
	        }
	    }
	    System.out.println(game);
	    System.out.println(gameState);
	    s.close();
	}

}
