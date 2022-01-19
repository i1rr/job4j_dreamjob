package ru.job4j.dream.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Path {
    public static String candidatePic() {
        String path = null;
        try {
            FileReader reader = new FileReader(
                    "/Users/i1/IdeaProjects/job4j_dreamjob/src/main/resources/app.properties");
            Properties p = new Properties();
            p.load(reader);
            path = p.getProperty("candidatePicPath");
        } catch (IOException io) {
            io.printStackTrace();
        }
        return path;
    }
}
