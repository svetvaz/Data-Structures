import java.util.*;

public class RemoveDuplicates
{
	private static int removeDup(int[] inputArr)
	{
		int i=1;
		int len = 1;
		for(int j=1;j<inputArr.length;j++)
		{
			if(inputArr[j]>inputArr[j-1])
			{
				//next element is not equal to the current, hence can be left in the arr
				inputArr[i] = inputArr[j];
				len++;
			}
			else
			{
				inputArr[i]='\0';
			}
			i++;
		}
		System.out.println(Arrays.toString(inputArr));
		return len;

	}

	public static void main(String[] args)
	{
		//input arr
		int[] inputArr = {1,2,2,3,3,3,4,5};
		System.out.println(removeDup(inputArr));
	}
}