import java.util.*;

//Given an array of integers, find 3 integers whose sum is closest to a target value. Then return that sum
public class ThreeSumClosest
{

	private static int findClosestSum(int[] inputArr,int target)
	{
		//initialize
		int min = Integer.MAX_VALUE;
		int result = 0;
		//first sort the array in ascending order
		Arrays.sort(inputArr);
		for(int i=0;i<inputArr.length;i++)
		{
			int j = i+1;
			int k = inputArr.length-1;
			int sum = 0;
			int diff = 0;
			while(j<k)
			{
				sum = inputArr[i]+inputArr[j]+inputArr[k];
				diff = Math.abs(sum-target);
				//this is the closest value possible
				if(diff == 0) return 0;

				// find the smallest difference
				if(diff<min)
				{
					min = diff;
					result = sum;
				}
				// it means that you need to move towards the right to get closer to the target
				if(sum<=target)
				{
					j++;

				}
				//it means you have to move towards the left to get closer to the target
				else
				{
					k--;
				}
			}

		}
		return result;
	}
	public static void main(String[] args)
	{
		System.out.println("Enter the number of elements in the array:");
		int num = Integer.parseInt(System.console().readLine());
		Scanner input = new Scanner(System.in);
		int[] inputArr = new int[num];
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter an element:");
			inputArr[i] = Integer.parseInt(input.next());
		}
		System.out.println("Enter the target:");
		int target = Integer.parseInt(System.console().readLine());
		int sum = findClosestSum(inputArr,target);
		System.out.println("The closest 3 sum is :"+sum);
	}
}