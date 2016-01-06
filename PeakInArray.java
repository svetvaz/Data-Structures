import java.util.*; 

//find the highest peak in the array
public class PeakInArray
{
	public static void main(String[] args)
	{
		//enter arr
		int[] inputArr = {1, 2, 3, 1,4};
		//find peak
		int peak = Integer.MIN_VALUE;
		int j=0;
		int larger = inputArr[0];
		int index = 0;
		for(int i=0;i<inputArr.length;i++)
		{
			if(i!=inputArr.length-1 && i!=0)
			{
				if(inputArr[i]>inputArr[i-1] && inputArr[i]>inputArr[i+1])
				{
					larger = inputArr[i];
					if(larger>peak)
					{
						index = i;
						peak  = larger;
					}
				}
			}
			else
			{
				//condition for the last element
				if((i==inputArr.length-1 && inputArr[i]>inputArr[i-1]) ||(i==0 && inputArr[i]>inputArr[i+1]))
				{
					larger = inputArr[i];
					if(larger>peak)
					{
						index = i;
						peak  = larger;
					}
				}

			}
		}
		System.out.println("Index is:"+index);
		System.out.println("Peak is:"+peak);

	}
}