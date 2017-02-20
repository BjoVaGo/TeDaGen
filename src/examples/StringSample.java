/**
 * examples for TeDaGenString
 */
package examples;

import Components.TeDaGenString;
import Components.TeDaGenString.Case;

/**
 * @author Kenny Janssens & Bjorn Vangompel
 *
 */

public class StringSample {

	public static void main(String[] args) {
		// Basic stuff
		System.out.println(TeDaGenString.getAscii());
		System.out.println(TeDaGenString.getChar(Case.u));
		System.out.println(TeDaGenString.getConsonant());
		System.out.println(TeDaGenString.getVowel());
		
		// Strings
		System.out.println(TeDaGenString.getString());
		System.out.println(TeDaGenString.getString(20));
		System.out.println(TeDaGenString.ucFirst("test"));
		
		
		// sentence
		System.out.println(TeDaGenString.getSentence(5));
		System.out.println(TeDaGenString.getSentence(3,5));
		System.out.println(TeDaGenString.getSentence());
		
		// paragraph
		System.out.println(TeDaGenString.getParagraph(10));
		System.out.println(TeDaGenString.getParagraph(3,5));
		System.out.println(TeDaGenString.getParagraph());
		
		
		//Loop
		for (int i = 0; i < 10; i++) {
			System.out.println(TeDaGenString.getAscii());
		}
	}

}
