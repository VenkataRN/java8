package com.javapractise;

public class BinarySearchPractise {
	
	public static int binarySearch(int[] array, int element) {
		
		int lengthOfArray = array.length-1;
		
		int start = 0, end = lengthOfArray;
		// At higher values below formula may overflow the range 
		// So, use the one which is used. 
		// int middle = (start+end)/2;			
		while (start <= end) {			
			int middle = start + (end - start)/2;
			int middleElement = array[middle];
			if (middleElement == element) {
				System.out.println("Element found in : " + middle);
				return array[middle];
			}	
			
			System.out.println("start" + start + " end : " + end + "middleElement :" + middleElement);
			if (middleElement < element) {
				start = middle + 1;
			}	else		
			if (middleElement > element) {
				end = middle  - 1;
			}	else	
			//if (start >= end) {
				return middleElement;
			//}			
		}		
		return -1;
	}

//element = 4
//start=0; end =5;  middle = 2 , middleelement = 3, 3==4 (f),  3 < 4 = start = 3,  3 > 4(f)
//start=3, end =5,  middle = 4 , middleelement = 5,  
	
	public static void main(String args[]) {
		int[] inputElements = { 1,2,3,4,5};
		System.out.println( binarySearch(inputElements, 5));
		
	}

}
