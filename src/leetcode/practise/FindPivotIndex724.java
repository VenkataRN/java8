package leetcode.practise;

import java.util.Arrays;

class Solution724 {
    public int pivotIndex(int[] nums) {
        int[] forwardSum = new int[nums.length];
        int[] reverseSum = new int[nums.length];
        int fsum =0, rsum = 0;
        
        //if input is [0] []
     if (nums.length <= 1) {
            return 0;
        }
        int numsLength = nums.length-1;
        

        for (int i = 0, j = numsLength; i < numsLength; i++, j--) {
            fsum+= nums[i];
            forwardSum[i] =fsum;
            
            rsum += nums[j];
            reverseSum[j] = rsum;
        }
        
        System.out.println(Arrays.toString(forwardSum));
        System.out.println(Arrays.toString(reverseSum));

       //Step 1
        // Check example 3 
        if (reverseSum[1] == 0 ) {
            return 0;
        }

      //Step 2
        for (int i = 1; i< numsLength; i++) {
            if (forwardSum[i-1] == reverseSum[i+1] ) {
                return i;
            }
        }
        
      //Step 3
        // Check example 3 other way. It is in the forward path
        if (forwardSum[numsLength-1] == 0) {
            return numsLength;
        }
        
        // Order should not change. To ensure the behavior
        return -1;
    }
}

public class FindPivotIndex724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution724 solution = new Solution724();
		int[] input = {2,5};
		
		System.out.println(solution.pivotIndex(input));

	}

}
/*

[2, 0]
[0, 5]
-1


*/
/*

Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

 

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0


*/