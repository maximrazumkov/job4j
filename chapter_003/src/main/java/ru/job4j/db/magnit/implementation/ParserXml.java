package ru.job4j.db.magnit.implementation;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import ru.job4j.db.magnit.interfaces.Parser;
import ru.job4j.db.magnit.models.Entry;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class ParserXml implements Parser<File, List<Entry>> {
    @Override
    public List<Entry> parse(File value) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            SaxHandler handler = new SaxHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new FileInputStream(value)));
            return handler.getResult();
        } catch (Exception e) {
            throw new RuntimeException("Не удалось распарсить xml", e);
        }
    }
}
