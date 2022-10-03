package com.java8practise.terminaloperations;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperation_maxBy_minByExample {

    //maxBy()  minBy() takes comparator as input parameter and returns Optional as return
    public static Optional<Student> minByExampleFunction(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> maxByExampleFunction(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static int summingIntExampleFunction(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {
        System.out.println(minByExampleFunction());
        System.out.println(maxByExampleFunction());

        System.out.println(summingIntExampleFunction());
    }
}

/*

Optional[Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}]
Optional[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}]
80



 */