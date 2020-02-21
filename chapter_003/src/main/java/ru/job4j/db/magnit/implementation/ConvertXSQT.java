package ru.job4j.db.magnit.implementation;

import ru.job4j.db.magnit.interfaces.Converter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;

public class ConvertXSQT implements Converter<File> {

    private File scheme;
    private File dest;

    public ConvertXSQT(File scheme, File dest) {
        this.scheme = scheme;
        this.dest = dest;
    }

    @Override
    public void convert(File value) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(value), new StreamResult(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
