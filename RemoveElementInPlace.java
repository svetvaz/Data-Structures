import java.util.*;

public class RemoveElementInPlace
{
	private static int removeElement(int[] inputArr,int val)
	{
		int newLen = 0;
		for(int i=0;i<inputArr.length;i++)
		{
			if(inputArr[i]!=val)
			{
				newLen++;
			}
		}
		return newLen;
	}

	public static void main(String[] args)
	{
		//enter the arr
		int[] inputArr = {2,6,3,1,7,9,3};
		System.out.println("Enter the element to be removed:");
		int val = Integer.parseInt(System.console().readLine());
		int newLen = removeElement(inputArr,val);
		System.out.println("New length:"+newLen);
	}
}