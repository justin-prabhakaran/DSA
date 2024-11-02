package org.justinprabhakaran;

import java.util.List;

public interface DataStructure<T> {

    public void addElement(T element);
    public void removeElementAt(int index);
    public void removeElement(T element);
    public void printDataStructure();
    public List<T> toList();

}
