package ru.job4j.collection.Collections.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeUtilTest {

    @Test
    public void whenLinckedListIsNotCycleBecauseOneElement() {
        Node first = new Node(1);
        assertThat(NodeUtil.hasCycle(first), is(false));
    }

    @Test
    public void whenLinckedListIsNotCycleBecauseEmptyList() {
        Node first = null;
        assertThat(NodeUtil.hasCycle(first), is(false));
    }

    @Test
    public void whenLinckedListIsNotCycle() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(NodeUtil.hasCycle(first), is(false));
    }

    @Test
    public void whenLinckedListIsCycleFirstElement() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(NodeUtil.hasCycle(first), is(true));
    }

    @Test
    public void whenLinckedListIsCycleMiddleElement() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertThat(NodeUtil.hasCycle(first), is(true));
    }
}
