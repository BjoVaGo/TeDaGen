/**
 * 
 */
package Components;

/**
 * @author Kenny Janssens & Bjorn Vangompel
 *
 */
public class TeDaGenNumber extends TeDaGenCore {
	
	/**
	 * 
	 * 
	 * 
	 * @return 
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
	
	/**
	 * 
	 * 
	 * 
	 * @return 
	 * 
	 */
	public static Integer getHex(){
		return 0; 
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @return 
	 * 
	 */
	public static Integer getOct(){
		return 0; 
	}
	
	
}
