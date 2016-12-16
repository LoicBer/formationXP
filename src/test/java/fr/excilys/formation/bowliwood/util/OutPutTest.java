package fr.excilys.formation.bowliwood.util;

import java.io.IOException;

import org.junit.Test;

import fr.excilys.formation.bowliwood.util.OutPutHelper;

public class OutPutTest {
	@Test
	public void showRulesTest() {
		try {
			OutPutHelper.showRules();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
