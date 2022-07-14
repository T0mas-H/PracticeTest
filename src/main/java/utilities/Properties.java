package utilities;

import java.io.InputStream;

public class Properties {
    private static java.util.Properties properties;
    public static final String filename = "config.properties";

    public static String loadProp(String key) {

        try {
            loadProps();
            return properties.getProperty(key);
        }
        catch (Exception e) {
            System.out.println("Exception occurred while loading property: ".concat(key));
            e.printStackTrace();
        }
        return "";
    }

    private static void loadProps() {

        try {
            InputStream input = Properties.class.getClassLoader()
                    .getResourceAsStream(filename);
            properties = new java.util.Properties();
            properties.load(input);
        }
        catch(Exception e) {
            System.out.println("Exception occurred while loading properties file: ".concat(filename));
            e.printStackTrace();
        }
    }
}
