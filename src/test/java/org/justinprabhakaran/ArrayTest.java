package org.justinprabhakaran;



import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

    @org.junit.jupiter.api.Test
    public void addElementTest() {
        Array<Integer> arr = new Array<>(5);
        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        List<Integer> expected = List.of(1,2,3);
        List<Integer> actual = arr.toList();

        assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    public void removeElementAtTest() {
        Array<Integer> arr = new Array<>(5);
        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        arr.removeElementAt(1);

        List<Integer> expected = List.of(1,3);
        List<Integer> actual = arr.toList();

        assertEquals(expected,actual);
    }
}