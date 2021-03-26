package com.endava.internship;

import java.time.LocalDate;

public class Test1 {

    public static void main(String[] args) {

        LocalDate dateOfBirn = LocalDate.of(1981, 5, 5);
        Student st1 = new Student("Alex", dateOfBirn, "5");
        Student st2 = new Student("Petr", dateOfBirn, "8");
        Student st3 = new Student("Tatiana", dateOfBirn, "6");
        Student st4 = new Student("Olga", dateOfBirn, "2");
        Student st5 = new Student("Sergei", dateOfBirn, "7");


        StudentMap<Student, Integer> map = new StudentMap<>();

        map.put(st4, 14);
        //System.out.println(st4 + " N = " + map.size());
        map.put(st3,12);
        map.put(st2, 13);
        map.put(st1, 11);
        map.put(st5, 15);

        System.out.println("number of students = " +map.size());
    }

}
