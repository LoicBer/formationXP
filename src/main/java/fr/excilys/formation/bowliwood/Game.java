package fr.excilys.formation.bowliwood;

import fr.excilys.formation.bowliwood.util.InputHelper;

/**
 * Created by lbertaux on 09/12/16.
 */
public class Game {
    private Player players[] ;

    public void init() {
        int nbPlayer = InputHelper.nbPlayerInput();
        System.out.println(nbPlayer);
    }

    public static void main(String[] args) {
        Game g = new Game() ;
        g.init();
    }

}
