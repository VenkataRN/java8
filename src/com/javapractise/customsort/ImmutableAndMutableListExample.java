package com.javapractise.customsort;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImmutableAndMutableListExample {
    public static void main(String[] args) {
        final List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println(studentList);
        Comparator<Student> comparator = (thisObj, otherObj) ->  thisObj.getName().compareTo(otherObj.getName());
        studentList.sort(comparator);
        System.out.println(studentList);
        //Even we declare List as final above, we can change the contents inside the list
        //But we can't change the list pointed memory as that is constant
        //means doing below line again will not work as studentList is pointed to constant memory
        //studentList = StudentDataBase.getAllStudents();


        //Scenario-2
        List<Student> studentListWhichIsConstant = Collections.unmodifiableList(StudentDataBase.getAllStudents());
        studentListWhichIsConstant.sort(comparator); //Will cause run-time error as we used unModifiedList API.
        System.out.println(studentList);
        //The sort will give runtime error as below
        //        Exception in thread "main" java.lang.UnsupportedOperationException
        //        at java.util.Collections$UnmodifiableList.sort(Collections.java:1331)
        //        at com.javapractise.customsort.StudentSort.main(StudentSort.java:23)

    }
}
