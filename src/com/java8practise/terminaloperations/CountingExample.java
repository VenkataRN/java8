package com.java8practise.terminaloperations;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.stream.Collectors;

public class CountingExample {
    public static Long CountingExampleOne() {

        System.out.println( StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.counting()));
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.counting());
    }

    public static Long CountingExampleTwo() {
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>3)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println("CountingExample" + CountingExampleOne());

        System.out.println("CountingExampleTwo >3 GPA " + CountingExampleTwo());


    }
}

/*

6
CountingExample6
CountingExampleTwo >3 GPA 6


 */