package com.xeneta.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
    private static boolean root = false;

    public static Logger getLogger(Class clas) {
        if (root)
            return Logger.getLogger(clas);
        String log4jFilePath = System.getProperty("user.dir") + "/log4j.properties";
        PropertyConfigurator.configure(log4jFilePath);
        root = true;
        return Logger.getLogger(clas);
    }
}
