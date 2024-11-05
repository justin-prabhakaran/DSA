package org.justinprabhakaran;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Objects;

public class SinglyLinkedList<T extends Comparable<T> > implements DataStructure<T>, Algorithm<T> {

    private Node _head;
    private int _size;

    @Override
    public int linearSearch(T element) {
        Node temp = _head;
        int i=0;
        while (_head != null){
            if(Objects.equals(_head.val, element)){
                return i;
            }
            _head = _head.next;
            i++;
        }
        _head = temp;
        return -1;

    }

    @Override
    public int binarySearch(T element) {

        this.sort();
        Node start = _head;
        Node end = null;
        while (start != end){
            Node slow = start;
            Node fast = start;
            Node midPrev = null;
            while (fast != end && fast.next != end){
                midPrev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            Node mid = slow  ;
            System.out.println(mid.val) ;
            if(mid.val.equals(element)){
                return indexOf(mid.val);
            }else {
                assert element != null;
                if(mid.val.compareTo(element) > 0){
                    end = midPrev;
                }else start = mid.next;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        this.mergeSort();
    }


    private void mergeSort(){
        _head = this._mergeSort(_head);
    }

    private Node _mergeSort(Node list){
        if(list == null || list.next == null) return list;

        Node middle = findMiddle(list);

        Node leftSorted = _mergeSort(list); // left as list starting
        Node rightSorted = _mergeSort(middle); //right as middle starting

        return merge(leftSorted,rightSorted);
    }

    private Node findMiddle(Node list){
        if(list == null || list.next == null) return list;

        Node slow = list;
        Node fast = list.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middle = slow.next;
        slow.next = null;
        return middle;
    }


    private Node merge(Node left, Node right){
        if(left == null) return right;
        if(right == null) return left;

        Node result;
        if(left.val.compareTo(right.val) <= 0){
            result = left;
            result.next = merge(left.next, right);
        }else{
            result = right;
            result.next = merge(left,right.next);
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] getData() {
        T[] arr = (T[]) Array.newInstance(_head.val.getClass(),_size);
        int i=0;
        while (_head != null){
            arr[i++] = _head.val;
            _head = _head.next;
        }
        return  arr;
    }

    @Override
    public int indexOf(T element) {
        Node temp = _head;
        int i=0;
        while (temp != null){
            if(temp.val.equals(element))
                return i;
            i++;
            temp = temp.next;
        }
        return -1;
    }



    @Override
    public void addElement(T element) {
        if (_head == null) {
            _head = new Node(element);
            _size++;
            return;
        }
        Node temp = _head;
        while (_head.next != null) {
            _head = _head.next;
        }
        _head.next = new Node(element);
        _head = temp;
        _size++;
    }

    @Override
    public void addElementAt(int index, T element) {
        if (index > _size) throw new IndexOutOfBoundsException("index > size of the list!!");

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

        _size++;
    }

    @Override
    public void removeElementAt(int index) {
        if(index > _size) throw new IndexOutOfBoundsException("index > length !!");

        if(index == 0){
            _head = _head.next;
            _size--;
            return;
        }
        int i=0;
        Node prev = null;
        Node temp = _head;
        while (_head.next != null){
            if(i == index) break;
            i++;
            prev = _head;
            _head = _head.next;
        }
        if(prev != null) prev.next = _head.next;
        _head = temp;
        _size--;
    }

    @Override
    public void removeElement(T element) {
        // int index = linearSearch(element);
        // if(index != -1) removeElementAt(index);

        if(_head == null) throw new EmptyStackException();
        if(_head.val == element){
            _head = _head.next;
            return;
        }

        Node prev = null;
        Node temp = _head;
        while (_head.next != null){
            if(Objects.equals(_head.val,element)) break;
            prev = _head;
            _head = _head.next;
        }

        if(prev != null) prev.next = _head.next;

        _head = temp;
        _size--;

    }

    @Override
    public void printDataStructure() {
        System.out.print("[");
        Node temp = _head;
        while (_head != null){
            if(_head.next == null){
                System.out.print(_head.val);
            }else {
                System.out.print(_head.val + ", ");
            }
            _head = _head.next;
        }
        System.out.println("]");
        _head = temp;
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

    @Override
    public int size() {
        return _size;
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
