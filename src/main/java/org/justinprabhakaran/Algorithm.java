package org.justinprabhakaran;

public interface Algorithm<T> {
    public int linearSearch(T element);
    public int binarySearch(T element);
    public void sort();
    public DataStructure<T> sorted();
}
