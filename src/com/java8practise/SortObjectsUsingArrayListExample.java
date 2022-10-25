package com.java8practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Fruit {
	Integer rollNum;
	String  name;
	
	public Integer getRollNum() {
		return rollNum;
	}
	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Fruit(Integer rollNum, String name) {
		this.name  = name;
		this.rollNum = rollNum;
	}
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + "]";
	}
	
};

public class SortObjectsUsingArrayListExample {
	public static void  main(String[] args) {
		List<Fruit> fruitList = new ArrayList<>();
		
		fruitList.add(new Fruit(1, "Apple"));
		fruitList.add(new Fruit(2, "Orange"));
		fruitList.add(new Fruit(31, "Pineapple"));
		fruitList.add(new Fruit(4, "Grape"));
		
		Comparator<Fruit> fruitComparator = (f1,f2)-> { return f1.getRollNum() - f2.getRollNum(); };
		
		//Comparator Lambda returns integer not boolean.

		fruitList.sort(fruitComparator);
		System.out.println(fruitList );
		
		//or
		
		fruitList.sort(Comparator.comparingInt(Fruit::getRollNum));		
		System.out.println(fruitList );
		
		
		//or
		
		fruitList.sort(Comparator.comparing(Fruit::getName));		
		System.out.println(fruitList );
		
	}

}
