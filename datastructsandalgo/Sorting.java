package com.datastructsandalgo;


public class Sorting {
	
	
	/**
	 * Selection sort : Consider each ith value of the input array as the min, then find min in the elements 
	 * between i+1 and end. If the new_min<old_min, swap that new_min with i.
	 * Takes O(n^2) : very inefficient when you have a large input array
	 * @param input array of ints
	 * @return sorted array of ints
	 */
	public static int[] selectionSort(int[] input){
		long start = System.currentTimeMillis();
		for(int i=0;i<input.length;i++){
			int min = i;
			for(int j=i+1;j<input.length;j++){
				if(input[j]<input[min]){
					min = j;
				}
			}
			if(min!=i){
				//indexes are not the same, so swap
				int temp = input[i];
				input[i] = input[min];
				input[min] = temp;
			}
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("Sorting completed in "+time+" milli seconds");
		return input;
	}
	
	/**
	 * Bubble sort : Simplest sort algorithm that compares neighbors and swaps to sort in ascending order
	 * @param input array of ints
	 * Takes O(n^2)
	 * @return sorted array of ints
	 */
	public static int[] bubbleSort(int[] input){
		long start = System.currentTimeMillis();
		int temp;
		for(int i=0;i<input.length;i++){
			for(int j=1;j<input.length-i;j++){
				if(input[j-1]>input[j]){
					temp = input[j-1];
					input[j-1] = input[j];
					input[j] = temp;
				}
			}
			
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("Sorting completed in "+time+" milli seconds");
		return input;
	}
	

	/**
	 * Quicksort : 1. Divide-Conquer Algo
	 * 			   2. Choose pivot (usually middle element). Separate out elements < pivot into arr1 and those >= pivot into arr2
	 * 			   3. QuickSort arr1 & arr2 recursively
	 * 			   4. Join arr1 & arr2	
	 * Best time : O(n log n)
	 * Worst time : O(n^2)
	 * Best case can be improved if done in parallel
	 * @param input unsorted array
	 * @return sorted array of ints
	 */
	public static int[] quickSort(int[] input)
	{
		 long start = System.currentTimeMillis();
		 input = sortQuick(0, input.length-1,input);
		 long time = System.currentTimeMillis() - start;
		 System.out.println("Sorting completed in "+time+" milli seconds");
		 return input;
	}
	
	private static void swap(int i, int j,int[] input){
		int temp;
		temp = input[i];
		input[i]=input[j];
		input[j]=temp;
	}
	
	private static int[] sortQuick(int low, int high,int[] input){
		int mid = (low +(high-low)/2);
		int pivot = input[mid];
		int i=low, j=high;
		//first divide, separate out elements less than the pivot from 
		//elements greater than or equal to pivot
		 while (i <= j) {
			 while (input[i] < pivot) {
			        i++;
			      }
			 while (input[j] > pivot) {
			        j--;
			      }
			 //swap elements that are not less/greater than pivot
			 if (i <= j) {
			        swap(i, j,input);
			        i++;
			        j--;
			      }

		 }
		 if(low<j){
			 input = sortQuick(low,j,input);
		 }
		 if(i<high){
			 input = sortQuick(high,i,input);
		 }
		 
		
		return input;
	}
	
	/**
	 * Merge Sort : Divide & Conquer again
	 * 1. Split input arr nto 2 sub arrays
	 * 2. Sort each array separated recursively 
	 * 3. Merge the 2 arrays
	 * 
	 * Unsuitable for small array sets
	 * Uses extra space (extra array to copy)
	 * 
	 * Takes O(n log n) in the best, average & worst case
	 * @param input unsorted array
	 * @return sorted array of ints
	 */
	public static int[] mergeSort(int[] input)
	{
	    long start = System.currentTimeMillis();
		msort(input,0,input.length-1);
		long time = System.currentTimeMillis() - start;
		System.out.println("Sorting completed in "+time+" milli seconds");
		return input;
		
	}
	
	private static void msort(int[] input, int low, int high)
	{
		int mid;
		 if(low<high)
		 {
		  mid=(low+high)/2;
		  msort(input,low,mid);
		  msort(input,mid+1,high);
		  merge(input,low,mid+1,high);
		 }
		
	}
	
	private static int[] merge(int[] input,int low, int mid, int high){
		int[] helper=new int[input.length];
		for (int i = low; i <= high; i++) {
		      helper[i] = input[i];
		    }
		int i = low;
	    int j = mid + 1;
	    int k = low;
		//copy back the values into the main array while comparing each of the values from the 2 parts
		while (i <= mid && j <= high) {
			if (helper[i] <= helper[j]) {
				input[k]=helper[i];
				i++;
			}else{
				input[k]=helper[j];
				j++;
			}
			k++;
		}
		//copy the remaining elements from the left part into the main array
		while(i<=mid){
			input[k]=helper[i];
			k++;
			i++;
		}
		return input;
	}
	

	public static void printSortedList(int[] sortedList){
		for(int i=0;i<sortedList.length;i++){
			System.out.println(sortedList[i]);
		}
		System.out.println();
		
	}
	
	
	/**
	 * Main: creation on input array and printing the sorted output
	 */
	public static void main(String[] args) {
		//create a list of Integers
		int[] input = {5,2,9,3,5,7,8,1,2,-3,2,7};
		int[] selectionSortList = selectionSort(input);
		printSortedList(selectionSortList);
		int[] bubbleSortList = bubbleSort(input);
		printSortedList(bubbleSortList);
		int[] quickSortList = quickSort(input);
		printSortedList(quickSortList);
		int[] mergeSortList = mergeSort(input);
		printSortedList(mergeSortList);
		
	}

}
