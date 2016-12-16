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

}
