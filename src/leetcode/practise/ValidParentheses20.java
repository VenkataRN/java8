package leetcode.practise;

import java.util.HashMap;
import java.util.Stack;

class Solution20{
	
	//Need to understand how this works actually
	public boolean isCorrect(String s) {
		
		//Read element push to the stack 
		//Read next element
		//compare next with the top of the stack : if matches pop the element
		//if not matching push the one to the stack.
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	private boolean isChPair(char firstChar, char pairChar) {
		if ((firstChar == '(' && pairChar == ')') ||
				(firstChar == '[' && pairChar == ']') ||
				(firstChar == '{' && pairChar == '}') )
		{
			return  true;
		}
		else return false;
	}
	
	public boolean isValid(String s) {
		HashMap<Character, Character> hashMap = new HashMap<>();
		
		hashMap.put('}', '{');
		hashMap.put(']', '[');
		hashMap.put(')', '(');
		
		Stack<Character> stack = new Stack<>();
		if (s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')')
			return false;
		else
			stack.push(s.charAt(0));
		
		for (int i=1; i <= s.length() - 1 ; i++ ) {
			char c2 = s.charAt(i);
			if (stack.isEmpty() && (c2 == '}' || c2 == ']' || c2 == ')') )
				return false;
			
			if (c2 == '{' || c2 == '[' || c2 == '(')
			{
				stack.push(c2);
				continue;
			}
			if (stack.peek() == hashMap.get(c2))
				stack.pop();
			else
				stack.push(c2);
			
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}

// "(){}}{"
public class ValidParentheses20 {

	public static void main(String[] args) {
		

		//My dev approach
		Solution20 solution20= new Solution20();
	    System.out.println(	solution20.isValid("{[]}"));
	    System.out.println(	solution20.isValid("()[]{}"));
	    System.out.println(	solution20.isValid("(){}}{"));
	    
	    //taken from internet
	    System.out.println(	solution20.isCorrect("{[]}"));
	    System.out.println(	solution20.isCorrect("()[]{}"));
	    System.out.println(	solution20.isCorrect("(){}}{"));
		
	}

}

/*
 
true
true
false
true
true
false
 
 */
/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

*/