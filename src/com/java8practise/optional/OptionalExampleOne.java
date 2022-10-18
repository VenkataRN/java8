package com.java8practise.optional;

import com.java8practise.data.Student;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExampleOne {
    public static Supplier<Student> studentSupplier = ()-> {
        return new Student("Supplier_Student", 2, 4.0, "male", Arrays.asList("swimming", "basketball", "volleyball"));
    };

    //Using without Optional multiple null checks
    public static String getStudentNameWithoutOptional(){
        Student student = studentSupplier.get();
        if (student != null) {
            return student.getName();
        }
        return null;
    }

    public static Optional<String> getStudentNameWithOptional(){
        Optional<Student> studentOptional = Optional.ofNullable(studentSupplier.get());
        // changing above as Optional.ofNullable(null) will return Optional.empty
        if (studentOptional.isPresent()) {
            return studentOptional.map(Student::getName); // This returns Optional<String>
        }
        return Optional.empty();
    }
    public static void main(String[] args) {
        // Style -1
        //   calling getStudentNameWithoutOptional() without Optional multiple null checks inside the function
        //  And also after calling the function, to ensure no-null pointer exception
        String s1 = getStudentNameWithoutOptional();
        if (s1 != null){
            System.out.println(s1);
        }
        else {
            System.out.println("Student object is null");
        }

        //Style - 2
        Optional<String> s2 = getStudentNameWithOptional();
        if (s2.isPresent())
            System.out.println(s2.get());
        else
            System.out.println("No name");


        //other APIs
        Optional<String> s3= Optional.ofNullable(null);
        System.out.println(s3);
        Optional<String> s4= Optional.of("Of Method always expects non nullable value");
        System.out.println(s4);
        Optional<String> s5= Optional.of(null);  // of() expects non null value , passing null gives runtime exception
        System.out.println(s5);
    }
}
/*
Supplier_Student
Optional.empty
Optional[Of Method always expects non nullable value]
Exception in thread "main" java.lang.NullPointerException
	at java.util.Objects.requireNonNull(Objects.java:203)
	at java.util.Optional.<init>(Optional.java:96)
	at java.util.Optional.of(Optional.java:108)
	at com.java8practise.optional.OptionalExampleOne.main(OptionalExampleOne.java:57)


 */