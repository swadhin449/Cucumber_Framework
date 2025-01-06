package org.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    public static String fetchBrowserPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\Cucumber_Framework\\src\\test\\resources\\browser_config.properties");
        Properties prop = new Properties();
        prop.load(file);

        return prop.get(key).toString();
    }
}
