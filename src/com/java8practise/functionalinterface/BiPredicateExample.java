package com.java8practise.functionalinterface;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<Double, Integer> biPredicate = (gpa,grade) -> (gpa > 3.0 && grade > 3.0);
        List<Student> studentList = StudentDataBase.getAllStudents();
        for (Student student : studentList) {
            if ( biPredicate.test(student.getGpa(), student.getGradeLevel()))
                System.out.println(student.getName());
        }
    }
}
