import java.util.*;

public class ContainsDuplicate
{
	private static boolean containsDup(int[] inputArr)
	{
		HashSet<Integer> hSet = new HashSet<Integer>();
		for(int num:inputArr)
		{
			if(!hSet.add(num))
				return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		int[] inputArr = {1,3,4,5,2,7};
		String isDup = containsDup(inputArr)? " contains duplicate":" does not contain duplicate";
		System.out.println("The array"+isDup);
	}
}