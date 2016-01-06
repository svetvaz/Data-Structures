import java.util.*;

//majority ele is one that appears more than n/2 times
public class MajorityElement
{

	public static void main(String[] args)
	{
		//enter the inputArr
		int[] inputArr = {4,7,7,7,3,8,7,7};
		//sort the array
		Arrays.sort(inputArr);
		// once the array is sorted the mid ele will always be the majority ele
		System.out.println(inputArr[inputArr.length/2]);
	}
	
}