package com.java8practise.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ClassWithOnlyOneInteger{
    int anInt;
    ClassWithOnlyOneInteger(int i){
        anInt =i;
    }

    @Override
    public String toString() {
        return String.format("val : " + anInt);
    }
}
public class map2ObjDoubleLongExample {
    public static List<ClassWithOnlyOneInteger> mapToObjFunction(){
        //mapToObj takes value from above stream and feed that to create another Object
        return IntStream.range(1,5)
                .mapToObj( (i)-> {
                    return new ClassWithOnlyOneInteger(i);
                }).collect(Collectors.toList());
    }

    public static long mapToLongFunction(){
        return IntStream.range(1,5)
                .mapToLong((i)->i)
                .sum();
    }

    public static double mapToDoubleFunction(){
        return IntStream.range(1,5)
                .mapToDouble((i)->i)
                .sum();
    }

    public static void main(String args[]){
        System.out.println("mapToObjFunction" + mapToObjFunction());
        System.out.println("mapToDoubleFunction" + mapToDoubleFunction());

        System.out.println("mapToLongFunction" + mapToLongFunction());


    }


}
