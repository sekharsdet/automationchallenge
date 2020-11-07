package com.xeneta.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFormProperties {
    private static Properties config;

    /**
     * Keep read logic in static block, to access the data fast
     */
    static {
        try {
            String configPath = System.getProperty("user.dir") + "/config.properties";
            FileInputStream input = new FileInputStream(configPath);
            config = new Properties();
            config.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }

    }

    /**
     * This method returns property value from config.properties file
     *
     * @param propertyName property name
     * @return property value
     */
    public static String getProperty(String propertyName) {
        return config.getProperty(propertyName);
    }
}
