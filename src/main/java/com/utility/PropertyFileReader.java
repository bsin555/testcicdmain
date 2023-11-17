package com.utility;

import com.enums.PropertyFileReference;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
    Responsible to read the properties based on file reference. If no reference is provided, it will try to read from the default common property file
 */
public class PropertyFileReader {
    private static Properties prop = new Properties();

    /*
        Mention all the property strings in this region
     */

    //Application Common properties
    public static final String MAX_TIMEOUT = PropertyFileReader.getPropertyByReference("max.timeout", PropertyFileReference.COMMON_APPLICATION_FILE_NAME_UI);
    public static final String PAGE_DOWN_SCRIPT = PropertyFileReader
            .getPropertyByReference("page.down.script", PropertyFileReference.COMMON_APPLICATION_FILE_NAME_UI);
    public static final String RANDOM_STRING_SEED_VALUE = PropertyFileReader.getPropertyByReference("random.string.seed.value", PropertyFileReference.COMMON_APPLICATION_FILE_NAME_UI);
    public static final String APP_URL = (System.getProperties().containsKey("AppURL") && (!System.getProperty("AppURL").equals("")))
            ? System.getProperty("AppURL") : PropertyFileReader.getPropertyByReference("application.url", PropertyFileReference.COMMON_APPLICATION_FILE_NAME_UI);
    public static final String BLANK_VALUE = PropertyFileReader.getPropertyByReference("blank.value", PropertyFileReference.COMMON_APPLICATION_FILE_NAME_UI);

    //Application Common properties API end

    public PropertyFileReader(PropertyFileReference propRef) {
        try {
            prop.load(new FileInputStream(propRef.getFilePath()));
        } catch (IOException e) {
            System.out.println(String.format("Error during loading Property File !%s", e.getMessage()));
        }
    }

    public static String getPropertyByReference(String key, PropertyFileReference propRef) {
        new PropertyFileReader(propRef);
        String property = prop.getProperty(key);
        return property != null ? property.trim() : property;
    }
}