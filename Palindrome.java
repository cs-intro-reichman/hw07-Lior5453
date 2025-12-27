/** Checks if a given string is a palindrome. */
public class Palindrome 
{
	public static void main(String[]args) 
	{
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) 
	{
		if (s.length() <= 1) // if cuccrent length is 1 or lower return true (all checked or string is automaticly a palindrome if length 0/1)
			return true;

		if (s.charAt(0) != s.charAt(s.length() - 1)) // if letters are different in corners return false
			return false;

		return isPalindrome(s.substring(1, s.length() - 1)); // removing both corners and moving on to keep checking
    }
}