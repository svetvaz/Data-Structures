import java.util.*;

//Given an Array B and an Array A with extra space at the end to accomodate the whole of B, merge the 2 sorted arrays
public class MergeSortedArrays
{

	private static int[] mergeArr(int[] inputArrA,int[] inputArrB)
	{
		int m = inputArrA.length;
		int n = inputArrB.length;
		int k = 0;
		int[] inputMerged = Arrays.copyOf(inputArrA,m+n);
		while(m>0 && n>0)
		{
			k = m+n-1;
			if(inputArrA[m-1]>inputArrB[n-1])
			{
				inputMerged[k] = inputArrA[m-1];
				m--;
			}
			else{
				inputMerged[k] = inputArrB[n-1];
				n--;
			}
		}
		while(n>0)
		{
			inputMerged[k] = inputArrB[n-1];
			n--;
		}
		return inputMerged;
	}

	public static void main(String[] args)
	{
		//enter the arrays
		int[] inputArrA = {2,3,5,7,8,10,12,15};
		int[] inputArrB = {3,4,5,6,7,8,9,13};
		int[] mergedArr = mergeArr(inputArrA,inputArrB);
		System.out.println(Arrays.toString(mergedArr));

	}
}