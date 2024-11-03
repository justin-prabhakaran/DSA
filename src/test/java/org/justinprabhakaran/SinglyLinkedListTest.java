package org.justinprabhakaran;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}