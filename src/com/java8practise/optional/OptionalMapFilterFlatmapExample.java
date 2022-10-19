package com.java8practise.optional;

import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFilterFlatmapExample {
    public static Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

    public static void filterOptionalFunction(){
       studentOptional.filter(s->s.getGpa() > 3.5)
               .ifPresent(System.out::println);
    }

    public static  void usingMapInOptionalFunction(){
        if (studentOptional.isPresent()) {
            //Looks like when map is returning Optional, it wont complain even we dont have
            // a variable to catch the output of map function.
            //I meant removing stringOptional wont cause any compilation error
           Optional<String> stringOptional =  studentOptional.filter(s->s.getGpa() > 3.5)
                    .map(Student::getName);
           System.out.println("usingMapInOptionalFunction : " + stringOptional.get());
        }
    }

    public static void usingFlatMapInOptionalFunction(){
       Optional<Student> studentWithBike = Optional.ofNullable(StudentDataBase.studentSupplierWithBike.get());
       if (studentWithBike.isPresent()){
        Optional<String> bikeDetails =   studentWithBike.filter(s->s.getGpa() > 3)
                   .flatMap(s->s.getBike())
                .map(bike -> bike.getName());
        System.out.println("usingFlatMapInOptionalFunction " + bikeDetails.get());
        bikeDetails.ifPresent(s->System.out.println(s)); //another way of printing.
       }
    }
    public static void main(String[] args) {
        filterOptionalFunction();
        usingMapInOptionalFunction();
        usingFlatMapInOptionalFunction();

    }
}
