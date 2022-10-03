package com.java8practise.terminaloperations;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.stream.Collectors;

public class JoiningTerminalOperationExample {
    public static String JoiningExampleOne() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    public static String JoiningExampleTwo() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-Delim-"));
    }

    public static String JoiningExampleThree() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("*Delim*", "-prefix-", "-suffix-"));
    }

    public static Long CountingExample() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.counting());
    }
    public static void main(String[] args) {
        System.out.println(JoiningExampleOne());
        System.out.println(JoiningExampleTwo());
        System.out.println("JoiningExampleThree : " + JoiningExampleThree());
        System.out.println("CountingExample" + CountingExample());

    }
}

/*
AdamJennyEmilyDaveSophiaJames
Adam-Delim-Jenny-Delim-Emily-Delim-Dave-Delim-Sophia-Delim-James
JoiningExampleThree : -prefix-Adam*Delim*Jenny*Delim*Emily*Delim*Dave*Delim*Sophia*Delim*James-suffix-
CountingExample6
 */