package leetcode.practise;

import java.util.HashMap;

class Solution13 {
    public int romanToInt(String s) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);

    	int sum =0;
    	for (int i=0; i < s.length(); i++) {
    		if (s.charAt(i) == 'V' || s.charAt(i) == 'X') {
    			if (i > 0 && s.charAt(i-1) == 'I') {
    				sum -= 2;
    			}
    		}
     		if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
    			if (i > 0 && s.charAt(i-1) == 'X') {
    				sum -= 20;
    			}
    		}
     		if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
    			if (i > 0 && s.charAt(i-1) == 'C') {
    				sum -= 200;
    			}
    		}
    			sum += map.get(s.charAt(i));
    		}
    		
    	  		
    	return sum;
    }
    
    public int romanToInt2(String s) {
        int sol = 0, num = 0; //MCMXCIIIV
     for (int i = s.length()-1; i >= 0; i--) {
    	 //System.out.println("s.charAt(i)" + s.charAt(i));
         switch(s.charAt(i)) {
             case 'I': num = 1; break;
             case 'V': num = 5; break;
             case 'X': num = 10; break;
             case 'L': num = 50; break;
             case 'C': num = 100; break;
             case 'D': num = 500; break;
             case 'M': num = 1000; break;
         }
         if (4 * num < sol) {
        	 sol -= num;
        	 System.out.println("sol -= num; s.charAt(i) " + s.charAt(i) + ", sol "+  sol +  " ,num " + num + " , 4 * num " + 4 * num );
         }
         else {
        	 sol += num;
        	 System.out.println("sol += num; s.charAt(i) " + s.charAt(i) + ", sol  " + sol + ", num " + num + " , 4 * num " + 4 * num);
         }
       
     }
     return sol;
 }
    
    public int romanToInteger3(String s) {
    	s=s.replace("IV", "IIII");
    	s=s.replace("IX", "VIIII");
    	s=s.replace("XL", "XXXX");
    	s=s.replace("XC", "LXXXX");
    	s=s.replace("CD", "CCCC");
    	s=s.replace("CM", "DCCCC");
    	HashMap<Character, Integer> hashMap = new HashMap<>();
    	hashMap.put('I', 1);
    	hashMap.put('V', 5);
    	hashMap.put('X', 10);
    	hashMap.put('L', 50);
    	hashMap.put('C', 100);
    	hashMap.put('D', 500);
    	hashMap.put('M', 1000);
    	
    	int sum =0;
    	System.out.println(s);
    	for(int i=0; i < s.length(); i++) {
    		sum += hashMap.get(s.charAt(i));
    	}
    	
    	return sum; 
    }
    
    public int romanToInteger4(String s) {
    	
    	int oldVal = 0, num =0  , sum =0;
    	
    	for (int i = s.length() - 1; i >= 0; i--) {
    	    switch(s.charAt(i)) {
            case 'I': num = 1; break;
            case 'V': num = 5; break;
            case 'X': num = 10; break;
            case 'L': num = 50; break;
            case 'C': num = 100; break;
            case 'D': num = 500; break;
            case 'M': num = 1000; break;
        }
    	    //IV
    	    // if oldVal is greater than the new value : subtract
    	    if (oldVal > num) {
    	    	sum -= num;
    	    }
    	    // if Oldval is smaller than (VI) the new value : add
    	    // if Oldval is equal to  (III) the new value : add
    	    
    	    if (oldVal <= num) {
    	    	sum += num;
    	    }
    		oldVal = num;
    	}
    	
    	return sum; 
    	
    }
}

public class RomanToInteger13 {
	
	public static void main(String args[]) {
		Solution13 solution = new Solution13();
		System.out.println("Res (i did not understand this style: " + solution.romanToInt2("MCMXCIV"));
		System.out.println(solution.romanToInteger3("MCMXCIV"));
		System.out.println(solution.romanToInteger4("MCMXCIV"));

//
//		System.out.println(solution.romanToInt("MCMXCIV"));
		
		//start from last but one to first (reverse)
		// IIV
		//If current element is > the previous element reduce
		// 

	}
	

}


/*
 
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

*/