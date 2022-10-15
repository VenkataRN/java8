package com.java8practise.functionalinterface;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void biConsumerSimpleExample() {
        System.out.println("------------------------ biConsumerSimpleExample --------------");
        BiConsumer<Integer, Integer> multiplyBiconsumer = (a, b) -> System.out.println(a * b);
        multiplyBiconsumer.accept(2,5);
    }

    public static void printStudentNameAndActivities() {
        System.out.println("------------------------ printStudentNameAndActivities --------------");

        BiConsumer<String, List<String>> studentUtility = (student, studentActivities) -> System.out.println(student + studentActivities);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((consumerInputIsStudent) -> studentUtility.accept(consumerInputIsStudent.getName(),
                consumerInputIsStudent.getActivities()));
    }

    public static void main(String[] args) {
        biConsumerSimpleExample();
        printStudentNameAndActivities();
    }
}
