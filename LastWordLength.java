public class LastWordLength
{

	private static int findLengthOfLast(String inputStr)
	{
		int lenOfStr  = inputStr.length();
		if(lenOfStr==0) return 0;
		int j = lenOfStr-1;
		int count = 0;
		if(inputStr.charAt(j) == ' ') return 0;
		while(j>0)
		{
			char val = inputStr.charAt(j);
			
			if((val>='a' && val<='z') ||(val>='A' && val<='Z'))
			{
				count++;
			}
			else
			{
				return count;
			}
			j--;

		}
		return count;
	}

	public static void main(String[] args)
	{
		//enter the String
		System.out.println("Enter the String: ");
		String inputStr = System.console().readLine();
		System.out.println("Computing length");
		int lengthOfLast = findLengthOfLast(inputStr);
		System.out.println("Length of the last word is: "+lengthOfLast);
	}
}