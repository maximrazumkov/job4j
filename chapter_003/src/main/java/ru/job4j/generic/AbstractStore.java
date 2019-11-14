package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<Base> {
    private final SimpleArray<Base> simpleArray;

    public AbstractStore(SimpleArray<Base> simpleArray) {
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
