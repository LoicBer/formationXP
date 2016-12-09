package fr.excilys.formation.bowliwood.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutPutHelper {
	
	private static final String pathToRules = new String("src/main/res/rules.txt") ;
	
	public static void showRules() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(pathToRules))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			}
	}

}
