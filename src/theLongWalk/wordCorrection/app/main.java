/**
 * 
 */
package theLongWalk.wordCorrection.app;

import java.io.IOException;
import java.util.Scanner;

import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;
/**
 * @author ibrahim
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean condition = true;
		String input = "";
		try {
			TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
			TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);
			do {
				System.out.println("Enter wrongly typed word: ");
				input = scanner.nextLine();
				if(input.equalsIgnoreCase("exit")) {
					condition = false;
					break;
				}
				if(!spellChecker.check(input))
					System.out.println(input + " = " + spellChecker.suggestForWord(input));
			} while (condition);
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
