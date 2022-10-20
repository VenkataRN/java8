package com.java8practise.staticanddefaultininterfaces7;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static com.java8practise.staticanddefaultininterfaces7.UsingComparatorAndChainingComparatorExample.studentConsumer;
import static com.java8practise.staticanddefaultininterfaces7.UsingComparatorAndChainingComparatorExample.studentNameComparator;

public class ComparatorHandlingWhenNullValuesAreFeeded {

    /*
      1 )
      This is in continuation of UsingComparatorAndChainingComparatorExample.java file
       Where the studentList has no null values
       Here we are going to introduce null values as part of student List and
       Then for the same program, we get run time error

       but using nullsFirst and nullsLast functions of Comparator, we can overcome
       this problem

     */

    /*
    2) Not using studentConsumer here because studentConsumer accesses member functions while printing like s.getName()
    which causes NullPointerException. So, here just printing 's' such that if it is null, it can be printed as null
     */

    /*
    3) sortStudentsByGradeAndByNameCanNotHandleNullValues() is commented in main
    because it causes NullPointerException as below
    -----------------sortStudentsByGradeAndByNameCanNotHandleNullValues----------------------
            -----------------sortStudentsByGradeAndByNameCanNotHandleNullValues----------------------
            Exception in thread "main" java.lang.NullPointerException
                at java.util.Comparator.lambda$comparingInt$7b0bb60$1(Comparator.java:490)
                at java.util.Comparator.lambda$thenComparing$36697e65$1(Comparator.java:216)
                at java.util.TimSort.countRunAndMakeAscending(TimSort.java:355)
                at java.util.TimSort.sort(TimSort.java:220)
                at java.util.Arrays.sort(Arrays.java:1438)
                at java.util.Arrays$ArrayList.sort(Arrays.java:3895)
                at com.java8practise.staticanddefaultininterfaces7.ComparatorHandlingWhenNullValuesAreFeeded.sortStudentsByGradeAndByNameCanNotHandleNullValues(ComparatorHandlingWhenNullValuesAreFeeded.java:53)
                at com.java8practise.staticanddefaultininterfaces7.ComparatorHandlingWhenNullValuesAreFeeded.main(ComparatorHandlingWhenNullValuesAreFeeded.java:72)
      */
    public static Consumer<Student> studentConsumerLocal = (s) -> System.out.println(s);
    public static void sortStudentsByGradeAndByNameCanNotHandleNullValues(){

        System.out.println("-----------------sortStudentsByGradeAndByNameCanNotHandleNullValues----------------------");
        Comparator<Student> studentGradeComparator = Comparator.comparingInt(Student::getGradeLevel);
        List<Student> studentList = StudentDataBase.getAllStudentsWhereFewArrayListElementsAreNull();

        studentList.sort(studentGradeComparator.thenComparing(studentNameComparator));
        studentList.forEach(studentConsumer);
    }

    public static void sortStudentsByGradeAndByNameCanHandleNullValues(){

        System.out.println("-----------------sortStudentsByGradeAndByNameCanHandleNullValues----------------------");
        Comparator<Student> studentGradeComparator = Comparator.comparingInt(Student::getGradeLevel);
        List<Student> studentList = StudentDataBase.getAllStudentsWhereFewArrayListElementsAreNull();

        Comparator<Student> studentComparator = Comparator.nullsFirst(studentGradeComparator);
        studentList.sort(studentComparator.thenComparing(studentGradeComparator).thenComparing(studentNameComparator));
        studentList.forEach(studentConsumerLocal);
    }

    public static void main(String[] args) {

       //Commenting below line else this gives run time error as below
       // CommentedBy Purpose as explained above
       // sortStudentsByGradeAndByNameCanNotHandleNullValues();

        sortStudentsByGradeAndByNameCanHandleNullValues();
    }
}


/*

-----------------sortStudentsByGradeAndByNameCanHandleNullValues----------------------
null
null
null
Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', noteBooks=10, bike=null, activities=[swimming, basketball, volleyball]}
Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', noteBooks=11, bike=null, activities=[swimming, gymnastics, soccer]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', noteBooks=15, bike=null, activities=[swimming, gymnastics, soccer]}
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', noteBooks=12, bike=null, activities=[swimming, gymnastics, aerobics]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', noteBooks=22, bike=null, activities=[swimming, basketball, baseball, football]}
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', noteBooks=10, bike=null, activities=[swimming, dancing, football]}

 */