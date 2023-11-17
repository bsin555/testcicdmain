package com.enums;

/*
    Contains references for all the property files across the modules. Returns the respective filepath based on the getFilePath method
 */
public enum PropertyFileReference {

    //Property file path for UI
    COMMON_APPLICATION_FILE_NAME_UI("src/test/resources/config/ui/commonapplicationUI.properties");

    String filePath;

    PropertyFileReference(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }
}
