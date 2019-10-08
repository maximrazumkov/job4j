package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Редактирование заявок
     * @param id уникальный идентификатор заявки
     * @param item отредактированая заявка
     * @return результат редактирования заявки (удалось отредактировать или не удалось)
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; ++i) {
            String itemId = this.items[i].getId();
            if (itemId.equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаление заявок
     * @param id уникальный идентификатор заявки
     * @return результат удаления заявки (удалось удалить или не удалось)
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; ++i) {
            String itemId = this.items[i].getId();
            if (itemId.equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - position);
                --position;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок
     * @return список всех заявок
     */
    public Item[] findAll() {
        Item[] newItem = new Item[position];
        System.arraycopy(items, 0, newItem, 0, position);
        return newItem;
    }

    /**
     * Получение списка по имени
     * @param key название заявки
     * @return список найденный заявок
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int i = 0; i < position; ++i) {
            if (this.items[i].getName().equals(key)) {
                ++count;
            }
        }
        Item[] newItem = new Item[count];
        int index = 0;
        for (int i = 0; i < position; ++i) {
            String itemName = this.items[i].getName();
            if (itemName.equals(key)) {
                newItem[index++] = this.items[i];
            }
        }
        return newItem;
    }

    /**
     * Получение заявки по id
     * @param id уникальный идентификатор заявки
     * @return найденная заявка
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < position; ++i) {
            String itemId = this.items[i].getId();
            if (itemId.equals(id)) {
                item = this.items[i];
                break;
            }
        }
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
