package com.java8practise.functionalinterface;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerChainingExample {
    private static void printAllStudentNames() {
        System.out.println("------------------------ printAllStudentNames --------------");

        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> studentConsumer = (student -> System.out.println(student.getName()));
        //forEach takes Consumer implementation as an argument.
        studentList.forEach(studentConsumer);
    }

    private static void printAllStudentNamesAndActivitiesByChainingWithAndThenOperation() {
        System.out.println("------------------------ printAllStudentNamesAndActivitiesByChainingWithAndThenOperation --------------");

        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> studentConsumer = (student -> System.out.println(student.getName()));
        Consumer<Student> studentActivities = (student -> System.out.println(student.getActivities()));
        //forEach takes Consumer implementation as an argument.
        studentList.forEach(studentConsumer.andThen(studentActivities));
    }

    private static void printStudentNamesAndActivitiesWhoHasLessThan4GPA(){
        System.out.println("------------------------ printStudentNamesAndActivitiesWhoHasLessThan4GPA --------------");
        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> studentNameConsumer = (student -> System.out.println(student.getName() + student.getGpa()));
        Consumer<Student> studentActivities = (student -> System.out.println(student.getActivities()));
        studentList.forEach((student)->{
            if (student.getGpa() < 4)
                studentNameConsumer.andThen(studentActivities).accept(student);
        });

    }

    public static void main(String[] args) {

    printAllStudentNames();
        printAllStudentNamesAndActivitiesByChainingWithAndThenOperation();
        printStudentNamesAndActivitiesWhoHasLessThan4GPA();
    }


}
