import java.util.*;

public class TwoSum
{

	private static ArrayList<Integer> calcTwoSum(ArrayList<Integer> arr,int target)
	{
		ArrayList<Integer> resultIndices = new ArrayList<Integer>();
		// a+b = c...so for every a, we need to find a c-b...lets add target - a as key and index(a) as the value..every time we iterate thru array
		// check if it exists as key in the map...if it does, then return its value
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		// add the target - arr element as key into the map
		for(int i=0;i<arr.size();i++)
		{
			Integer arrItem = arr.get(i);
			if(map.containsKey(arrItem))
			{
				int index1 = i;
				int index2 = map.get(arrItem);
				resultIndices.add(index1);
				resultIndices.add(index2);
				return resultIndices;
			}
			else
			{
				map.put(new Integer(target - arrItem),i);
			}
			
		}
		return resultIndices;
	}

	public static void main(String[] args)
	{
		// enter the array of integers
		System.out.println("Enter the number of elements in the list");
		int num = Integer.parseInt(System.console().readLine());
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter the element :");
			arr.add(Integer.parseInt(input.next()));
		}
		System.out.println("Enter the target value:");
		int target = Integer.parseInt(System.console().readLine());
		System.out.println("The original list");
		for(Integer arrVal:arr)
		{
			System.out.println(arrVal.toString());
		}
		ArrayList<Integer> result = calcTwoSum(arr,target);
		System.out.println("The indices of the 2 values that add up to the target are :");
		for(Integer val:result)
		{
			System.out.println(val.toString());
		}
	}
}