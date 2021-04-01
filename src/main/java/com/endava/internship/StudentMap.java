package com.endava.internship;

import java.util.*;

public class StudentMap<K, V> implements Map<Student, Integer> {

    private int size;               // size of the collection
//    private boolean rootIsEmpty = true;    // need to create root Node if collection is empty
    private Node root = null;   // root Node

    static class Node {
        Student key;
        Integer value;
        Node left = null;
        Node right = null;
        Node parent = null;

        public Node(Student key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    // returns the number of key-value mappings in this map
    @Override
    public int size() {
        return size;
    }

    // returns true if this map contains no key-value mappings
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    // returns true if this map contains a mapping for the specified key
    @Override
    public boolean containsKey(Object o) {
        Node needNode = findNode((Student)o);

        return (needNode!=null);
    }

    // returns true if this map maps one or more keys to the specified value
    @Override
    public boolean containsValue(Object o) {
        //TODO
        return false;
    }

    // return value associated with the given key, or null if no such key exists
    @Override
    public Integer get(Object o) {
        if(root==null)
            return null;

        Node needNode = findNode((Student)o);

        return (needNode==null ? null : needNode.value);
    }

    private Node findNode(Student key){
        Node current = root;
        while (current != null) {
            int searchDirection = key.compareTo(current.key);
            if(searchDirection < 0){
                current = current.left;
            } else if (searchDirection > 0) {
                current = current.right;
            } else return current;
        }
        return null;
    }

    // print TreeMap in order
    void print(){
        printTreeInOrder(root);
    }

    //Inorder Printing
    private void printTreeInOrder(Node node){
        if(node==null)
            return;
        printTreeInOrder(node.left);
        System.out.print(node.key + "=" + node.value + ", ");
        printTreeInOrder(node.right);
    }

    // associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced
    @Override
    public Integer put(Student key, Integer value) {
        Node newNode = new Node(key, value);

        // we can`t add null
        if(key == null){
            return null;
        }

        //if we add first time into map, then the first element will be the root of the map
        if(root == null){
            root = newNode;
            size++;
            return null;
        }
        Node current = root;
        Node previous = null;
        int direction = 0;

        while(current != null){
            direction = newNode.key.compareTo(current.key);
            if(direction < 0){
                previous = current;
                current = current.left;
            }else if(direction > 0){
                previous = current;
                current = current.right;
            }else{
                return current.value = value;
            }
        }

        // add new Node in map
        if(direction < 0){
            previous.left = newNode;
            newNode.parent = previous;
        }else {
            previous.right = newNode;
            newNode.parent = previous;
        }
        size++;
        return null;
    }

    // Removes the mapping for this key from this TreeMap if present
    @Override
    public Integer remove(Object o) {
        // search note to delete
        Node nodeToRemove = findNode((Student) o);

        if(nodeToRemove==null){
            return null;
        }
        Node top;
        Node previous;

        System.out.println("Student to remove=" + nodeToRemove.key);

        // if the object has no children
        if(nodeToRemove.left == null && nodeToRemove.right == null){
            if(nodeToRemove == nodeToRemove.parent.left){
                nodeToRemove.parent.left = null;
            }else nodeToRemove.parent.right = null;
            nodeToRemove.parent = null;

            //System.out.println("left==null && right==null");  // for test
            --size;    // decrement size of collection
           //return size;
        }

        // if the object has only right child
        if(nodeToRemove.left == null && nodeToRemove.right != null) {
            previous = nodeToRemove.parent;
            if(previous.right == nodeToRemove) {
                previous.right = nodeToRemove.right;
            }else {
                previous.left = nodeToRemove.right;
            }
            //System.out.println("left==null && right!=null");  // for test
            --size;    // decrement size of collection
            //return size;
        }

        // if the object has only left child
        if(nodeToRemove.left != null && nodeToRemove.right == null) {
            previous = nodeToRemove.parent;
            if(previous.right == nodeToRemove) {
                previous.right = nodeToRemove.left;
            }else {
                previous.left = nodeToRemove.left;
            }
            //System.out.println("left!=null && right==null");  // for test
            --size;    // decrement size of collection
            //return size;
        }

        // if the object has both children
        // can`t remove root object
        if(nodeToRemove.left != null && nodeToRemove.right != null) {
            previous = nodeToRemove.parent;
            if(previous.right == nodeToRemove) {
                previous.right = nodeToRemove.right;
                top = nodeToRemove.left;
            }else {
                previous.left = nodeToRemove.left;
                top = nodeToRemove.right;
            }
            // put elements in the tree
            put(top.key, top.value);
            --size; // decrement size because in method put size incrementing

            //  System.out.println("left!=null && right!=null");    // for test

            --size;    // decrement size of collection
        }

        return size;
    }

    // Copies all of the mappings from the specified map to this map. These mappings replace any mappings that this map had for any of the keys currently in the specified map
    @Override
    public void putAll(Map<? extends Student, ? extends Integer> map) {
        //TODO
    }

    // removes all of the mappings from this map. The map will be empty after this call returns
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    // returns a Set view of the keys contained in this map
    @Override
    public Set<Student> keySet() {
        Set<Student> set = new TreeSet<>();

        makeSetOfStudent(root, set);

        return set;
    }
    private void makeSetOfStudent(Node node, Set set){
        if(node==null)
            return;
        makeSetOfStudent(node.left, set);
        set.add(node.key);
        makeSetOfStudent(node.right, set);
    }

    // returns a Collection view of the values contained in this map
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

