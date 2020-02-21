package ru.job4j.db.magnit;

import ru.job4j.db.magnit.implementation.*;
import ru.job4j.db.magnit.interfaces.Converter;
import ru.job4j.db.magnit.interfaces.Parser;
import ru.job4j.db.magnit.interfaces.ServiceDB;
import ru.job4j.db.magnit.models.Entry;
import ru.job4j.db.magnit.models.Entrys;

import java.io.File;
import java.sql.Connection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        Config config = new Config();
        config.init("app.properties");
        Connection connection = new ConnectorSQLite(config).getConnection();
        ServiceDB serviceDB = new StoreSQL(connection);
        serviceDB.generate(10);
        List<Entry> entries = serviceDB.load();
        Converter<Entrys> converterXml = new StoreXml("./chapter_003/data/xml/magnit.xml");
        converterXml.convert(new Entrys(entries));
        Converter<File> converterXSL = new ConvertXSQT(
                new File("./chapter_003/data/magnit/schema.xsl"),
                new File("./chapter_003/data/xml/magnit2.XSTL")
        );
        converterXSL.convert(new File("./chapter_003/data/xml/magnit.xml"));
        Parser<File, List<Entry>> parser = new ParserXml();
        List<Entry> entriesResult = parser.parse(new File("./chapter_003/data/xml/magnit2.XSTL"));
        int sum = entriesResult.stream().map(entry -> entry.getField()).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
