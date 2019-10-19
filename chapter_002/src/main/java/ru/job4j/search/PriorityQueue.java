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
        int count = tasks.size();
        if (tasks.isEmpty()) {
            tasks.add(task);
        }
        for (int i = 0; i < count; ++i) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
