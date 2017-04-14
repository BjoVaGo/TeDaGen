/**
 * examples for TeDaGenNumber
 */
package examples;

import Components.TeDaGenNumber;
import Components.TeDaGenString;

/**
 * @author Kenny Janssens & Bjorn Vangompel
 *
 */
public class NumberSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Basic stuff
		System.out.println(TeDaGenNumber.getBinary());
		System.out.println(TeDaGenNumber.getRandomInt());
	
		//Loop
		for (int i = 0; i < 10; i++) {
			System.out.println(TeDaGenNumber.getBinary());
		}

	}

}
