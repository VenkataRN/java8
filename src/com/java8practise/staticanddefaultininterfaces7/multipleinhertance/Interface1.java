package com.java8practise.staticanddefaultininterfaces7.multipleinhertance;

public interface Interface1 {
    default void functionA(){
        System.out.println("function A : " + Interface1.class );
    }

    default void functionI1I2(){
        System.out.println("functionI1I2  : " + Interface1.class );
    }

    default void functionI1I2I3Main(){
        System.out.println("functionI1I2I3Main  : " + Interface1.class );
    }


    default void functionI1I4(){
        System.out.println("functionI1I4  : " + Interface1.class );
    }

}
