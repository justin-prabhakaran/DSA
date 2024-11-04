package org.justinprabhakaran;

import java.util.List;

public interface DataStructure<T> {
    public Object getData();
    public int indexOf(T element);
    public void addElement(T element);
    public void addElementAt(int index, T element);
    public void removeElementAt(int index);
    public void removeElement(T element);
    public void printDataStructure();
    public List<T> toList();
    public int size();
}
