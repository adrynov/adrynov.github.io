package com.adrynov;

import com.adrynov.list.ListNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ListTests {

    /**
     * Given a singly-linked list, delete the middle node from the original list.
     * <p>
     * The list may contain any number of elements.
     */
    @Test
    void deleteMiddleOfSinglyLinkedList() {
        LinkedList<ListNode<String>> names = new LinkedList<>();

        var node6 = new ListNode<>("Mary", null);
        var node5 = new ListNode<>("Jamie", node6);
        var node4 = new ListNode<>("Taylor", node5);
        var node3 = new ListNode<>("Morgan", node4);
        var node2 = new ListNode<>("Sally", node3);
        var head = new ListNode<>("Andrei", node2);

        names.add(head);
        names.add(node2);
        names.add(node3);
        names.add(node4);
        names.add(node5);
        names.add(node6);

        assertNotNull(names);

        printList(head);
        System.out.println();

        deleteMiddle(names);

        printList(head);

        assertFalse(names.contains(node3));
    }

    private static <T> void deleteMiddle(LinkedList<ListNode<T>> names) {
        // remove the last element if the list is even
        if (names.size() % 2 == 0) {
            names.removeLast();
        }

        int middle = names.size() / 2;

        // update the next and previous pointers.
        var previous = names.get(middle - 1);
        var next = names.get(middle + 1);
        previous.setNext(next);

        // remove the middle element
        names.remove(middle);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.getValue() + " -> ");
            head = head.getNext();
        }
    }
}
