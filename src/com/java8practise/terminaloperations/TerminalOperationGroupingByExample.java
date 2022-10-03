package com.java8practise.terminaloperations;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TerminalOperationGroupingByExample {
    //This is simlar to groupBy of SQL
    //Groups based on the property and Returns in Map<K,V>
    //Multiple versions
    //groupingBy(classifier)
    //groupingBy(classifier, downstream)
    //groupingBy(classifier, supplier, downstream)

    public static void groupStudentsByGenderGroupingByExample1() {
        Map<String, List<Student>> studentsByGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentsByGender);
    }

    public static void groupStudentsByGenderGroupingByExample2() {
        Map<String, List<Student>> studentsByGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() > 3.8 ? "OUTSTANDING" : "AVERAGE"));
        System.out.println(studentsByGender);
    }

    public static void groupStudentsByGenderGroupingByExample3() {
        Map<Integer, Map<Object, List<Student>>> studentsByGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getGradeLevel,
                                Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));

        System.out.println(studentsByGender);
    }

    public static void groupStudentsByGenderGroupingByExample4() {
        Map<Integer, Integer> studentsByGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getGradeLevel,
                                summingInt(Student::getNoteBooks)));

        System.out.println(studentsByGender);
    }

    public static void groupStudentsByGenderGroupingByExampleWithThreeArguments() {
        Map<String, Set<Student>> studentsByGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getName, LinkedHashMap::new, toSet()));

        System.out.println(studentsByGender);
    }

    public static void displayTopGPAStudentForEachGradeLevel() {
        Map<Integer, Optional<Student>> topGPAStudentForEachGradeLevel = StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparingDouble(Student::getGpa))));

        System.out.println(topGPAStudentForEachGradeLevel);
        System.out.println("The above output will display with optional like below comment");
//        {2=Optional[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}],
//         3=Optional[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}],
//        4=Optional[Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}

        Map<Integer, Student> topGPAStudentForEachGradeLevelWithoutOptionalInOutput = StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getGradeLevel,
                              collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student::getGpa)),
                                      Optional::get)));

        System.out.println(topGPAStudentForEachGradeLevelWithoutOptionalInOutput);

        //IntelliJ proposed correct the lines 77 to 80 as below
        //toMap(Student::getGradeLevel, Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(Student::getGpa))));

    }

    public static void main(String[] args) {
        groupStudentsByGenderGroupingByExample1();
        System.out.println();

        groupStudentsByGenderGroupingByExample2();
        System.out.println();

        groupStudentsByGenderGroupingByExample3();
        System.out.println();

        groupStudentsByGenderGroupingByExample4();
        System.out.println();

        groupStudentsByGenderGroupingByExampleWithThreeArguments();
        System.out.println();

        displayTopGPAStudentForEachGradeLevel();
    }
}


/*

{female=[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}, Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}], male=[Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}, Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}

{AVERAGE=[Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}, Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}, Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}], OUTSTANDING=[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}, Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}

{2={AVERAGE=[Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}], OUTSTANDING=[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}]}, 3={OUTSTANDING=[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}]}, 4={AVERAGE=[Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}], OUTSTANDING=[Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}}

{2=21, 3=27, 4=32}

{Adam=[Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}], Jenny=[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}], Emily=[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}], Dave=[Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}], Sophia=[Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}], James=[Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}

{2=Optional[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}], 3=Optional[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}], 4=Optional[Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}
The above output will display with optional like below comment
{2=Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}, 3=Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, 4=Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}}


 */