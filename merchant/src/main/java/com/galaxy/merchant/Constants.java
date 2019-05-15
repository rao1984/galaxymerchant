package com.galaxy.merchant;
/**
 * 
 * @author DAMA
 *
 */
public final class Constants {

	//Constants for line validations
	public static final String ERROR = "I have no idea what you are talking about";
	public static final String ASSIGNMENT = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
	public static final String CREDITS = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
	public static final String HOW_MANY = "^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$";
	public static final String HOW_MUCH = "^how much is ((?:\\w+[^0-9] )+)\\?$";
	
	//Constants for line flag validations
	public static final String ERROR_FLAG = "I have no idea what you are talking about";
	public static final String ASSIGNMENT_FLAG = "assignment";
	public static final String CREDITS_FLAG = "credits";
	public static final String HOW_MANY_FLAG = "howmany";
	public static final String HOW_MUCH_FLAG = "howmuch";
	
	public static final String INVALID_INPUT = "Invalid text detected!";
	public static final String NO_FILE= "File not found in specified path";

}
