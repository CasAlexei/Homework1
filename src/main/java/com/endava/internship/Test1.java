package com.endava.internship;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test1 {

    public static void main(String[] args) {

        LocalDate dateOfBirn1 = LocalDate.of(1981, 5, 5);
        LocalDate dateOfBirn2 = LocalDate.of(1982, 5, 5);
        LocalDate dateOfBirn3 = LocalDate.of(1983, 5, 5);
        LocalDate dateOfBirn4 = LocalDate.of(1984, 5, 5);
        LocalDate dateOfBirn5 = LocalDate.of(1985, 5, 5);
        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);

        Student st1 = new Student("Olga", dateOfBirn1, "2", 10);
        Student st2 = new Student("Petr", dateOfBirn2, "8", 20);
        Student st3 = new Student("Tatiana", dateOfBirn3, "6", 30);
        Student st4 = new Student("Alex", dateOfBirn4, "5", 40);
        Student st5 = new Student("Sergei", dateOfBirn5, "7",50);
        Student st6 = new Student("Olgaa", dateOfBirn6, "3", 60);

        Map<Student, Integer> map = new TreeMap<>();

        map.put(st1, 1);
        map.put(st2, 2);
        map.put(st3, 3);
        map.put(st4, 4);
        map.put(st5, 5);
        map.put(st6, 6);


        System.out.println(map);


//        StudentMap<Student, Integer> map = new StudentMap<>();
//
//        map.put(st4, 14);
//        //System.out.println(st4 + " N = " + map.size());
//        map.put(st3,12);
//        map.put(st2, 13);
//        map.put(st1, 11);
//        map.put(st5, 15);
//
//        System.out.println("number of students = " +map.size());
    }

}
