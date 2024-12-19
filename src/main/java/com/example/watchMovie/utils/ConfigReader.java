package com.example.watchMovie.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties getPropertyObject() throws IOException {
        FileInputStream stream = new FileInputStream("E:\\watchMovie\\Config\\config.properties");
        Properties prop = new Properties();
        prop.load(stream);
        return prop;
    }

    public static String getUsername() throws IOException {
        return getPropertyObject().getProperty("username");
    }

    public static String getPassword() throws IOException {
        return getPropertyObject().getProperty("password");
    }

}
