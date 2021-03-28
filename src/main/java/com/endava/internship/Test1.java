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

        Student st1 = new Student("Olga", dateOfBirn1, "2");
        Student st2 = new Student("Petr", dateOfBirn2, "8" );
        Student st3 = new Student("Tatiana", dateOfBirn3, "6" );
        Student st4 = new Student("Alex", dateOfBirn4, "5" );
        Student st5 = new Student("Bergei", dateOfBirn5, "7");
        Student st6 = new Student("Olgaa", dateOfBirn6, "3");
        Student st7 = new Student("Olga", dateOfBirn1, "2");

        // use test TreeMap from Java
//        Map<Student, Integer> map = new TreeMap<>();

        // use my own TreeMap
        StudentMap<Student, Integer> map = new StudentMap<>();

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);
        map.put(st4, 40);
        map.put(st5, 50);
        map.put(st6, 60);
        map.put(st7, 70);

        System.out.println("number of students = " +map.size());

        int search = map.get(st7);
        System.out.println(search);
    }

}
