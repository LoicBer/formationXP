package fr.excilys.formation.bowliwood.util;

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public final class InputHelper {

    private InputHelper() {}

    public static int nbPlayerInput() {
        @SuppressWarnings("resource")
        Scanner sin = new Scanner(System.in);
        boolean done = false;
        int in = 0;
        System.out.println("Entrer le nombre de joueurs");
        do {
            try {
                in = parseInt(sin.nextLine()) ;
                if (in < 0) {
                    throw new NumberFormatException() ;
                }
                done = true;
            } catch (NumberFormatException e) {

            }
            if (!done) {
                System.err.println("Entrer un nombre de joueurs valide");
            }

        } while (!done && sin.hasNextLine());

        return in;
    }
}