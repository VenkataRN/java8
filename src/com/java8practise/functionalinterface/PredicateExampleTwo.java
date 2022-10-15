package com.java8practise.functionalinterface;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExampleTwo {

    //Having the conditions as Functional Interface to have this condition is available across the project
    // Hence code re-usability
    static Predicate<Student> checkGpaAbove3Predicate = (student -> student.getGpa() > 3);

    static Predicate<Student> checkGradeAbove3Predicate = (student -> student.getGradeLevel() > 3);
    public static void returnStudentIfGPAisAbove3(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach( (student -> {
            if (checkGpaAbove3Predicate.test(student)){
                System.out.println(student.getName());
            }
        }));
    }

    public static void returnStudentIfGPAandGradeisAbove3(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach( (student -> {
            if (checkGpaAbove3Predicate.and(checkGradeAbove3Predicate).test(student)){
                System.out.println(student.getName());
            }
        }));
    }

    public static void main(String[] args) {
        returnStudentIfGPAisAbove3();
        returnStudentIfGPAandGradeisAbove3();
    }
}
