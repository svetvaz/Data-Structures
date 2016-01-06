import java.util.*;

// Assumption: array is sorted and then rotated
public class MinimumInSortedArray
{

	public static void main(String[] args)
	{
		//enter arr
		int[] inputArr = {4,5,6,7,1,2,3};
		int j=0;
		int lowest = inputArr[0];
		for(int i=1;i<inputArr.length;i++)
		{
			//while iterating thru array check to see if the next element is less than the current
			//that would be the starting point and the least value in the array
			if(inputArr[i]<inputArr[j])
			{
				//value at index i is the smallest
				lowest = inputArr[i];
				break;
			}
		}
		System.out.println(lowest);
	}
}