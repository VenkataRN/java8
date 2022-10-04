package com.java8practise.parallelstreamsexamples;

import java.util.stream.IntStream;

class Sum {
    int total;

    public int getTotal() {
        return total;
    }

    public void performSum(int i) {
        total = total + i;
    }
}

public  class ParallelStreamDangerExampleTwo {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Sum sum = new Sum();
            IntStream.rangeClosed(1, 10000)
                    .forEach(sum::performSum);
            System.out.println("SequentialStream Iteration [" + i + "]" + sum.getTotal());
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            Sum sumAnother = new Sum();
            IntStream.rangeClosed(1, 10000)
                    .parallel()
                    .forEach(sumAnother::performSum);
            System.out.println("ParallelStream Iteration [" + i + "]" + sumAnother.getTotal());
        }
    }
}

/*
The sum is not consistant when we use parallel with mutable values.
sum has a total which will be shared by multiplep parallel processes ,
which is causing the incorrect and incosistant sum of the numbers.

while using mutable ones, need to take care

SequentialStream Iteration [0]50005000
SequentialStream Iteration [1]50005000
SequentialStream Iteration [2]50005000

ParallelStream Iteration [0]46002526
ParallelStream Iteration [1]29365235
ParallelStream Iteration [2]30153722

 */