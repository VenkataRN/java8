package com.java8practise.parallelstreamsexamples;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamsExample {


        //Splits data then process and combine the result
        //.parallel enables
        public static int sumSequentialStream(){
            return IntStream.rangeClosed(1,100000).sum(); //Sequential stream

        }
        public static int sumParallelStream(){
            return IntStream.rangeClosed(1,100000).parallel().sum(); //Parallel stream
        }

        //Observe that above sumSequentialStream and sumParallelStreams are apt to be used like suppliers.
        // As this does the same constant operation and returns an Integer results.
        //So we can use these two as supplier<int> functinal interface functions.
        public static long CaliculatePerformance(Supplier<Integer> supplier, Integer numOfTimes){

            long startTime = System.currentTimeMillis();
            for(int i=0; i < numOfTimes; i++) {
                supplier.get();
                System.out.println(i + " " + Thread.currentThread().getName());
            }
            long endTime = System.currentTimeMillis();
            return (endTime - startTime);

        }

        public static void main(String[] args) {
            System.out.println("sumSequentialStream: " + sumSequentialStream());
            System.out.println("sumSequentialStream : " + sumSequentialStream());

            System.out.println("Time take to call sumParallelStream 20 times : "  + CaliculatePerformance(ParallelStreamsExample::sumParallelStream, 20));
            System.out.println("Time take to call sumSequentialStream 20 times : "  + CaliculatePerformance(ParallelStreamsExample::sumSequentialStream, 20));

            System.out.println("Number of processors : " + Runtime.getRuntime().availableProcessors());
        }
    }

/*

sumSequentialStream: 705082704
sumSequentialStream : 705082704
0 main
1 main
2 main
3 main
4 main
5 main
6 main
7 main
8 main
9 main
10 main
11 main
12 main
13 main
14 main
15 main
16 main
17 main
18 main
19 main
Time take to call sumParallelStream 20 times : 53
0 main
1 main
2 main
3 main
4 main
5 main
6 main
7 main
8 main
9 main
10 main
11 main
12 main
13 main
14 main
15 main
16 main
17 main
18 main
19 main
Time take to call sumSequentialStream 20 times : 5
Number of processors : 4


 */