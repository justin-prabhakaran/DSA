package org.justinprabhakaran;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.dsig.SignedInfo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void addElementTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        List<Integer> output = list.toList();
        List<Integer> expected = List.of(1,2,3);

        assertEquals(expected,output);
    }

    @Nested
    class addElementAt{

        @Test
        void addEleementAtFirst(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.addElementAt(0,4);
            List<Integer> output = list.toList();
            List<Integer> expected = List.of(4,1,2,3);

            assertEquals(expected,output);
        }

        @Test
        void addElementAtMid() {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.addElementAt(1,4);
            List<Integer> output = list.toList();
            List<Integer> expected = List.of(1,4,2,3);

            assertEquals(expected,output);
        }

        @Test
        void addElementAtLast() {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.addElementAt(3,4);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(1,2,3,4);

            assertEquals(expected,output);
        }
    }

    @Nested
    class removeElement{

        @Test
        void removeElementFirst(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.removeElement(1);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(2,3);

            assertEquals(expected,output);
        }

        @Test
        void removeElementMid(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.removeElement(2);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(1,3);

            assertEquals(expected,output);
        }

        @Test
        void removeElementLast(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.removeElement(3);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(1,2);

            assertEquals(expected,output);
        }
    }

    @Nested
    class removeElementAt{

        @Test
        void removeElementAtFirst(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.removeElementAt(0);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(2,3);

            assertEquals(expected,output);
        }

        @Test
        void removeElementAtMid(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.removeElementAt(1);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(1,3);

            assertEquals(expected,output);
        }

        @Test
        void removeElementAtLast(){
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            list.addElement(1);
            list.addElement(2);
            list.addElement(3);

            list.removeElementAt(2);

            List<Integer> output = list.toList();
            List<Integer> expected = List.of(1,2);

            assertEquals(expected,output);
        }
    }

    @Test
    void linearSearchTest(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        int output = list.linearSearch(2);
        int expected = 1;

        assertEquals(expected,output);

    }

    @Test
    void printDataStructureTest(){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);

        list.printDataStructure();
        String output = outputStream.toString();
        String expected = "[1, 2, 3, 4]\n";

        assertEquals(expected,output);
        System.setOut(System.out);
    }

    @Test
    void sortTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addElement(1);
        list.addElement(10);
        list.addElement(2);
        list.addElement(9);
        list.addElement(3);
        list.addElement(8);
        list.addElement(4);
        list.addElement(7);
        list.addElement(5);
        list.addElement(6);

        list.sort();

        List<Integer> output = list.toList();
        List<Integer> expected = List.of(1,2,3,4,5,6,7,8,9,10);

        assertEquals(expected,output);
    }

    @Test
    void binarySearchTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addElement(1);
        list.addElement(10);
        list.addElement(2);
        list.addElement(9);
        list.addElement(3);
        list.addElement(8);
        list.addElement(4);
        list.addElement(7);
        list.addElement(5);
        list.addElement(6);

        //1 2 3 4 5 6 7 8 9 10
        int output = list.binarySearch(7);
        int expected = 6;

        assertEquals(expected,output);
    }

    @Test
    void getDataTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addElement(1);
        list.addElement(10);
        list.addElement(2);



    }
}