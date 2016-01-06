import java.util.*;

//Given a sorted array of integers and a target integer, find the insert position of the target in the array. 
//If it already exists return its position
public class SearchInsertPosition
{

	private static int binarySearch(int[] inputArr, int low, int high,int target)
	{

		int mid = (low+high)/2;
		if(inputArr[mid]==target) return mid;
		if(target<inputArr[mid])
		{
			if(low<mid)
				return binarySearch(inputArr,low, mid-1,target);
			else return low;
		}
		else
		{
			if(high>mid)
				return binarySearch(inputArr,mid+1, high,target);
			else
				return high+1;
		}

	}

	private static int findInsertPosition(int[] inputArr,int target)
	{
		//we can use binary search
		int low = 0;
		int high = inputArr.length-1;
		int result = binarySearch(inputArr,low,high,target);
		return result;
		
	}
	public static void main(String[] args)
	{
		//enter the input array
		int[] inputArr = {1,3,5,6};
		System.out.println("Enter the element to be inserted/searched:");
		int target = Integer.parseInt(System.console().readLine());
		int insertPosition = findInsertPosition(inputArr,target);
		System.out.println("Insert position for the element "+target+" is "+insertPosition);
	}
}