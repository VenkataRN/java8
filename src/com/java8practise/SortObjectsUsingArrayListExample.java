package com.java8practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Fruit implements Comparable<Fruit> {
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
		return "Fruit [rollNum=" + rollNum + ", name=" + name + "]";
	}
	


	@Override
	public boolean equals(Object obj) {
		if (obj == this) return false;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Fruit fruit = (Fruit) obj;
		return this.rollNum == fruit.getRollNum();
		
	}
	
//	@Override
//	public int hashCode() {
//		//Objects.hash(this)
//		return Objects.hash(name+rollNum);
//	}
	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		return 1;
	}

	
};

public class SortObjectsUsingArrayListExample {
	public static void  main(String[] args) {
		List<Fruit> fruitList = new ArrayList<>();
		
		fruitList.add(new Fruit(1, "Apple"));
		fruitList.add(new Fruit(2, "Pineapple"));
		fruitList.add(new Fruit(31, "Orange"));
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
		
		//or
		System.out.println("Using compareTo feature ");
		Collections.sort(fruitList);
		System.out.println(fruitList);
		
	}

}


/*

[Fruit [rollNum=1, name=Apple], Fruit [rollNum=2, name=Pineapple], Fruit [rollNum=4, name=Grape], Fruit [rollNum=31, name=Orange]]
[Fruit [rollNum=1, name=Apple], Fruit [rollNum=2, name=Pineapple], Fruit [rollNum=4, name=Grape], Fruit [rollNum=31, name=Orange]]
[Fruit [rollNum=1, name=Apple], Fruit [rollNum=4, name=Grape], Fruit [rollNum=31, name=Orange], Fruit [rollNum=2, name=Pineapple]]
Using compareTo feature 
[Fruit [rollNum=1, name=Apple], Fruit [rollNum=4, name=Grape], 
Fruit [rollNum=31, name=Orange], Fruit [rollNum=2, name=Pineapple]]


//When Fruits.CompareTo returns 0
Using compareTo feature 
[Fruit [rollNum=2, name=Pineapple], Fruit [rollNum=31, name=Orange], 
Fruit [rollNum=4, name=Grape], Fruit [rollNum=1, name=Apple]]

//When Fruits.CompareTo returns 1
Using compareTo feature 
[Fruit [rollNum=1, name=Apple], Fruit [rollNum=4, name=Grape], 
Fruit [rollNum=31, name=Orange], Fruit [rollNum=2, name=Pineapple]]


*/