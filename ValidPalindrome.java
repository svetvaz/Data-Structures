/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*/
import java.util.*;
public class ValidPalindrome
{
	private static boolean isPalindrome(String inputStr)
	{
		//first remove all non alpanumerics and convert to lower case
		inputStr = inputStr.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		for(int i=0,j=inputStr.length()-1;i<inputStr.length()/2;i++,j--)
		{
			char start = inputStr.charAt(i);
			char end = inputStr.charAt(j);
			if(start!=end) return false;
			
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println("Enter the String: ");
		//enter the string
		String inputStr = System.console().readLine();
		String palindrome = isPalindrome(inputStr)?" is a palindrome":" is not a palindrome";
		System.out.println(inputStr+palindrome);
	}
}