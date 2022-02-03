package ru.job4j.dream.service;

import java.io.*;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Path {
    private static final Logger LOGGER = LoggerFactory.getLogger(Path.class.getName());

    public static String candidatePic() {
        String path = null;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try (InputStream is = cl.getResourceAsStream("app.properties")) {
            Properties p = new Properties();
            p.load(is);
            path = p.getProperty("candidatePicPath");
        } catch (IOException io) {
            LOGGER.error(io.getMessage(), io);
        }
        return path;
    }
}
