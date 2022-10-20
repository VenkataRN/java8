package com.java8practise.staticanddefaultininterfaces7.multipleinhertance;

public interface Interface3 extends  Interface2 {
    default void functionC(){
        System.out.println("function C: " + Interface3.class );
    }
    default void functionI1I2I3Main(){
        System.out.println("functionI1I2I3Main  : " + Interface3.class );
    }
}
