package leetcode.practise;

import java.util.Arrays;

class Solution1480 {
	 public int[] runningSum(int[] nums) {
	        int sum = 0;
	        int[] result = new int[nums.length];
	        for (int i =0 ; i < nums.length; i++) {
	           sum+=nums[i];
	           result[i] = sum;
	        }
	        return result;
	        
	 }
}

public class RunningSumOf1dArray1480 {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1480 solution = new Solution1480();
		int[] input = {1,1,1,1,1};
		
		int[] result = solution.runningSum(input);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(result));
		
		

	}

}


/*
 
[1, 1, 1, 1, 1]
[1, 2, 3, 4, 5]
 */

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]

*/