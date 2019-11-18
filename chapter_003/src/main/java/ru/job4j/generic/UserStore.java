package ru.job4j.generic;

public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }

    public void add(User model) {
        super.add(model);
    }

    public boolean replace(String id, User model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public User findById(String id) {
        return (User) super.findById(id);
    }
}

