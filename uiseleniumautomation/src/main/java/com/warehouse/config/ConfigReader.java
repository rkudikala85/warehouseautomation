package com.warehouse.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static final Properties props = new Properties();

    static {
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            System.out.println("Loading config file from: " + path);
            props.load(fis);

            // Optional: print all loaded properties
            for (String key : props.stringPropertyNames()) {
                System.out.println(key + " = " + props.getProperty(key));
            }

        } catch (IOException e) {
            System.err.println("Failed to load config.properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
