package com.endava.internship;

import java.util.*;


public class StudentMap<K, V> implements Map<Student, Integer> {

    private int count;
    private boolean root = true;
    private Node rootNode = null;



    class Node{
        Student key;
        Integer value;
        Node left = null;
        Node right = null;
        Node parent;


        public Node(Student key, Integer value, Node parent){
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    @Override
    public String toString() {
        return "StudentMap{" +
                "count=" + count +
                "}";
    }

    @Override
    public int size() {
        //TODO
        return count;
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return false;
    }

    @Override
    public boolean containsKey(Object o) {
        //TODO
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        //TODO
        return false;
    }
    // return value associated with the given key, or null if no such key exists
    @Override
    public Integer get(Object o) {
        return get(rootNode, (Student) o);
    }
    public Integer get(Node current, Student key) {
        while (current != null) {
            int searchDirection = key.compareTo(current.key);
            if(searchDirection < 0){
                current = current.left;
            }else
                if(searchDirection > 0){
                    current = current.right;
                }
            else return current.value;
        }
        return null;
    }

      @Override
    public Integer put(Student student, Integer integer) {

        if(student==null)
            return null;    //does not allow to store null.

        Node newNode = new Node(student, integer, null);

        // if we add first time element he will be a root of the tree
        if(root){
            rootNode = newNode;
            System.out.println("The root is = " + newNode.key + " - value = " + newNode.value);
            System.out.println("-----------------------------");
            root = false;   // first element added
        }else {
            //add new element
            Node current= rootNode;
            Node previous = null;
            int searchDirection;

            searchDirection = newNode.key.compareTo(current.key);

            while(current != null){
                // compare current object with next object (if < move left, if > move right
                searchDirection = newNode.key.compareTo(current.key);
                if (searchDirection < 0) {  // move left
                    // if object is less than root object
                    // for test
                    System.out.println("newNode = " + newNode.key + " " + searchDirection);

                    previous = current;
                    current = current.left;

                } else {
                    if (searchDirection > 0) {  // move right
                        // if object is more than root object
                        // for test
                        System.out.println("newNode = " + newNode.key + " " + searchDirection);

                        previous =current;
                        current = current.right;

                    } else {
                        // if object and root are equals
                        // for test
                        System.out.println("newNode = " + newNode.key + " " + searchDirection);
                        previous = current;
                        current = null;

                    }
                }

            }   // end while != null
            if(searchDirection < 0){    // change left reference
                previous.left = newNode;
                newNode.parent = previous;
            }else {
                if (searchDirection > 0) {    // change right reference
                    previous.right = newNode;
                    newNode.parent = previous;
                } else {  // change current value
                    previous.value = newNode.value;
                }
            }
        }
        count++;
        return null;
    }

    @Override
    public Integer remove(Object o) {
        //TODO
        return null;
    }

    @Override
    public void putAll(Map<? extends Student, ? extends Integer> map) {
        //TODO
    }

    @Override
    public void clear() {
        //TODO
    }

    @Override
    public Set<Student> keySet() {
        //TODO
        return null;
    }

    @Override
    public Collection<Integer> values() {
        //TODO
        return null;
    }

    @Override
    public Set<Entry<Student, Integer>> entrySet() {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

}

