package com.endava.internship;

import java.util.*;


public class StudentMap<Student, Integer> implements Map<Student, Integer> {

    private int count;
    private boolean root = true;
    private Node rootNode = null;



    class Node{
        Student key;
        Integer value;
        Node left = null;
        Node right = null;
        Node parent = null;


        public Node(Student key, Integer value, Node parent){
            this.key = key;
            this.value = value;
            //this.parent = parent;
        }
    }

    @Override
    public String toString() {
        return "StudentMap{" +
                "count=" + count +
                " '}'";
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

    @Override
    public Integer get(Object o) {

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
        }else{
            //add new element

//        if(newNode.key.equals(rootNode.key)){
//            System.out.println("Left");
//        }else{
//            System.out.println("Right");
//        }
            System.out.print("new key = " + newNode.key);
            System.out.println(" + new value = " + newNode.value);
            //System.out.println("  " + newNode.key.compareTo(rootNode.key));

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

