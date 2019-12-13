package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {

    private SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();

    @Test
    public void whenAddNewElement() {
        assertThat(simpleHashMap.size(), is(0));
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.size(), is(1));
        assertThat(simpleHashMap.get("0"), is("Test1"));
    }

    @Test
    public void whenReresizeSimpleHashMap() {
        assertThat(simpleHashMap.size(), is(0));
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.insert("1", "Test2"), is(true));
        assertThat(simpleHashMap.insert("2", "Test3"), is(true));
        assertThat(simpleHashMap.insert("3", "Test4"), is(true));
        assertThat(simpleHashMap.insert("4", "Test5"), is(true));
        assertThat(simpleHashMap.insert("10", "Test6"), is(true));
        assertThat(simpleHashMap.size(), is(6));
        assertThat(simpleHashMap.get("0"), is("Test1"));
        assertThat(simpleHashMap.get("1"), is("Test2"));
        assertThat(simpleHashMap.get("2"), is("Test3"));
        assertThat(simpleHashMap.get("3"), is("Test4"));
        assertThat(simpleHashMap.get("4"), is("Test5"));
        assertThat(simpleHashMap.get("10"), is("Test6"));
    }

    @Test
    public void whenAddDoubleElement() {
        assertThat(simpleHashMap.size(), is(0));
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.insert("1", "Test2"), is(true));
        assertThat(simpleHashMap.insert("2", "Test3"), is(true));
        assertThat(simpleHashMap.insert("3", "Test4"), is(true));
        assertThat(simpleHashMap.insert("4", "Test5"), is(true));
        assertThat(simpleHashMap.insert("2", "Test6"), is(false));
    }

    @Test
    public void whenDeleteElement() {
        assertThat(simpleHashMap.size(), is(0));
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.insert("1", "Test2"), is(true));
        assertThat(simpleHashMap.insert("2", "Test3"), is(true));
        assertThat(simpleHashMap.insert("3", "Test4"), is(true));
        assertThat(simpleHashMap.insert("4", "Test5"), is(true));
        assertThat(simpleHashMap.insert("2", "Test6"), is(false));
        assertThat(simpleHashMap.size(), is(5));
        assertThat(simpleHashMap.insert("10", "Test6"), is(true));
        assertThat(simpleHashMap.delete("1"), is(true));
        assertThat(simpleHashMap.delete("1"), is(false));
        assertNull(simpleHashMap.get("1"));
    }

    @Test
    public void whenForEarchItr() {
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.insert("1", "Test2"), is(true));
        assertThat(simpleHashMap.insert("2", "Test3"), is(true));
        assertThat(simpleHashMap.insert("3", "Test4"), is(true));
        assertThat(simpleHashMap.insert("4", "Test5"), is(true));
        assertThat(simpleHashMap.insert("10", "Test6"), is(true));
        Iterator<SimpleHashMap.Entry<String, String>> itr = simpleHashMap.iterator();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenThrowNoSuchElementException() {
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.insert("1", "Test2"), is(true));
        assertThat(simpleHashMap.insert("2", "Test3"), is(true));
        assertThat(simpleHashMap.insert("3", "Test4"), is(true));
        Iterator<SimpleHashMap.Entry<String, String>> itr = simpleHashMap.iterator();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenThrowConcurrentModificationException() {
        assertThat(simpleHashMap.insert("0", "Test1"), is(true));
        assertThat(simpleHashMap.insert("1", "Test2"), is(true));
        assertThat(simpleHashMap.insert("2", "Test3"), is(true));
        assertThat(simpleHashMap.insert("3", "Test4"), is(true));
        Iterator<SimpleHashMap.Entry<String, String>> itr = simpleHashMap.iterator();
        itr.next();
        itr.next();
        simpleHashMap.insert("10", "Test1");
        itr.next();
    }

}
