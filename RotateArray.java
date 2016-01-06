import java.util.*;


class RotateArray
{


	private static int[] rotateArray(int[] arr,int k)
	{
		int[] result = new int[arr.length];
		//Divide the array into 2 parts. K will indicate the dividing line
		int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length-k);
		int[] arr2 = Arrays.copyOfRange(arr, arr.length-k,arr.length);
		//Reverse arr1 and arr2 individually
		arr1 = reverseArray(arr1);
		arr2 = reverseArray(arr2);
		//now merge the 2 arrays
		int[] mergedArr = combine(arr1,arr2);
		//now reverse the entire array
		result = reverseArray(mergedArr);
		return result;
	}

	public static int[] combine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

	private static int[] reverseArray(int[] rawArr)
	{
		int[] arr = new int[rawArr.length];
		if(rawArr.length>1)
		{
			for(int i=0;i<rawArr.length/2;i++)
			{
				arr = swap(rawArr,i,rawArr.length-1-i);
			}
		}
		else
		{
			return rawArr;
		}
		return arr;
	}

	private static int[] swap(int[] arr,int begIndex, int endIndex)
	{
		int temp = arr[begIndex];
		arr[begIndex] = arr[endIndex];
		arr[endIndex] = temp;
		return arr;
	}

	public static void main(String[] args)
	{
		// Enter the array
		int[] inputArray = {1,2,3,4,5,6,7};
		//Enter K - number of steps by which array has to be rotated
		System.out.println("Please enter the number of steps by which the array needs to be rotated");
		int steps = Integer.parseInt(System.console().readLine());
		int[] rotatedArray = rotateArray(inputArray,steps);
		System.out.println(Arrays.toString(rotatedArray));
	}
}