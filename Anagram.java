//2 strings are anagrams if they contain the same characters
public class Anagram
{
	private static isStrAnagram(String str1,String str2)
	{
		//lets use a HashMap
		HashMap<Character,Integer> myCharMap = new HashMap<Character,Integer>();
		for(int i=0;i<str1.length;i++)
		{
			char theChar = str1.charAt(i);

			if(!myCharMap.isEmpty() && myCharMap.containsKey(theChar))
			{
				int charCount = myCharMap.get(theChar);
				myCharMap.put(theChar,++charCount);
			}
			else
			{
				myCharMap.put(theChar,1);
			}
		}
		//now iterate through str2
		for(int i=0;i<str2.length;i++)
		{
			char otherChar = str2.charAt(i);
			if(!myCharMap.isEmpty() && !myCharMap.containsKey(otherChar))
				return false;
			else
			{
				if()
			}

		}
		return true;
			
	}

	public static void main(String[] args)
	{
		//enter 2 strings
		System.out.println("Enter String 1:");
		String str1 = System.console().readLine();
		System.out.println("Enter String 2:");
		String str2 = System.console().readLine();
		boolean isAnagram = isStrAnagram(str1,str2);
	}
}