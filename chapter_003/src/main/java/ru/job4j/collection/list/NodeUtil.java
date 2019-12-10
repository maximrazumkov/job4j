package ru.job4j.collection.list;

public class NodeUtil {

    public static boolean hasCycle(Node first) {
        boolean isCycle = false;
        Node current = first;
        SimpleQueueFIFO<Node> queue = new SimpleQueueFIFO<>();
        while ((!isCycle) && (current != null)) {
            queue.push(current);
            current = current.next;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                if (node == current) {
                    isCycle = true;
                    break;
                }
                queue.push(node);
            }
        }
        return isCycle;
    }
}
