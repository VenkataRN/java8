package leetcode.practise;


class Solution {
	public int findNumber(int[] nums) {
		int count = 0;
		for (Integer num:nums) {
			if (num.toString().length() % 2 == 0) count++;
		}
		return count;
	}
}
public class FindNumbersWithEvenNumberOfDigits1295 {
	public static void main(String args[]) {
	 int[]	nums = {555,901,482,1771};
	 
	 Solution solution = new Solution();
	 System.out.println(  solution.findNumber(nums));
	}
	

}
