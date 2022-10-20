package com.java8practise.optional;

import java.util.Optional;

public class LearningOptional {
    static Integer findNumer(Integer[] listOfIntegers, Integer toBeSearched) {
        for (Integer num : listOfIntegers) {
            if (num.equals(toBeSearched)) return num;
        }
        return null;
    }

    //User Optional.of function to make a particular one as Optional
    static Optional<Integer> findNumerWithOptional(Integer[] listOfIntegers, Integer toBeSearched) {
        for (Integer num : listOfIntegers) {
            if (num.equals(toBeSearched)) return Optional.of(num);
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] inputNumbers = {1, 2, 3, 4, 5};

        Integer result = findNumer(inputNumbers, 5);
        System.out.println("Result : " + result.intValue());

        result = findNumer(inputNumbers, 0);
        //Commenting below one for the below explanation
        // System.out.println("Result : " + result.intValue());

        //When result is Null and calling any associated function
        // It produces NullPointerException which is RunTimeException
        // Here Optional can be be used.

        Optional<Integer> resultOptional = findNumerWithOptional(inputNumbers, 5);
        System.out.println("resultOptional : " + resultOptional.get() + "\t" + resultOptional.isPresent());

        resultOptional = findNumerWithOptional(inputNumbers, 0);
        //System.out.println(resultOptional.isPresent()); TODO_U
        System.out.println("resultOptional :    " + resultOptional.empty());

    }
}
