package com.ant.problemSolvingPractice.algoExpert.linkedList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class removeDuplicationFromLinkedListTest {
    @Test
    public void TestCase1() {
        RemoveDuplicationFromLinkedList.LinkedList input = new RemoveDuplicationFromLinkedList.LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));
        RemoveDuplicationFromLinkedList.LinkedList output = new RemoveDuplicationFromLinkedList().removeDuplicatesFromLinkedList(input);
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    public RemoveDuplicationFromLinkedList.LinkedList addMany(RemoveDuplicationFromLinkedList.LinkedList ll, List<Integer> values) {
        RemoveDuplicationFromLinkedList.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new RemoveDuplicationFromLinkedList.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(RemoveDuplicationFromLinkedList.LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        RemoveDuplicationFromLinkedList.LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }
}