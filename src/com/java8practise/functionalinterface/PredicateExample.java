package com.java8practise.functionalinterface;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> isEven = (input)-> {return (input % 2 ==0) ; };
    //OR
    static Predicate<Integer> isDivisibleby5 = (input)-> (input % 5 ==0);
    public static void predicateExampleOne(){

        System.out.println(isEven.test(6));
        System.out.println(isDivisibleby5.test(6));
    }

    public static void predicateExampleChainingUsingAndOr(){

        System.out.println(isEven.and(isDivisibleby5).test(10));
        System.out.println(isDivisibleby5.or(isEven).test(5));
        System.out.println(isDivisibleby5.or(isEven).negate().test(5));

    }

    public static void main(String[] args) {
        predicateExampleOne();
        predicateExampleChainingUsingAndOr();
    }
}
