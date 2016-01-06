import java.util.*;

public class LongestSubstring
{

	private static int longestSubLen(String inputstr)
	{
		HashSet<Character> hSet = new HashSet<Character>();
		int longestLen = 0;
		int len = 0;
		for(int i=0;i<inputstr.length();i++)
		{
			char st = inputstr.charAt(i);
			if(!hSet.add(st))
			{
				// duplicate encountered
				//save the length and reset length
				if(len>longestLen)
				{
					longestLen = len;
					len=0;
				}
			}
			else
			{
				len++;
			}
		}
		return longestLen;
	}
	public static void main(String[] args)
	{
		//enter string
		String inputstr = "bbbbb";
		System.out.println(longestSubLen(inputstr));
	}
}