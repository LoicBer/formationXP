package fr.excilys.formation.bowliwood;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void testInit() {
		Game g = new Game() ;
		ByteArrayInputStream in = new ByteArrayInputStream("3\nj1\nj2\nj3\n".getBytes()) ;
		System.setIn(in);
		Scanner sc = new Scanner(System.in) ;
		g.init(sc);
		//check number of players
		assertEquals(g.getPlayers().length,3) ;
		//check names of players
		assertEquals(g.getPlayers()[0].getName(),"j1") ;
		assertEquals(g.getPlayers()[1].getName(),"j2") ;
		assertEquals(g.getPlayers()[2].getName(),"j3") ;
		
		sc.close() ;
	}
	
	@Test
	/* Here, the user enters illegal arguments for the number of users
	 * When the user enters a string or a negative number, the game should ask
	 * refuse the value and ask again for a legal value
	 */
	public void testInitWithIllegalInput() {
		Game g = new Game() ;
		//the user enters a string instead of a number, then a negative number and then a correct number of players
		ByteArrayInputStream in = new ByteArrayInputStream("trois\n-1\n3\nj1\nj2\nj3\n".getBytes()) ;
		System.setIn(in);
		Scanner sc = new Scanner(System.in) ;
		g.init(sc);
		//check number of players
		assertEquals(g.getPlayers().length,3) ;
		//check names of players
		assertEquals(g.getPlayers()[0].getName(),"j1") ;
		assertEquals(g.getPlayers()[1].getName(),"j2") ;
		assertEquals(g.getPlayers()[2].getName(),"j3") ;
		sc.close() ;
	}
	
	
	@Test
	public void doRoundTest() {
		Game g = new Game() ;
		//set game to round 0, j2's turn, 2 players
		g.setGame(0, 1, "j1", "j2");
		// simulate j2 does 3 and 2 for the current turn
		ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n".getBytes()) ;
		System.setIn(in);
		Scanner sc = new Scanner(System.in) ;
		//round of sc ;
		g.doRound(sc) ;
		//total score after round 1 should be 5
		assertEquals(g.getPlayers()[1].getScoreTotal(),5) ;
		//first throw of round 1 should be 3
		assertEquals(g.getPlayers()[1].getScore()[0][0],3) ;
		//second throw of round 1 should be 2
		assertEquals(g.getPlayers()[1].getScore()[0][1],2) ;
		sc.close() ;
	}
	
	@Test
	public void doRoundStrike() {
		Game g = new Game() ;
		g.setGame(0, 1, "j1", "j2");
		// simulate j2 does a strike
		ByteArrayInputStream in = new ByteArrayInputStream("10\n".getBytes()) ;
		System.setIn(in);
		Scanner sc = new Scanner(System.in) ;
		g.doRound(sc);
		assertEquals(g.getPlayers()[1].getScoreTotal(),10) ;
		assertEquals(g.getPlayers()[1].getScore()[0][0],10) ;
		assertEquals(g.getPlayers()[1].getScore()[0][1],0) ;
		
		sc.close();
	}
	
	

}
