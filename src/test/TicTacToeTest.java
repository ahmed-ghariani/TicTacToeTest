package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.TicTacToe;

public class TicTacToeTest {
	
	TicTacToe ticTacToe;


	@Before
	public void setUp() throws Exception {
		 ticTacToe = new TicTacToe();
	}

	 @Test
	    public void whenXOutOfBorderThenRunTimeException(){
	        Exception exception = assertThrows(RuntimeException.class,() -> {
	            ticTacToe.play(5,2);
	        });
	        assertEquals("X is outside of the board",exception.getMessage());
	    }

	    @Test
	    public void whenYOutOfBorderThenRunTimeException(){
	        Exception exception = assertThrows(RuntimeException.class,() -> {
	            ticTacToe.play(1,6);
	        });
	        assertEquals("Y is outside of the board",exception.getMessage());
	    }

	    @Test
	    public void whenCaseNotEmptyThenRunTimeException(){
	        Exception exception = assertThrows(RuntimeException.class,() -> {
	            ticTacToe.play(1,2);
	            ticTacToe.play(1,2);
	        });
	        assertEquals("Box is occupied",exception.getMessage());
	    }

	    @Test
	    public void whenNewGameThenXFirst(){
	        assertEquals('X',ticTacToe.getPlayer());
	    }

	    @Test
	    public void whenSecondPlayerThenO(){
	        ticTacToe.play(1,2);
	        assertEquals('O',ticTacToe.getPlayer());
	    }

	    @Test
	    public void whenGameNotFinishedThenNotFinished(){
	        String gameState = ticTacToe.play(1,1);
	        assertEquals("No Winner",gameState);
	    }
	    
	    @Test
	    public void whenXHorizontalThenTheWinnerIsX(){
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(2,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(3,1));
	        assertEquals("X Wins", ticTacToe.play(1,3));
	    }

	    @Test
	    public void whenXVerticalThenTheWinnerIsX(){
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(2,1));
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("X Wins", ticTacToe.play(3,1));
	    }

	    @Test
	    public void whenOHorizontalThenTheWinnerIsO(){
	        assertEquals("No Winner",ticTacToe.play(2,1));
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(3,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(3,3));
	        assertEquals("O Wins", ticTacToe.play(1,3));
	    }

	    @Test
	    public void whenOVerticalThenTheWinnerIsO(){
	        assertEquals("No Winner",ticTacToe.play(3,3));
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(2,1));
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("O Wins", ticTacToe.play(3,1));
	    }

	    @Test
	    public void whenXFirstDiagonalThenTheWinnerIsX(){
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(2,2));
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("X Wins", ticTacToe.play(3,3));
	    }

	    @Test
	    public void whenOFirstDiagonalThenTheWinnerIsO(){
	        assertEquals("No Winner",ticTacToe.play(3,1));
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(2,2));
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("O Wins", ticTacToe.play(3,3));
	    }

	    @Test
	    public void whenXSecondDiagonalThenTheWinnerIsX(){
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(2,2));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("X Wins", ticTacToe.play(3,1));
	    }

	    @Test
	    public void whenOSecondDiagonalThenTheWinnerIsO(){
	        assertEquals("No Winner",ticTacToe.play(2,1));
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(2,2));
	        assertEquals("No Winner",ticTacToe.play(2,3));
	        assertEquals("O Wins", ticTacToe.play(3,1));
	    }

	    @Test
	    public void whenDrawThenDraw(){
	        assertEquals("No Winner",ticTacToe.play(1,1));
	        assertEquals("No Winner",ticTacToe.play(1,2));
	        assertEquals("No Winner",ticTacToe.play(1,3));
	        assertEquals("No Winner",ticTacToe.play(2,2));
	        assertEquals("No Winner",ticTacToe.play(2,1));
	        assertEquals("No Winner",ticTacToe.play(3,3));
	        assertEquals("No Winner",ticTacToe.play(2,3));
	        assertEquals("No Winner",ticTacToe.play(3,1));
	        assertEquals("Draw",ticTacToe.play(3,2));
	        assertEquals("No Winner",ticTacToe.play(3,1));
	    }

	    @Test
	    public void affichage(){
	        ticTacToe.play(1,2);
	        ticTacToe.play(1,3);
	        ticTacToe.play(2,2);
	        System.out.println(ticTacToe.toString());
	    }

}
