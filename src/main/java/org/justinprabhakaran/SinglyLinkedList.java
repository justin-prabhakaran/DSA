package org.justinprabhakaran;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SinglyLinkedList<T> implements DataStructure<T>, Alogrithm<T> {

    private Node _head;
    private int _length;

    @Override
    public int linearSearch(T element) {
        return 0;
    }

    @Override
    public int binarySearch(T element) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public void addElement(T element) {
        if (_head == null) {
            _head = new Node(element);
            _length++;
            return;
        }
        Node temp = _head;
        while (_head.next != null) {
            _head = _head.next;
        }
        _head.next = new Node(element);
        _head = temp;
        _length++;
    }

    @Override
    public void addElementAt(int index, T element) {
        if (index > _length) throw new IndexOutOfBoundsException("index > size of the list!!");

        if (index == 0) {
            Node temp = new Node(element);
            temp.next = _head;
            _head = temp;
            return;
        }
        int i = 0;
        Node temp = _head;
        Node prev = null;
        while (_head != null) {
            if (i == index) break;
            i++;
            prev = _head;
            _head = _head.next;
        }
        Node node = new Node(element);
        if (prev != null) prev.next = node;
        node.next = _head;

        _head = temp;

        _length++;
    }

    @Override
    public void removeElementAt(int index) {

    }

    @Override
    public void removeElement(T element) {

        if(_head == null) throw new EmptyStackException();
        if(_head.val == element){
            _head = _head.next;
            return;
        }

        Node prev = null;
        Node temp = _head;
        while (_head.next != null){
            if(_head.val == element) break;
            prev = _head;
            _head = _head.next;
        }

        if(prev != null) prev.next = _head.next;

        _head = temp;
    }

    @Override
    public void printDataStructure() {

    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        while (_head != null) {
            list.add(_head.val);
            _head = _head.next;
        }
        return list;
    }

    private class Node {

        T val;
        Node next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }
}
