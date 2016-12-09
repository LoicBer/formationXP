package fr.excilys.formation.bowliwood;

import java.io.IOException;

import fr.excilys.formation.bowliwood.util.InputHelper;
import fr.excilys.formation.bowliwood.util.OutPutHelper;

/**
 * Created by lbertaux on 09/12/16.
 */
public class Game {
    private Player players[] ;

    public void init() {
        int nbPlayer = InputHelper.nbPlayerInput();
        System.out.println("Le nombre de joueurs est : " + nbPlayer);
        
        players = InputHelper.namePlayersInput(nbPlayer) ;
        System.out.print("Les joueurs sont ");
        for (int i = 0 ; i < nbPlayer ; i++) {
        	System.out.print(players[i].getName() + " ") ;
        }
        
    }

    public static void main(String[] args) {
        Game g = new Game() ;
        g.init();      
    }

}
