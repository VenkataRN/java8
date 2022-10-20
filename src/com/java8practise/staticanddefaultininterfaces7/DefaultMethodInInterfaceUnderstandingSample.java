package com.java8practise.staticanddefaultininterfaces7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodInInterfaceUnderstandingSample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "zebra", "cat", "fox", "bat" );

        //Prior Java 8 - uses Collections.sort
        System.out.println("Original stringList : " + stringList);
        Collections.sort(stringList);
        System.out.println("After Collections.sort stringList : " + stringList);


        //From Java8
        List<String> anotherStringList = Arrays.asList("apple", "zebra", "cat", "fox", "bat" );
        System.out.println("Original anotherStringList : " + anotherStringList);
        //Below sort method is default method in List Interface.
        anotherStringList.sort(Comparator.naturalOrder());
        System.out.println("After sort(Comparator.naturalOrder()  anotherStringList : " + anotherStringList);
        anotherStringList.sort(Comparator.reverseOrder());
        System.out.println("After sort(Comparator.reverseOrder()  anotherStringList : " + anotherStringList);
    }
}

/*

Original stringList : [apple, zebra, cat, fox, bat]
After Collections.sort stringList : [apple, bat, cat, fox, zebra]
Original anotherStringList : [apple, zebra, cat, fox, bat]
After sort(Comparator.naturalOrder()  anotherStringList : [apple, bat, cat, fox, zebra]
After sort(Comparator.reverseOrder()  anotherStringList : [zebra, fox, cat, bat, apple]

Process finished with exit code 0

 */