package com.java8practise.staticanddefaultininterfaces7.multipleinhertance;

public interface Interface2 extends Interface1 {
    default void functionB(){
        System.out.println("function B:  " + Interface2.class );
    }
    default void functionI1I2(){
        System.out.println("functionI1I2  : " + Interface2.class );
    }

    default void functionI1I2I3Main(){
        System.out.println("functionI1I2I3Main  : " + Interface2.class );
    }

}
