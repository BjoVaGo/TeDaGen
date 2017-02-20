/**
 * 
 */
package Components;

/**
 * @author Kenny Janssens & Bjorn Vangompel
 *
 */
public class TeDaGenCore {
	
	/**
	 * Returns a random integer 
	 *
	 * @return a random integer.
	 * @see java.lang.Math#random()
	 */
	protected static Integer getRandomInt(){
		return (int) (Math.random());  // or use Random or whatever
	}
	
	/**
	 * Returns a random number between 0 and max, inclusive.
	 * The difference between 0 and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between 0 and max, inclusive.
	 * @see java.lang.Math#random()
	 */
	protected static Integer getRandomInt( int max){
		return (int) (Math.random() * (max+ 1));  // or use Random or whatever
	}
	
	/**
	 * Returns a random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.lang.Math#random()
	 */
	protected static int getRandomInt(int min, int max) {
	    return (int)(Math.random() * (max - min) + min);
	}
}
