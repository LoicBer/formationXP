package fr.excilys.formation.bowliwood;

/**
 * Created by lbertaux on 09/12/16.
 */
public class Player {
    private String name ;
    private int score[][] ;

    public Player(String name) {
        this.name = name;
        this.score = new int[10][2] ;
        this.score[9] = new int[3] ;
    }

    public String getName() {
        return name;
    }

    public int[][] getScore() {
        return score;
    }
}
