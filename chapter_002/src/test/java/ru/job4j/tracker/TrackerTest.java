package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteThenTrueAndNotFindItemAndNotNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        boolean result = tracker.delete(item2.getId());
        assertThat(result, is(true));
        assertEquals(null, tracker.findById(item2.getId()));
        Item item5 = new Item("test5");
        tracker.add(item5);
        List<Item> items = tracker.findAll();
        result = true;
        for (Item item : items) {
            if (item == null) {
                result = false;
                break;
            }
        }
        assertThat(result, is(true));

    }

    @Test
    public void whenDeleteThenFalseAndNotFindItemAndNotNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Item item5 = new Item("test5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        boolean result = tracker.delete(item5.getId());
        assertThat(result, is(false));
        assertEquals(null, tracker.findById(item5.getId()));
        List<Item> items = tracker.findAll();
        result = true;
        for (Item item : items) {
            if (item == null) {
                result = false;
                break;
            }
        }
        assertThat(result, is(true));

    }

    @Test
    public void whenFindByIdThenFindItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Item item5 = new Item("test5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        Item foundItem = tracker.findById(item2.getId());
        assertThat(item2.getId(), is(foundItem.getId()));
    }

    @Test
    public void whenFindByIdThenNotFindItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Item item5 = new Item("test5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        Item foundItem = tracker.findById("000000000000000000");
        boolean result = true;
        if (foundItem != null) {
            result = false;
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenFindByNameThenFindItemArrays() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test2");
        Item item4 = new Item("test2");
        Item item5 = new Item("test5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        List<Item> items = tracker.findByName(item2.getName());
        boolean result = true;
        for (Item item : items) {
            if (!item.getName().equals(item2.getName())) {
                result = false;
                break;
            }
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenFindByNameThenNotFindItemArrays() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test2");
        Item item4 = new Item("test2");
        Item item5 = new Item("test5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        List<Item> items = tracker.findByName("not test");
        boolean result = true;
        for (Item item : items) {
            if (!item.getName().equals(item2.getName())) {
                result = false;
                break;
            }
        }

        assertThat(result, is(true));
    }

    @Test
    public void whenFindAllThenFindAllWithoutNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test2");
        Item item4 = new Item("test2");
        Item item5 = new Item("test5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        List<Item> items = tracker.findAll();
        assertThat(items.size(), is(5));
    }
}
