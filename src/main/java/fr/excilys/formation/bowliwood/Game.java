package fr.excilys.formation.bowliwood;

import java.io.IOException;
import java.util.Scanner;

import fr.excilys.formation.bowliwood.util.InputHelper;
import fr.excilys.formation.bowliwood.util.OutPutHelper;

/**
 * Created by lbertaux on 09/12/16.
 */
public class Game {
    private Player players[] ;
    private int idCurrentPlayer ;
    
    private static final int NB_ROUNDS = 10;
    private int currentRound ;
    
    public Player[] getPlayers() {
    	return players ;
    }

    public void init(Scanner sc) {
        int nbPlayer = InputHelper.nbPlayerInput(sc);
        System.out.println("Le nombre de joueurs est : " + nbPlayer);
        
        players = InputHelper.namePlayersInput(nbPlayer,sc) ;
        System.out.print("Les joueurs sont ");
        for (int i = 0 ; i < nbPlayer ; i++) {
        	System.out.print(players[i].getName() + " ") ;
        }
    }
    
    public void run() {
    	if (players.length == 0) {
    		System.out.println("Le jeu doit etre initialise avant d'etre lance.") ;
    		return ;
    	}
    	
    	for (currentRound=0 ; currentRound<NB_ROUNDS ; currentRound++) {
    		for (idCurrentPlayer=0 ; idCurrentPlayer<players.length ; idCurrentPlayer++) {
    			OutPutHelper.clearOutput() ;
        		displayScore() ;
        		try {
					Thread.sleep(500) ;
				} catch (InterruptedException e) {
					// TODO 3Auto-generated catch block
					e.printStackTrace();
				}
        	}
    	}
    }
    
    
    private void displayScore() {
    	System.out.println("---------------------------------------------------") ;
    	System.out.println("Tour: " + (currentRound + 1)) ;
    	for (int p=0 ; p<players.length ; p++) {
    		System.out.println((p == idCurrentPlayer ? "* ":"  ") + players[p].getName()) ;
    	}
    	System.out.println("---------------------------------------------------") ;
    	System.out.println("") ;
    }
    
    

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in) ;
        Game g = new Game() ;
        g.init(sc);
        g.run() ;
        sc.close() ;
    }

}
