/**
 * 
 */
package components;

/**
 * @author Kenny Janssens - Bjorn Vangompel
 *
 */
public class TeDaGenNumber extends TeDaGenCore {
	
	/**
	 * 
	 * 
	 * 
	 * @return  the random binary number
	 * 
	 */
	public static Integer getBinary(){
		return getRandomInt(1); // or use Random or whatever
	}
	
	/**
	 * Returns a random integer 
	 *
	 * @return a random integer.
	 * @see java.lang.Math#random()
	 */
	public static Integer getRandomInt(){
		return TeDaGenCore.getRandomInt();  // or use Random or whatever
	}

	
	
}
