import java.util.HashSet;
public class HappyNumber
{

	private static boolean isHappy(int num)
	{
		HashSet<Integer> happySet = new HashSet<Integer>();
		while(true)
		{
			if(happySet.contains(num)) return false;
			happySet.add(num);
			String numStr = Integer.toString(num);
			int sumOfSquares = 0;
			for(int i=0;i<numStr.length();i++)
			{
				sumOfSquares+=(numStr.charAt(i)-'0')*(numStr.charAt(i)-'0');
			}
			System.out.println(sumOfSquares);
			num = sumOfSquares;
			if(num==1) return true;
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Enter the number:");
		int number = Integer.parseInt(System.console().readLine());
		String isHappy = isHappy(number)?"is a happy number":"is not a happy number";
		System.out.println(number+" "+isHappy);
	}
}