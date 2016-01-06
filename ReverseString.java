import java.util.*;
public class ReverseString
{

	private static String reverseStr(String inputStr)
	{
		StringBuilder sb = new StringBuilder();
		//split the string into words and then reverse the array
		String[] words = inputStr.split(" ");
		for(int i=words.length-1;i>=0;i--)
		{
			sb.append(words[i]);
			if(i!=0)sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		//enter the string
		String inputStr = System.console().readLine();
		String reversedStr = reverseStr(inputStr);
		System.out.println(reversedStr);
	}
}