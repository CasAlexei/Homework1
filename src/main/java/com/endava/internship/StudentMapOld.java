package com.endava.internship;

import java.util.*;
/*

public class StudentMapOld<K, V> implements Map<Student, Integer> {

    private int size;   // size of the collection
    private boolean root = true;    // need to create root Node when collection is empty
    private Node<K, V> rootNode = null; // root Node



    class Node<K, V>{
        K key;
        V value;
        Node<K, V> left = null;
        Node<K, V> right = null;
        Node<K, V> parent = null;


        public Node(K key, V value, Node<K, V> parent){
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    @Override
    public String toString() {
        System.out.print("StudentMap = ");
        getAll(rootNode);
        return " }";
    }

    // returns the number of key-value mappings in this map
    @Override
    public int size() {
        return size;
    }

    // returns true if this map contains no key-value mappings
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // returns true if this map contains a mapping for the specified key
    @Override
    public boolean containsKey(Object o) {
        if(get(rootNode, (Student) o) != null)
            return true;
        return false;
    }

    // returns true if this map maps one or more keys to the specified value
    @Override
    public boolean containsValue(Object o) {
        Node top = rootNode;
        Stack<Node> stack = new Stack<>();
        while (top!=null || !stack.empty()){
            if (!stack.empty()){
                top=stack.pop();
            }
            while (top!=null){
                if(top.value == (Integer)o)
                    return true;
                if (top.right!=null) stack.push(top.right);
                top=top.left;
            }
        }
        return false;
    }

    // return value associated with the given key, or null if no such key exists
    @Override
    public Integer get(Object o) {
        Node node = get(rootNode, (Student) o);
        if(node == null)
            return null;
        else return node.value;

    }
    public Node get(Node current, Student key) {
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

    public void getAll(Node<K, V> top){
        Stack<Node<K, V>> stack = new Stack<>();
            while (top!=null || !stack.empty()){
                if (!stack.empty()){
                    top=stack.pop();
                }
                while (top!=null){
                    System.out.print("{name=" + top.key.getName() + ", date of birn=" +top.key.getDateOfBirth() + ", detail=" + top.key.getDetails() + "}, " + top.value + ", ");
                    if (top.right!=null) stack.push(top.right);
                    top=top.left;
                }
            }
    }

    // associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced
    @Override
    public Integer put(K student, V integer) {

        if(student==null)
            return null;    //does not allow to store null.

        Node newNode = new Node(student, integer, null);

        // if we add first element he will be a root of the tree
        if(root){
            rootNode = newNode;
            System.out.println("The root is:");
            System.out.println("name=" + newNode.key.getName() + " : value=" + newNode.value);
            root = false;   // first element added
        }else {
            //add new element
            Node current= rootNode;
            Node previous = null;
            int searchDirection = newNode.key.compareTo(current.key);

            while(current != null){
                // compare current object with next object (if < move left, if > move right
                searchDirection = newNode.key.compareTo(current.key);
                if (searchDirection < 0) {  // move left, if new object is less than current object

                    //System.out.println("newNode=" + newNode.key.getName() + " order=" + searchDirection); // for test

                    previous = current;
                    current = current.left;

                } else {
                    if (searchDirection > 0) {  // move right, if new object is more than current object

                        //System.out.println("newNode=" + newNode.key.getName() + " order=" + searchDirection); // for test

                        previous =current;
                        current = current.right;

                    } else {
                        // if new object and current are equals

                        //System.out.println("newNode=" + newNode.key.getName() + " order=" + searchDirection); // for test
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
        size++;
        return null;
    }

    // Removes the mapping for this key from this TreeMap if present.
    @Override
    public Integer remove(Object o) {
        // search note to delete
        Node nodeToRemove = get(rootNode, (Student) o);

        Node top = null;
        Node previous = null;

        System.out.println("Student to remove=" + nodeToRemove.key);

        // if the object has no children
        if(nodeToRemove.left == null && nodeToRemove.right == null){
            if(nodeToRemove == nodeToRemove.parent.left){
                nodeToRemove.parent.left = null;
            }else nodeToRemove.parent.right = null;
            nodeToRemove.parent = null;

            //System.out.println("left==null && right==null");  // for test
            --size;    // decrement size of collection
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
            // use iterator to reput nodes
            Stack<Node> stack = new Stack<>();
            while (top != null || !stack.empty()) {
                if (!stack.empty()) {
                    top = stack.pop();
                }
                while (top != null) {
                    put(top.key, top.value);
                    if (top.right != null) stack.push(top.right);
                    top = top.left;
                }
            }
            //  System.out.println("left!=null && right!=null");    // for test
            --size;    // decrement size of collection
        }
        return null;
    }


    // Copies all of the mappings from the specified map to this map. These mappings replace any mappings that this map had for any of the keys currently in the specified map
    @Override
    public void putAll(Map<? extends Student, ? extends Integer> map) {

    }

    // removes all of the mappings from this map. The map will be empty after this call returns
    @Override
    public void clear() {
        size = 0;
        rootNode = null;
        root = true;
    }

    // returns a Set view of the keys contained in this map
    @Override
    public Set<Student> keySet() {

        return null;
    }

    // returns a Collection view of the values contained in this map
    @Override
    public Collection<Integer> values() {
        
        return null;
    }

    @Override
    public Set<Entry<Student, Integer>> entrySet() {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

}

*/