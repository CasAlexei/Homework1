package com.endava.internship;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentMap<K, V> implements Map<Student, Integer> {

    private int size;               // size of the collection
//    private boolean rootIsEmpty = true;    // need to create root Node if collection is empty
    private Node root = null;   // root Node

    class Node {
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object o) {
        Node needNode = findNode((Student)o);

        return (needNode!=null);
    }

    @Override
    public boolean containsValue(Object o) {
        //TODO
        return false;
    }

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
            } else if (searchDirection == 0)
                return current;
        }
        return null;
    }

    //Inorder Printing
    private void printTreeInOrder(Node root){
        if(root==null)
            return;
        printTreeInOrder(root.left);
        System.out.print(root.key + "=" + root.value + ", ");
        printTreeInOrder(root.right);
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

    @Override
    public Integer remove(Object o) {
        if(size>0){
            --size;
        }
        return size;
    }

    @Override
    public void putAll(Map<? extends Student, ? extends Integer> map) {
        //TODO
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<Student> keySet() {
        Set<Student> set = new HashSet<>();

        makeSetOfStudent(root, set);

        return set;
    }
    private void makeSetOfStudent(Node node, Set set){
        if(node==null)
            return;
        makeSetOfStudent(node.left, set);
        //System.out.print(node.key + "=" + node.value + ", ");
        set.add(node.key);
        makeSetOfStudent(node.right, set);
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

