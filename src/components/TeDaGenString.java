/**
 * 
 */
package components;

/**
 * @author Kenny Janssens - Bjorn Vangompel
 *
 */
public class TeDaGenString extends TeDaGenCore {
	public enum Case {u, l}

	/**
	 * This function generates random characters in the ASCII character-encoding scheme originally based on the English alphabet.
	 * Only printable ASCII characters will be returned (no control characters).
	 * This function is best suited to generate salts, authorisation keys, passwords, etc.
	 * Source: Wikipedia: American Standard Code for Information Interchange
	 * 
	 * @return Returns one random ASCII character in the range 32 to 126
	 * 
	 */
	public static char getAscii(){
	    return (char) getRandomInt(32,126);
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @return one random Unicode character in a character format
	 * 
	 */
	public static char getUnicode(){
		
	    return '?';
	}
	
	
	/**
	 * Returns an alphabetical character on success
	 * Note: Only standard Latin characters are returned [a-zA-Z]
	 * 
	 * @return one random alphabetical character in a string format
	 * 
	 */
	public static char getChar(){
		int rnd = getRandomInt(52);
	    char base = (rnd < 26) ? 'A' : 'a';
	    return (char) (base + rnd % 26);
	}
	
	
	/**
	 * Converts a Character to upper case .
	 * 
	 * @param chr The input char that will be converted.
	 * @return the output char in uppercase.
	 */
	public static char upper(char chr) {
		return Character.toUpperCase(chr);
	}
	
	
	/**
	 * Converts a Character to lower case .
	 * 
	 * @param chr The input char that will be converted.
	 * @return the output char in lowercas.
	 */
	public static char lower(char chr) {
		return Character.toLowerCase(chr);
	}
	
	
	/**
	 * Converts a string to lower case characters.
	 * 
	 * @param str The input string that will be converted.
	 * @return the output string in lowercase.
	 */
	public static String upper(String str) {
		return str.toUpperCase();
	}
	
	
	/**
	 * Converts a string to upper case characters.
	 * 
	 * @param str The input string that will be converted.
	 * @return the output string in uppercase.
	 */
	public static String lower(String str) {
		return str.toLowerCase();
	}

	
	/**
	 * Returns a string with the first letter capitalized (in upper case).
	 * 
	 * @param str The string to capitalize (make upper case) the first letter.
	 * @return Returns a string with the first letter as a capital.
	 */
	public static String ucFirst(String str) {
		return str.substring(0, 1 ).toUpperCase().concat(str.substring(1, str.length() ));
	}
	
	
	/**
	 * Returns an alphabetical character on success
	 * Note: Only standard Latin characters are returned [a-zA-Z]
	 * 
	 * @param Case  Determines the case of the character returned. The case can be "u" for uppercase or "l" for lower case. 
	 * 		  		Defaults to "l" This parameter is optional.
	 * @return one random alphabetical character in a string format
	 * 
	 */
	
	public static char getChar( Case Case){
		int rnd = getRandomInt(52); // or use Random or whatever
	    char base = (rnd < 26) ? 'A' : 'a';
	    char outChar = (char) (base + rnd % 26);
	    
	    switch (Case) {
		case l:
			lower(outChar);
			break;
			
		case u:
			upper(outChar);
			break;

		default:
			break;
		}
	    return outChar;
	}
	
	
	/**
	 * Returns one random Latin consonant.
	 * Default is lower case, use the upper() modifier function to return an upper case consonant.
	 * 
	 * @return Returns one random consonant
	 */
	public static char getConsonant() {
		int rnd = getRandomInt(TeDaGenConfig.consonant.length - 1);
		return TeDaGenConfig.consonant [rnd];
	}
	
	
	/**
	 * Returns one random Latin vowel.
	 * Default is lower case, use the upper() modifier function to return an upper case vowel.
	 * 
	 * @return Returns one random vowel
	 */
	public static char getVowel() {
		int rnd = getRandomInt(TeDaGenConfig.vowel.length - 1);
		return TeDaGenConfig.vowel [rnd];
	}
	
	
	/**
	 * returns a string of alphabetical characters with a given lenght
	 * For readability, the string returned will always start with a consonant and will be interspersed with a vowel.
	 * 
	 * @param lenght the lenght of the string
	 * @return a string of alphabetical characters in a string format for the given lenght
	 */
	public static String getString(int lenght) {
		String outString = "";
		for(int iCount = 0; iCount < lenght; iCount = iCount + 1) {
			if((iCount%2)==0){
				outString = outString.concat(String.valueOf(getConsonant()));  // even
			}
			else{
				outString = outString.concat(String.valueOf(getVowel()));   // odd
			}
	         
	      }
		return outString;
	}
	
	
	/**
	 * Returns a string with random alphabetical lower case characters.
	 * For readability, the string returned will always start with a consonant and will be interspersed with a vowel.
	 * 
	 * Note: Only standard Latin characters are returned.
	 * 
	 * @return Returns a string with 2 to 9 random characters
	 */
	public static String getString() {
		int rnd = getRandomInt(2,8); 
		return getString(rnd);
	}	
	

	
	/**
	 * Returns one random Punctuation Mark.
	 * 
	 * @return Returns a  Period , Question mark or exclamation mark
	 */
	public static char getPunctuationMark() {
		int rnd = (int) (Math.random()*TeDaGenConfig.punctuationMark.length); 
		return TeDaGenConfig.punctuationMark [rnd];
	}
		
	
	/**
	 * Generates a number of words that form a sentence, including correct punctuation.
	 * As the words are randomly generated, there are not verbs or subjects as traditionally expected and there are no ideas expressed.
	 * The sentence always ends in a dot, question mark or exclamation point character.
	 * Only standard Latin characters will be returned.
	 * 
	 * @param words The number of words in the sentence
	 * @return a number of words that form a sentence
	 * 
	 */
	public static String getSentence(int words) {
		
		String sentence = ucFirst(getString());
		
		for(int iCount = 1; iCount < words; iCount = iCount + 1) { 
			sentence = sentence.concat(" ".concat(getString()));
		}
		sentence = sentence.concat(String.valueOf(getPunctuationMark())); 
		
		return sentence;
	}
	
		
	
	/**
	 * Generates a sentence with a random number of words in the range minimum to maximum including punctuation.
	 * As the words are randomly generated, there are not verbs or subjects as traditionally expected and there are no ideas expressed.
	 * The sentence always ends in a dot, question mark or exclamation point character.
	 * Only standard Latin characters will be returned.
	 * 
	 * @param minimum The minimum number of words in the sentence
	 * @param maximum The maximum number of words in the sentence
	 * @return Returns a random number of words in the range minimum to maximum including punctuation.
	 * 
	 */
	public static String getSentence(int minimum , int maximum) {
		int rnd = getRandomInt(minimum,maximum); 
		String sentence = getSentence(rnd);
		
		return sentence;
	}
	
	
	/**
	 * Generates a sentence with 3 to 12 words.
	 * As the words are randomly generated, there are not verbs or subjects as traditionally expected and there are no ideas expressed.
	 * The sentence always ends in a dot, question mark or exclamation point character.
	 * Only standard Latin characters will be returned.
	 *
	 * @return Returns a sentence with 3 to 12 words
	 * 
	 */
	public static String getSentence() {
		return getSentence(3,12);
	}
	
	
	/**
	 * Generates a number of sentences with random words that form a paragraph.
	 * Only standard Latin characters will be returned.
	 * With this method, you no longer need to rely on the old Lorem Ipsum text.
	 * 
	 * @param sentences The number of sentences in the paragraph
	 * @return a number of sentences that form a paragraph
	 * 
	 */
	public static String getParagraph(int sentences) {
		
		String paragraph = getSentence();
		
		for(int iCount = 1; iCount < sentences; iCount = iCount + 1) { 
			paragraph = paragraph.concat(" ".concat(getSentence()));
		}
		
		return paragraph;
	}
	
	
	/**
	 * Generates a paragraph with a random number of sentences, in the range minimum to maximum.
	 * Only standard Latin characters will be returned.
	 * With this method, you no longer need to rely on the old Lorem Ipsum text.
	 * 
	 * @param minimum The minimum number of sentences in the paragraph
	 * @param maximum The maximum number of sentences in the paragraph
	 * @return Returns a random number of sentences in the range minimum to maximum.
	 * 
	 */
	public static String getParagraph(int minimum , int maximum) {
		int rnd = getRandomInt(minimum,maximum); 
		String sentence = getParagraph(rnd);
		
		return sentence;
	}
	
	
	/**
	 * Generates a paragraph with 3 to 12 sentences.
	 * Only standard Latin characters will be returned.
	 * With this method, you no longer need to rely on the old Lorem Ipsum text.
	 *
	 * @return Returns a paragraph with 3 to 12 sentences
	 * 
	 */
	public static String getParagraph() {
		return getParagraph(3,12);
	}
	
	
	// TODO check comment code and ut
	/**
	 * replace every character with another character in a string.
	 * 
	 * @param str The input string that will be converted.
	 * @param oldChar the old character that should be replaced
	 * @param newChar the new character
	 * 
	 * @return the converted output string.
	 */
	public static String replace(String str , char oldChar, char newChar) {
		return str.replace(oldChar, newChar);
	}
	 
	
	/**
	 * remove all whitespaces in a string.
	 * 
	 * @param str The input string that will be converted.
	 * @return the output string without whitespaces.
	 */
	public static String strip(String str) {
		return str.replace(" " ,"");
	}
	
	/**
	 * 
	 * 
	 * @param str The input string that will be converted.
	 * @return  returns the trimmed string
	 */
	public static String trim(String str) {
		return str.trim();
	}
	

//	truncate - truncate string length
//	reverse - reverse a string
//	leftpad - Left Padding
//	rightpad - Right Padding

}
