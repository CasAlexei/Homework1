package com.endava.internship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapTest {

    @Test
    @DisplayName("test method put()")
    void testPutMethod() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);


        assertAll(
                () -> assertFalse(map.isEmpty()),
                () -> assertEquals(30, map.get(st3)),
                () -> assertEquals(3, map.size())
        );
    }

    @Test
    @DisplayName("test method get()")
    void TestGet(){
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        assertEquals(30, map.get(st3));
        assertEquals(3, map.size());
    }


    @Test
    @DisplayName("test method size()")
    void size() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        assertEquals(0, map.size());

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);
        map.put(st3, 30);
        assertEquals(3, map.size());
    }

    @Test
    @DisplayName("test method isEmpty()")
    void isEmpty() {
        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        StudentMap<Student, Integer> map = new StudentMap();
        Student st1 = new Student("Olga", dateOfBirn6, "6");

        assertEquals(0,map.size());
        assertTrue(map.isEmpty());

        map.put(st1, 50);

        assertEquals(1, map.size());
        assertFalse(map.isEmpty());

        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    @DisplayName("test method containsKey()")
    void containsKey() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");
        Student st8 = new Student("Net", dateOfBirn6, "888");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        boolean result = map.containsKey(st3);
        assertTrue(result);
    }

    @Test
    @DisplayName("test method containsValue()")
    void containsValue() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        boolean result = map.containsValue(20);

        assertTrue(result);
    }

    @Test
    @DisplayName("test method get()")
    void get() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        assertEquals(20, map.get(st2));
    }

    @Test
    @DisplayName("test method remove()")
    void remove() {
        StudentMap<Student, Integer> map = new StudentMap();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        assertEquals(20, map.get(st2));
        assertEquals(3, map.size());

        map.remove(st2);

        assertEquals(2, map.size());
        assertNull(map.get(st2));
    }

    @Test
    @DisplayName("test method clear()")
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
    @DisplayName("test method keySet()")
    void keySet() {
        StudentMap<Student, Integer> map = new StudentMap();
        Set<Student> set = new TreeSet<>();

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        set.add(st1);
        set.add(st2);
        set.add(st3);

        assertArrayEquals(set.toArray(), map.keySet().toArray());
    }

    @Test
    @DisplayName("test method values()")
    void values() {
        StudentMap<Student, Integer> map = new StudentMap();
        List<Integer> list = Arrays.asList(30, 10, 20);

        LocalDate dateOfBirn6 = LocalDate.of(1981, 8, 8);
        Student st1 = new Student("Olga", dateOfBirn6, "6");
        Student st2 = new Student("Petr", dateOfBirn6, "5");
        Student st3 = new Student("Alex", dateOfBirn6, "8");

        map.put(st1, 10);
        map.put(st2, 20);
        map.put(st3, 30);

        assertArrayEquals(list.toArray(), map.values().toArray());
    }
}