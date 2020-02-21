package ru.job4j.db.magnit.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(name = "entrys")
public class Entrys {
    private List<Entry> entry;

    public Entrys() {
    }

    public Entrys(List<Entry> entrys) {
        this.entry = entrys;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
