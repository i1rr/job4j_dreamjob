package ru.job4j.dream.service;

import java.io.*;
import java.util.Properties;

public class Path {
    public static String candidatePic() {
        String path = null;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try (InputStream is = cl.getResourceAsStream("app.properties")) {
            Properties p = new Properties();
            p.load(is);
            path = p.getProperty("candidatePicPath");
        } catch (IOException io) {
            io.printStackTrace();
        }
        return path;
    }
}
