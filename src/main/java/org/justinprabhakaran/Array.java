package org.justinprabhakaran;


import java.util.ArrayList;
import java.util.List;

public class Array<T> implements DataStructure<T>, Alogrithms<T> {

    private int _index = 0;
    private int _size;
    private Object[] _array;

    public Array(int size){
        this._size = size;
        this._array = new Object[size];
    }


    @Override
    public int linearSearch(T element) {
        //TODO : implementation
        return 0;
    }

    @Override
    public int binarySearch(T element) {
        //TODO : implementation
        return 0;
    }

    @Override
    public void addElement(T element) {
        if(_size < _index)
            throw new IndexOutOfBoundsException("Array is Filled !!");
        _array[_index++] = element;
    }

    @Override
    public void removeElementAt(int index) {
        int k=0;
        for(int i=0;i<_size;i++){
            if(i != index){
                _array[k++] = _array[i];
            }
        }
        _index--;
    }

    @Override
    public void removeElement(T element) {
        //TODO : implementation
    }

    @Override
    public void printDataStructure() {
        //TODO : implementation
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        for(int i=0;i<_index;i++){
            list.add((T) _array[i]);
        }
        return list;
    }
}
