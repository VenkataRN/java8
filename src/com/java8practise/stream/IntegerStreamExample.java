package com.java8practise.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntegerStreamExample {
    public static int sumOfNumbers(List<Integer> integerList){
        return integerList.stream()
                .reduce(0, Integer::sum);

        //Or
        //   .reduce(0,(first,second)-> first+second); is replaced by Integer::sum by IntelliJ

        // using Integers  is not efficient because every reduce operation is
        //Unboxing from Integer to int . Which adds additional load
        // To reduce we can use IntStreams as below function.
    }

    public static int sumOfNumberRange(){
        return IntStream.range(1,6).sum();
        //range means 1 to 5 wont include 6
    }

    public static int sumOfNumberRangeClosed(){
        IntStream.rangeClosed(1,6).forEach(v->System.out.print (v + "  "));
        LongStream.rangeClosed(1,6).forEach(v->System.out.print (v + "  "));

        return IntStream.rangeClosed(1,6).sum();
        //include  1 to 6
    }

    public static void doubleStreamFunction(){
        //wont support range and rangeCloed like int/longStream
        IntStream.rangeClosed(1,6).asDoubleStream().forEach(v->System.out.print (v + "  "));

    }
    public static void main(String[] args){
        List<Integer> inputList = Arrays.asList(1,2,3,4,5);
        System.out.println(sumOfNumbers(inputList));
        System.out.println(sumOfNumberRange());
        System.out.println(sumOfNumberRangeClosed());
        doubleStreamFunction();

    }
}
