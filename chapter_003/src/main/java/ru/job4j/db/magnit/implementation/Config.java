package ru.job4j.db.magnit.implementation;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public void init(String appProperties) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(appProperties)) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
