package ru.job4j.db.magnit.implementation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.job4j.db.magnit.models.Entry;

import java.util.LinkedList;
import java.util.List;

public class SaxHandler extends DefaultHandler {

    private List<Entry> entries = new LinkedList<>();

    public List<Entry> getResult() {
        return entries;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("entry")) {
            String val = attributes.getValue("href");
            if (val != null) {
                entries.add(new Entry(Integer.parseInt(val)));
            }
        }
    }
}
