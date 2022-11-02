package com.javapractise;

import java.util.Scanner;

public class InputFromTerminalExample {
	public static void main(String[] args) {
		
		//Below way of using is called Try with Resources 
		// Where Resouce is inside curly brackets
		try (Scanner in = new Scanner(System.in)) {
			int i =0;
			while (i ++ < 5) {
				System.out.println(in.nextInt());
			}
		}
	}
}


//Scanner in = new Scanner(System.in);
//int i =0;
//while (i ++ < 5) {
//	System.out.println(in.nextInt());
//}


/*

Input feed after executing at terminal :  1 2 3 4 5

output:
1
2
3
4
5

*/