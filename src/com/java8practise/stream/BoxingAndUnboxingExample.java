package com.java8practise.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Boxing: Converting Primitive Type to Wrapper Class type eg: int -> Integer
//Unboxing : Converting Wrapper class type to Primitive type eg: Integer to int
public class BoxingAndUnboxingExample {
    public static List<Integer> boxingFunction(){
        return IntStream.range(1,10)
                .boxed()
                .collect(Collectors.toList());

         //With Boxed fucntion each int is converted to Integer so the collectors.toList will not throw error
    }

    public static int unboxingFunction(List<Integer> integerList){
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args){
        boxingFunction();
        System.out.println( unboxingFunction(Arrays.asList(1,2,3,4,5)));
    }
}
