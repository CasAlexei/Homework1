package com.endava.internship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapTest {

    @Test
    @DisplayName("test method put")
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

    @Test
    void testToString() {
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
    void testGet1() {
    }

    @Test
    void testPut() {
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
    }

    @Test
    void keySet() {
    }

    @Test
    void values() {
    }

    @Test
    void entrySet() {
    }
}