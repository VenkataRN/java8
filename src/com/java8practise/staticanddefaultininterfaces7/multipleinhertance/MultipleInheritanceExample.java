package com.java8practise.staticanddefaultininterfaces7.multipleinhertance;

public class MultipleInheritanceExample implements Interface1, Interface2, Interface3, Interface4 {

    /*
    As functionI1I4() function defination is in Interface1 and 4,
    We should override that function to avoid the conflict,
    else leads to compile time error as below

            java: class com.java8practise.staticanddefaultininterfaces7.multipleinhertance.MultipleInheritanceExample
            inherits unrelated defaults for functionI1I4() from types
            com.java8practise.staticanddefaultininterfaces7.multipleinhertance.Interface1
            and
            com.java8practise.staticanddefaultininterfaces7.multipleinhertance.Interface4
     */

    //As explained above, below is the overriden function
    //Need to make below function as Public as
    /*
      'functionI1I4()' in
      'com.java8practise.staticanddefaultininterfaces7.multipleinhertance.MultipleInheritanceExample'
      clashes with 'functionI1I4()' in 'com.java8practise

      So, making the overrident function as public
     */
     public void functionI1I4(){
        System.out.println("functionI1I4  : " + MultipleInheritanceExample.class );
    }
     public void functionI1I2I3Main(){
        System.out.println("functionI1I2I3Main  : " + MultipleInheritanceExample.class );
    }

    public static void main(String[] args) {
        MultipleInheritanceExample multipleInheritanceExample = new MultipleInheritanceExample();
        multipleInheritanceExample.functionA();
        multipleInheritanceExample.functionB();
        multipleInheritanceExample.functionC();

        //Scenario-2 (Where overrides are involved
        System.out.println("---------------- Scenario 2  functionI1I2 is in Interface1 and Interface2--------------------");
        multipleInheritanceExample.functionI1I2();

        //Scenario-3 Where functionI1I2I3Main is called from Main now
        System.out.println("---------------- Scenario 3  functionI1I2I3Main is in Interface1,2,3 and also main--------------------");
        multipleInheritanceExample.functionI1I2I3Main();


        //Scenario-4
        // Where two different and un-related interfaces has same default function
        // here we have to override that in main.
        System.out.println("---------------- Scenario 4  functionI1I4 is in Interface1,4, to remove conflict here we should override in main--------------------");
        multipleInheritanceExample.functionI1I2I3Main();

    }
}


/*

function A : interface com.java8practise.staticanddefaultininterfaces7.multipleinhertance.Interface1
function B:  interface com.java8practise.staticanddefaultininterfaces7.multipleinhertance.Interface2
function C: interface com.java8practise.staticanddefaultininterfaces7.multipleinhertance.Interface3
---------------- Scenario 2  functionI1I2 is in Interface1 and Interface2--------------------
functionI1I2  : interface com.java8practise.staticanddefaultininterfaces7.multipleinhertance.Interface2
---------------- Scenario 3  functionI1I2I3Main is in Interface1,2,3 and also main--------------------
functionI1I2I3Main  : class com.java8practise.staticanddefaultininterfaces7.multipleinhertance.MultipleInheritanceExample
---------------- Scenario 4  functionI1I4 is in Interface1,4, to remove conflict here we should override in main--------------------
functionI1I2I3Main  : class com.java8practise.staticanddefaultininterfaces7.multipleinhertance.MultipleInheritanceExample

Process finished with exit code 0


 */