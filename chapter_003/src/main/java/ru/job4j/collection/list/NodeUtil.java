package ru.job4j.collection.list;

public class NodeUtil {

    public static boolean hasCycle(Node first) {
        boolean result = true;
        if (first == null) {
            result = false;
        }
        Node tortoise = first;
        Node hare = first;
        while (result) {
            tortoise = tortoise.next;
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                result = false;
                break;
            }
            if ((tortoise == null) || (hare == null)) {
                result = false;
                break;
            }
            if (tortoise == hare) {
                result = true;
                break;
            }
        }
        return result;
    }
}
