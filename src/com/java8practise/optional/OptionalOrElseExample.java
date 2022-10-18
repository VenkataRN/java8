package com.java8practise.optional;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {

    public static void optionalOrElseUseCaseFunction(){
        //Please observe that below line will give compilation Error
        // Because studentSupplier() is Lambda function and
        // always expected to call that with association function of the Lambda function
        // To Get value use .get
        //Optional<Student> studentOptional =  StudentDataBase.studentSupplier();


        //Optional.ofNullable converts a class to Optional of that type of class.
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = studentOptional.map(Student::getName).orElse("Default");
        System.out.println("Scenaior 1" + name);

        Optional<Student> studentOptional2 = Optional.ofNullable(null);
        String name2 = studentOptional2.map(Student::getName).orElse("Default When object is null using orElse");
        System.out.println("Scenaior 2" + name2);

        String name3 = studentOptional2.map(Student::getName).orElseGet(()->"orElseGetCustomized Builtin Supplier    as part of orElseGet");
        System.out.println("Scenaior 3" + name3);

        System.out.println("Scenaior 4" + "Throwing Exception using orElseThrow");
        String name4 = studentOptional2.map(Student::getName).orElseThrow(()->new RuntimeException("Empty value hence throwing Runtime Exception"));
        System.out.println("Scenaior 4" +name4);  //Being the name4 is null, this wont get execute as we are throwing exception from above.


    }
    public static void main(String[] args) {
        optionalOrElseUseCaseFunction();
    }
}

/*


Scenaior 1Adam
Scenaior 2Default When object is null using orElse
Scenaior 3orElseGetCustomized Builtin Supplier    as part of orElseGet
Scenaior 4Throwing Exception using orElseThrow
Exception in thread "main" java.lang.RuntimeException: Empty value hence throwing Runtime Exception
	at com.java8practise.optional.OptionalOrElseExample.lambda$optionalOrElseUseCaseFunction$1(OptionalOrElseExample.java:31)
	at java.util.Optional.orElseThrow(Optional.java:290)
	at com.java8practise.optional.OptionalOrElseExample.optionalOrElseUseCaseFunction(OptionalOrElseExample.java:31)
	at com.java8practise.optional.OptionalOrElseExample.main(OptionalOrElseExample.java:37)

 */