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
    
    public void setGame(int currentRound, int idCurrentPlayer, String ...playerNames ) {
    	this.currentRound = currentRound ;
    	this.idCurrentPlayer = idCurrentPlayer ;
    	players = new Player[playerNames.length] ;
    	for (int i = 0 ; i < players.length ; i++) {
    		players[i] = new Player(playerNames[i]) ;
    	}
    	//TODO set initial scores
    }
    
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
        System.out.print("\n");
    }
    
    public void run(Scanner sc) {
    	if (players.length == 0) {
    		System.out.println("Le jeu doit etre initialise avant d'etre lance.") ;
    		return ;
    	}
    	
    	for (currentRound=0 ; currentRound<NB_ROUNDS ; currentRound++) {
    		for (idCurrentPlayer=0 ; idCurrentPlayer<players.length ; idCurrentPlayer++) {
    			OutPutHelper.clearOutput() ;
        		displayScore() ;
        		doRound(sc);
        	}
    	}
    }
    
    public void doRound(Scanner sc) {
    	int maxRoundThrow = currentRound != 9 ? 2 : 3 ;
    	boolean keepThrowing = true ;
    	int idThrow = 0 ;
    	int scoreRound = 0 ;
    	int scoreThrow ;
    	
    	while (keepThrowing) {
    		do {
    			scoreThrow = InputHelper.scoreInput(sc) ;
    			if (scoreThrow + scoreRound > 10) {
    				System.out.println("Score invalide: la somme des lancers dépasse le nombre total de quilles.");
    			}
    		} while (scoreThrow + scoreRound > 10) ;
    		
    		players[idCurrentPlayer].setScore(currentRound, idThrow, scoreThrow) ;
    		scoreRound += scoreThrow ;
    		
    		if (scoreRound == 10) {
    			keepThrowing = false ;
    		} else {
    			idThrow++ ;
        		if (idThrow >= maxRoundThrow) {
        			keepThrowing = false ;
        		}
    		}
    	}
    }
    
    private void displayScore() {
    	int maxThrowRound = currentRound != 9 ? 2 : 3 ;
    	System.out.println("---------------------------------------------------") ;
    	System.out.println("Tour: " + (currentRound + 1)) ;
    	for (int p=0 ; p<players.length ; p++) {
    		String line = p == idCurrentPlayer ? "* ":"  " ;
    		line += players[p].getName() + "(" + players[p].getScoreTotal() + ")" ;
    		for (int idRound = 0 ; idRound <= currentRound ; idRound++) {
    			line += "\t";
    			for (int idThrow = 0 ; idThrow < maxThrowRound ; idThrow++) {
    				line += players[p].getScoreThrow(idRound, idThrow) != 10 ? players[p].getScoreThrow(idRound, idThrow) : "X" ;
    				line += " " ;
    			}
    		}
    		
    		System.out.println(line) ;
    	}
    	System.out.println("---------------------------------------------------") ;
    	System.out.println("") ;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in) ;
        Game g = new Game() ;
        g.init(sc);
        g.run(sc) ;
        sc.close() ;
    }

}
