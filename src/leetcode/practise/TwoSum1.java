package leetcode.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionTwoSumFirst{
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int secondValue = target-nums[i];
			
			if (map.containsKey(secondValue)) {
				return new int[] {i, map.get(secondValue)};
			}
			map.put(nums[i], i);
		}
		
		
		return new int[]{};
		
	}
};

public class TwoSum1 {
	public static void main(String args[]) {
		int[] intArray = new int[] {3,2,4};
		SolutionTwoSumFirst solution = new SolutionTwoSumFirst();
		System.out.println("SolutionTwoSumFirst");
		int[] result = solution.twoSum(intArray, 6);
		System.out.println(Arrays.toString(result));
	}

}

/*


https://leetcode.com/problems/two-sum/submissions/

SolutionTwoSumFirst
[2, 1]


*/