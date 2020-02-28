package ru.job4j.db.magnit.implementation;

import ru.job4j.db.magnit.interfaces.Converter;
import ru.job4j.db.magnit.models.Entrys;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

public class StoreXml implements Converter<Entrys> {
    private String target;

    public StoreXml(String target) {
        this.target = target;
    }

    @Override
    public void convert(Entrys value) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            JAXBContext context = JAXBContext.newInstance(Entrys.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(value, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
