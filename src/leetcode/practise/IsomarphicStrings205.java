package leetcode.practise;

import java.util.HashMap;

class Solution205 {
	public boolean isIsomorphic(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();


		HashMap<Character, Character> hashMap = new HashMap<>();
		
		Character sChar = s.charAt(0);
		Character tChar = t.charAt(0);
		hashMap.put(sChar,  tChar);
		hashMap.put(tChar, sChar);
		
		for(int i=1; i< sLen; i++) {
			Character sKey = s.charAt(i);
			Character tKey = t.charAt(i);
			
			if (hashMap.containsKey(sKey) && hashMap.containsKey(tKey)) {
				if (hashMap.get(sKey) == tKey && hashMap.get(tKey) == sKey) {
					continue; 
				}
				else
					return false;
			}
			
			if (hashMap.containsKey(sKey)) {
				if (hashMap.get(sKey) != tKey) {
					return false;
				}
			}
			
			if (hashMap.containsKey(tKey)) {
				if (hashMap.get(tKey) != sKey) {
					return false;
				}
			}
			
			hashMap.put(sKey, tKey);
			hashMap.put(tKey, sKey);
		}
	
		return true; //TODO
	}
};
public class IsomarphicStrings205 {

	public static void main( String[] args) {
		// TODO Auto-generated method stub
		Solution205 solution = new Solution205();
		System.out.println(solution.isIsomorphic("egg","add"));
		System.out.println(solution.isIsomorphic("foo","bar"));
		System.out.println(solution.isIsomorphic("paper","title"));
		System.out.println(solution.isIsomorphic("badc","baba"));
		System.out.println(solution.isIsomorphic("a", "a"));

	}

}
