package ru.job4j.db.magnit.models;

import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

public class Entry {
    private Integer field;

    public Entry() {
    }

    public Entry(Integer field) {
        this.field = field;
    }

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return Objects.equals(field, entry.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
