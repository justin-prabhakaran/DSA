package org.justinprabhakaran;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Array<T> implements DataStructure<T>, Alogrithm<T> {

    private int _lenght = 0;
    private final int _size;
    private final Object[] _array;

    public Array(int size){
        this._size = size;
        this._array = new Object[size];
    }


    @Override
    public int linearSearch(T element) {
        for(int i = 0; i< _lenght; i++){
            if(Objects.equals(_array[i],element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int binarySearch(T element) {

        Object[] temp = new Object[_lenght];
        System.arraycopy(_array,0,temp,0, _lenght);

        this.sort();

        int start=0;
        int end= _lenght-1;
        while (start < end){
            int mid = start + (end - start) / 2;

            if(Objects.equals(_array[mid],element)){
                return mid;
            }
            else if(((Comparable<Object>)_array[mid]).compareTo(element) > 0){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.arraycopy(temp,0,_array,0, _lenght);

        return -1;
    }

    @Override
    public void sort() {
        this.mergeSort();
    }

    private void mergeSort(){
        this._mergeSort(_array,0, _lenght-1);
    }

    private void _mergeSort(Object[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            _mergeSort(arr, start, mid);
            _mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(Object[] arr, int start, int mid, int end) {
        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        Object[] left = new Object[leftLength];
        Object[] right = new Object[rightLength];


        for (int i = 0; i < leftLength; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < rightLength; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;


        while (i < leftLength && j < rightLength) {
            if (((Comparable<Object>) left[i]).compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }


        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }


    @Override
    public void addElement(T element) {
        if(_size < _lenght)
            throw new IndexOutOfBoundsException("Array is Filled !!");
        _array[_lenght++] = element;
    }

    @Override
    public void removeElementAt(int index) {
        int k=0;
        for(int i=0;i<_size;i++){
            if(i != index){
                _array[k++] = _array[i];
            }
        }
        _lenght--;
    }

    @Override
    public void removeElement(T element) {
        //linear search removal
//        for(int i = 0; i< _lastIndx; i++){
//            if(Objects.equals(_array[i],element)){
//                removeElementAt(i);
//            }
//        }

        int index = linearSearch(element);
        if(index != -1) removeElementAt(index);
    }

    @Override
    public void printDataStructure() {
        System.out.print('[');
        for(int i = 0; i< _lenght; i++){
            if(_lenght -1 == i){
                System.out.print(_array[i]);
            }else System.out.print(_array[i]+", ");
        }
        System.out.println("]");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        for(int i = 0; i< _lenght; i++){
            list.add((T) _array[i]);
        }
        return list;
    }
}
