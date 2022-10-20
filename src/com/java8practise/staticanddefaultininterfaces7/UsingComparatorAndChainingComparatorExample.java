package com.java8practise.staticanddefaultininterfaces7;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class UsingComparatorAndChainingComparatorExample {
    public static Consumer<Student> studentConsumer = (s) -> System.out.println(
            "Name : " + s.getName()
                    + " Grade: " + s.getGradeLevel()
                    + " GPA: " + s.getGpa()
    );
    public static Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);
    public static Comparator<Student> studentGPAComparator = Comparator.comparingDouble(Student::getGpa);
    public static void sortStudentsByName() {
        System.out.println("-----------------sortStudentsByName----------------------");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.sort(studentNameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortStudentsByGPA() {
        System.out.println("-----------------sortStudentsByGPA----------------------");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.sort(studentGPAComparator);
        studentList.forEach(studentConsumer);
    }


    public static void sortStudentsByGradeAndByName() {

        System.out.println("-----------------sortStudentsByGradeAndByName----------------------");
        Comparator<Student> studentGradeComparator = Comparator.comparingInt(Student::getGradeLevel);
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.sort(studentGradeComparator.thenComparing(studentNameComparator));
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        sortStudentsByName();
        sortStudentsByGPA();
        sortStudentsByGradeAndByName();

    }
}

/*

-----------------sortStudentsByName----------------------
Name : Adam Grade: 2 GPA: 3.6
Name : Dave Grade: 3 GPA: 4.0
Name : Emily Grade: 3 GPA: 4.0
Name : James Grade: 4 GPA: 3.9
Name : Jenny Grade: 2 GPA: 3.8
Name : Sophia Grade: 4 GPA: 3.5
-----------------sortStudentsByGPA----------------------
Name : Sophia Grade: 4 GPA: 3.5
Name : Adam Grade: 2 GPA: 3.6
Name : Jenny Grade: 2 GPA: 3.8
Name : James Grade: 4 GPA: 3.9
Name : Emily Grade: 3 GPA: 4.0
Name : Dave Grade: 3 GPA: 4.0
-----------------sortStudentsByGradeAndByName----------------------
Name : Adam Grade: 2 GPA: 3.6
Name : Jenny Grade: 2 GPA: 3.8
Name : Dave Grade: 3 GPA: 4.0
Name : Emily Grade: 3 GPA: 4.0
Name : James Grade: 4 GPA: 3.9
Name : Sophia Grade: 4 GPA: 3.5

 */