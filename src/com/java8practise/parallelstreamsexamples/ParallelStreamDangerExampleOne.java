package com.java8practise.parallelstreamsexamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDangerExampleOne {
    public static int sequentialSum(List<Integer> inputList){
        long start = System.currentTimeMillis();
        int sum = inputList.stream()
                .reduce(0, (x,y)->x+y);
        long stop = System.currentTimeMillis();
        System.out.println("Sequential time : " + (stop-start));
        return sum;
    }

    public static int parallelSum(List<Integer> inputList){
        long start = System.currentTimeMillis();
        int sum = inputList.parallelStream()
                .reduce(0, (x,y)->x+y);
        long stop = System.currentTimeMillis();
        System.out.println("parallel time : " + (stop-start));
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1,10000)
                .boxed()
                .collect(Collectors.toList());

        sequentialSum(integerList);
        parallelSum(integerList);
    }
}

/*

Depends on Procesors.. so need to analyse before hand to use paralle or not

Sometime boxing/unboxing in parallel may take time


Sequential time : 19
parallel time : 14
 */