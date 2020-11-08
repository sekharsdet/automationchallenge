package com.xeneta.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
    private static boolean root = false;

    /**
     * loggers can help
     *to debug the tests
     * @param loggerClass
     * @return logger
     */
    public static Logger getLogger(Class loggerClass) {
        if (root)
            return Logger.getLogger(loggerClass);
        String log4jFilePath = System.getProperty("user.dir") + "/log4j.properties";
        PropertyConfigurator.configure(log4jFilePath);
        root = true;
        return Logger.getLogger(loggerClass);
    }
}
