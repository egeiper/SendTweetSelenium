package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    public static Properties getProps() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = null;
        String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        try {
            file = new FileInputStream(path);
            properties.load(file);

        } catch (Exception ignored) {
        } finally {
            if (file != null)
                file.close();
        }
        return properties;
    }
}
