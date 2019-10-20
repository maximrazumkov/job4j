package ru.job4j.search;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        boolean flag = tasks.isEmpty();
        if (flag) {
            tasks.add(task);
        }
        int i = 0;
        for (Task t : tasks) {
            if (task.getPriority() < t.getPriority()) {
                tasks.add(i, task);
                flag = false;
                break;
            }
            ++i;
        }
        if (flag) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
