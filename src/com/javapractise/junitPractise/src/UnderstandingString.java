package com.javapractise.junitPractise.src;

public class UnderstandingString {
    public static void main(String[] args) {

        //Thought-1
        String s1 = "Hello"; //Using String literal and String pool
        System.out.println(s1.toUpperCase());
        System.out.println(s1); //Value of s1 wont change
        System.out.println(s1.hashCode());
        s1 = s1.toUpperCase(); //Instead of changing the s1..if we obseve below new object is created which returns different hashcode
        System.out.println(s1.hashCode());


        //Thought-2
        String s3= new String("Hello"); //Sting is not interned
        System.out.println(s1 == s3); //returns false

        //Thought-3
        String s4= new String("Hello").intern(); //Sting is  interned
        System.out.println(s1 == s4); //returns true


    }
}
