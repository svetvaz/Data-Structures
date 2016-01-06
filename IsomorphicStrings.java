import java.util.*;

public class IsomorphicStrings
{

	private static boolean areIsomorphic(String str1,String str2)
	{
		if(str1.length()!=str2.length()) return false;
		HashMap<Character,Character> charMap = new HashMap<Character,Character>();
		for(int i=0;i<str1.length();i++)
		{
			//check if the character already exists in the hashmap keys
			if(charMap.containsKey(str1.charAt(i)))
			{
				//now check if the value assigned to the key is correct
				if(charMap.get(str1.charAt(i))==str2.charAt(i))
					continue;
				else
					return false;
			}
			else if(charMap.containsKey(str2.charAt(i)))
			{
				//check if the character in str2 is already a key in the hashmap
				
				{
					//check if its assigned to the correct value
					if(charMap.get(str2.charAt(i))==str1.charAt(i))
						continue;
					else
						return false;
				}
				
			}
			else
			{
				charMap.put(str1.charAt(i),str2.charAt(i));
			}
				
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println("Enter String 1:");
		String str1 = System.console().readLine();
		System.out.println("Enter String 2:");
		String str2 = System.console().readLine();
		String result = areIsomorphic(str1,str2)?"Isomorphic":"not Isomorphic";
		System.out.println("The 2 strings "+str1+" and "+str2+" are "+result);
	}
}