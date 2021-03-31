package com.endava.internship;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapTest {

    @Test
    @DisplayName("test method put")
    void testPutMethod() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        assertFalse(map.isEmpty());
        assertEquals(30, map.get(st3));
        assertEquals(3, map.size());

    }

    @Test
    void TestGet(){

    }



    @Test
    @DisplayName("test size()")
    void size() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Alex", dateOfBirn6, "50");

        map.put(st1, 10);

        assertEquals(1, map.size());
    }

    @Test
    void isEmpty() {
        StudentMap<Student, Integer> map = new StudentMap();

        assertTrue(map.size() == 0);
//        assertEquals(map.);
    }

    @Test
    void containsKey() {
    }

    @Test
    void containsValue() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
        StudentMap<Student, Integer> map = new StudentMap();
        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Alex", dateOfBirn6, "50");

        map.put(st1, 10);

        assertFalse(map.isEmpty());

        map.clear();

        assertTrue(map.isEmpty());
    }

    @Test
    void keySet() {
    }

    @Test
    void values() {
    }
}