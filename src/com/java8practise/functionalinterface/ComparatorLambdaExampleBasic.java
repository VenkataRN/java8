package com.java8practise.functionalinterface;

import java.util.Comparator;

public class ComparatorLambdaExampleBasic {
	public static void main(String[] args) {
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
				
			}
			
		};
		Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
		int var1 = 5, var2 = 6;
		
		System.out.println("Comparator with Override without Lambda : " + comparator.compare(var1, var2));
		System.out.println("Comparator with Override : With Lambda " + comparator2.compare(5, 4));
		
		
	}

}


/*
Comparator with Override without Lambda : -1
Comparator with Override : With Lambda 1


*/