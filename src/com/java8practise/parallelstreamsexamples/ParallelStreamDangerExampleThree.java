package com.java8practise.parallelstreamsexamples;

import java.util.Arrays;
import java.util.List;

//Objective is to add 5 on top of sum of the Below Array

public class ParallelStreamDangerExampleThree {
    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);


        //In correct way
        //Adding as part of initial value in reduce. 5 gets aadded for each thread's initial which causes
        //incorrect and un-predictable sum
        int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum) ;
        System.out.println("ParallelStream " + sum);


        //Properway:anything need to badded should be done after everything
        //The actual result might differ depending on the number of threads used in the common fork-join pool.
        //In order to fix this issue, the number five should be added outside of the parallel stream
        //5 is getting added at last below
         sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
        System.out.println("Parallel Stream with adding at the end " + sum);
    }
}

/*

ParallelStream 30
Parallel Stream with adding at the end 15

https://www.baeldung.com/java-when-to-use-parallel-stream
 */