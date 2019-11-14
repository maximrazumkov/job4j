package ru.job4j.generic;

public class RoleStore extends AbstractStore {
    public RoleStore(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }

    public void add(Role model) {
        super.add(model);
    }

    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public Role findById(String id) {
        return (Role) super.findById(id);
    }
}
