package fr.excilys.formation.bowliwood.util;

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Scanner;

import fr.excilys.formation.bowliwood.Player;

import static java.lang.Integer.parseInt;


public final class InputHelper {

    private InputHelper() {}

    public static int nbPlayerInput(Scanner sc) {
        @SuppressWarnings("resource")
        boolean done = false;
        int in = 0;
        System.out.println("Entrer le nombre de joueurs");
        do {
            try {
                in = parseInt(sc.nextLine()) ;
                if (in < 0) {
                    throw new NumberFormatException() ;
                }
                done = true;
            } catch (NumberFormatException e) {

            }
            if (!done) {
                System.err.println("Entrer un nombre de joueurs valide");
            }

        } while (!done && sc.hasNextLine());

        return in;
    }
    
    public static Player[] namePlayersInput(int nbPlayer, Scanner sc) {
    	Player[] names =  new Player[nbPlayer] ;
    	for (int i = 0 ; i < nbPlayer ; i++) {
    		System.out.println("Entrer le nom du joueur " + (i+1) ) ;
    		names[i] = new Player(sc.nextLine()) ;
    	}
    	return names ;
    }
    
    public static int scoreInput(Scanner sc) {
    	boolean done = false ;
    	int in = 0 ;
    	System.out.println("Entrer le score");
        do {
            try {
                in = parseInt(sc.nextLine()) ;
                if (in < 0 || in > 10) {
                    throw new NumberFormatException() ;
                }
                done = true;
            } catch (NumberFormatException e) {

            }
            if (!done) {
                System.err.println("Entrer un score entre 0 et 10");
            }

        } while (!done && sc.hasNextLine());
        return in ;
    }
    
}