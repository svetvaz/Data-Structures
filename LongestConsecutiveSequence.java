/*Given an unsorted array of integers, find the length of the longest consecutive ele-
ments sequence.
For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.*/

import java.util.*;

public class LongestConsecutiveSequence
{

	private static int findLongestSequence(int[] inputArr)
	{
		//using HashSet
		HashSet<Integer> intSet = new HashSet<Integer>();
		// check if each element is the first element in the sequence, if it is add it and keep counting
		int max = 1;

		for(int i:inputArr)
		{
			intSet.add(i);
		}
		//initialized to 1 to count the current element
		int count = 1;
		
		for(int i:inputArr)
		{
			int left = i-1;
			int right = i+1;
			

			while(intSet.contains(left))
			{	
				count++;
				intSet.remove(left);
				left--;
			}
			while(intSet.contains(right))
			{
				count++;
				intSet.remove(right);
				right++;
			}

			max =  Math.max(count,max);

		}
		return max;

	}

	public static void main(String[] args)
	{
		// enter the array
		int[] inputArr = {100, 4, 200, 1, 3, 2};
		int sequenceLength = findLongestSequence(inputArr);
		System.out.println(sequenceLength);
	}
}