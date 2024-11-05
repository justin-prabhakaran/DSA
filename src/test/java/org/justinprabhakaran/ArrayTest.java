package org.justinprabhakaran;



import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {

    @Test
    public void addElementTest() {
        Array<Integer> arr = new Array<>(5);
        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        List<Integer> expected = List.of(1,2,3);
        List<Integer> actual = arr.toList();

        assertEquals(expected,actual);

    }

    @Test
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

    @Test
    public void printDataStructureTest() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Array<Integer> arr = new Array<>(5);
        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        arr.printDataStructure();

        String expected = "[1, 2, 3]\n";
        assertEquals(expected,outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void linearSearchTest() {

        Array<Integer> arr = new Array<>(5);
        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        int output = arr.linearSearch(2);
        int expected = 1;

        assertEquals(output,expected);
    }

    @Test
    public void binarySearchTest() {
        Array<Integer> arr = new Array<>(6);
        arr.addElement(1);
        arr.addElement(6);
        arr.addElement(2);
        arr.addElement(5);
        arr.addElement(3);
        arr.addElement(4);

        int output = arr.binarySearch(5);
        // 1 ,2 ,3 ,4 , 5, 6
        int expected = 4;
        assertEquals(output,expected);
    }

    @Test
    public void sort() {
        Array<Integer> arr = new Array<>(10);

        arr.addElement(1);
        arr.addElement(10);
        arr.addElement(2);
        arr.addElement(9);
        arr.addElement(3);
        arr.addElement(8);
        arr.addElement(4);
        arr.addElement(7);
        arr.addElement(5);
        arr.addElement(6);

        arr.sort();
        List<Integer> output = arr.toList();
        List<Integer> expected = List.of(1,2,3,4,5,6,7,8,9,10);

        assertEquals(output,expected);
    }

    @Nested
    class AddElementAt{

        @Test
        void addElementAtFirst(){
           Array<Integer> arr = new Array<>(5);
           arr.addElement(2);
           arr.addElement(3);
           arr.addElement(4);

           arr.addElementAt(0,1);

           List<Integer> output = arr.toList();
           List<Integer> expected = List.of(1,2,3,4);

           assertEquals(expected,output);
        }

        @Test
        void addElementAtMid(){
            Array<Integer> arr = new Array<>(5);
            arr.addElement(1);
            arr.addElement(3);
            arr.addElement(4);

            arr.addElementAt(1,2);

            List<Integer> output = arr.toList();
            List<Integer> expected = List.of(1,2,3,4);

            assertEquals(expected,output);
        }

        @Test
        void addElementAtLast(){
            Array<Integer> arr = new Array<>(5);
            arr.addElement(1);
            arr.addElement(2);
            arr.addElement(3);

            arr.addElementAt(3,4);

            List<Integer> output = arr.toList();
            List<Integer> expected = List.of(1,2,3,4);

            assertEquals(expected,output);
        }
    }
}