package com.java8practise.functionalinterface;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class ConsumerAndPredicateCombinedExample {

    static Predicate<Student> checkGpaAbove3Predicate = (student -> student.getGpa() > 3);

    static Predicate<Student> checkGradeAbove3Predicate = (student -> student.getGradeLevel() > 3);

    BiConsumer<String, List<String>> printStudentNameAndActivities = (arg1, arg2)-> System.out.println(arg1 + arg2);


    public void passEachStudentNameAndActivitiesWhoseGPAandGradeIsAbove3AfterGettingAllStudents(){
        StudentDataBase.getAllStudents().forEach(consumerInputStudent -> {
            if (checkGpaAbove3Predicate.and(checkGradeAbove3Predicate).test(consumerInputStudent)){
                printStudentNameAndActivities.accept(consumerInputStudent.getName(), consumerInputStudent.getActivities());
            }
        });

    }
    public static void main(String[] args) {
        //Here calling non-Static method hence doing new of this class and calling public funcion.
        //If we declare passEachStudentNameAndActivitiesWhoseGPAandGradeIsAbove3AfterGettingAllStudents() as static
        //we can call below without new as we obseved in other files.
        //For the same reasons even BiConsumer printStudentNameAndActivities() is non-static as the function
        // which is using this biconsumer function is also non-static
        new ConsumerAndPredicateCombinedExample().passEachStudentNameAndActivitiesWhoseGPAandGradeIsAbove3AfterGettingAllStudents();

    }
}
