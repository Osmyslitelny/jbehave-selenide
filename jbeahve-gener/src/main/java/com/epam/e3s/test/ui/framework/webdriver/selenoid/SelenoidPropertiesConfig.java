package com.epam.e3s.test.ui.framework.webdriver.selenoid;

public enum SelenoidPropertiesConfig {

    BROWSER_NAME("browserName"),
    OPTIONS("selenoid:options"),
    SCREEN_RESOLUTION("screenResolution"),
    ENABLE_VNC("enableVNC"),
    ENABLE_VIDEO("enableVideo"),
    NAME("name"),
    VIDEO_NAME("videoName","videoNameDefault"),
    TIME_ZONE("timeZone"),
    APPLICATION_CONTAINERS("applicationContainers");

    private String name;
    private String defaultValue;

    SelenoidPropertiesConfig(String name) {
        this.name = name;
    }

    SelenoidPropertiesConfig(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String key() {
        return name;
    }

    public String value() {
        return defaultValue;
    }

}
