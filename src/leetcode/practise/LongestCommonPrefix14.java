package leetcode.practise;


class Solution14 {
    public String longestCommonPrefix(String[] strs) {
    	
        int counter = 0;
        
        int minLength = Integer.MAX_VALUE;
        for (String item:strs) {
        	if (item.length() < minLength)
        		minLength = item.length();
        }
        //System.out.println(minLength);
        boolean charFound = false;
        for (int i=0; i < minLength; i++) {
        	char ch = strs[0].charAt(i);
	    	for (String item:strs) {
	    		if (item.charAt(i) == ch) {
	    			charFound = true;
	    			continue;
	    		}
	    		else 
	    		{   charFound = false;
	    			break;
	    		}
	    	}
	    	if (charFound == true)
	    	    counter ++;
	    	else 
	    		break;
    	}
        return strs[0].substring(0, counter);
    }
};
public class LongestCommonPrefix14 {
	
	public static void main(String[] args) {
		
		String[] input = new String[] {"flower","flow","flight"};
		Solution14 solution14 = new Solution14();
		System.out.println("CommonPrefixString: [" + solution14.longestCommonPrefix(input) + "]");
		String[] input2 = new String[] {"afalower","flow","flight"};
		System.out.println("CommonPrefixString: [" + solution14.longestCommonPrefix(input2) + "]");
		
	}

}

/*

Output:
CommonPrefixString: [fl]
CommonPrefixString: []

*/

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/