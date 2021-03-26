package com.endava.internship;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Student implements Comparable<Student>
{
    private String name;
    private LocalDate dateOfBirth;
    private String details;
    private int age;

    public Student(String name, LocalDate dateOfBirth, String details, int age) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.details = details;
        this.age = age;

    }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public String getDetails() { return details; }

    /*TODO consider overriding any methods for this object to function properly within a collection:
        1. A student is considered unique by a combination of their name and dateOfBirth
        2. Student names are sorted alphabetically, if two students have the same name, then the older one is
        placed before the younger student in an ordered student list.
    */


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {

        return this.name.compareTo(student.name);
    }
}
