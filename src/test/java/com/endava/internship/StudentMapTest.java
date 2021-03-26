package com.endava.internship;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapTest {

    @Test
    void put() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);

        Student st1 = new Student("Alex", dateOfBirn6, "50");
        map.put(st1, 10);
        assertEquals(10, map.get(st1));
    }

    @Test
    void TestGet(){

    }
}