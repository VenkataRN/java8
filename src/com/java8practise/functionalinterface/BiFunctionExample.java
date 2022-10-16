package com.java8practise.functionalinterface;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (studentList, studentPredicate) -> {
            Map<String, Double> map = new HashMap<>();
            studentList.forEach( (student) -> {
                if ( studentPredicate.test(student))
                    map.put(student.getName(), student.getGpa());
            });
           return map;
        };

        Predicate<Student> predicate = (s) -> s.getGpa() > 3.0;
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), predicate));
    }
}
