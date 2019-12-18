package ru.job4j.collection.Collections.generic;

public abstract class AbstractStore<T extends Base> implements Store<Base> {
    private final SimpleArray simpleArray;

    public AbstractStore(SimpleArray simpleArray) {
        this.simpleArray = simpleArray;
    }

    public void add(Base model) {
        simpleArray.add(model);
    }

    public boolean replace(String id, Base model) {
        boolean result = false;
        simpleArray.set(Integer.valueOf(id), model);
        return false;
    }

    public boolean delete(String id) {
        boolean result = false;
        simpleArray.get(Integer.valueOf(id));
        return false;
    }

    public T findById(String id) {
        return (T) simpleArray.get(Integer.valueOf(id));
    }
}
