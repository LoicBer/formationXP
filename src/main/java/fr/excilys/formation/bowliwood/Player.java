package fr.excilys.formation.bowliwood;

/**
 * Created by lbertaux on 09/12/16.
 */
public class Player {
    private String name ;
    private int score[][] ;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[][] getScore() {
        return score;
    }
}
