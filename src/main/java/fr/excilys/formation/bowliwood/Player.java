package fr.excilys.formation.bowliwood;

/**
 * Created by lbertaux on 09/12/16.
 */
public class Player {
    private String name ;
    private int score[][] ;
    private int scoreTotal ;

    public Player(String name) {
        this.name = name;
        this.score = new int[10][2] ;
        this.score[9] = new int[3] ;
        this.scoreTotal = 0 ;
    }

    public String getName() {
        return name;
    }

    public int[][] getScore() {
        return score;
    }
    
    public int getScoreThrow(int idRound, int idThrow) {
        return this.score[idRound][idThrow] ;
    }
    
    public int getScoreTotal() {
        return scoreTotal;
    }
    
    public void setScore(int idRound, int idThrow, int score) {
        this.score[idRound][idThrow] = score ;
        this.scoreTotal += score ;
    }
}
