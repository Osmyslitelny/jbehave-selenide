package com.epam.e3s.test.ui.framework.webdriver.selenoid;

public enum SelenideProperty {

    SELENIDE_BROWSER("selenide.browser"),
    SELENIDE_HEADLESS("selenide.headless"),
    SELENIDE_REMOTE("selenide.remote"),
    SELENIDE_BROWSER_SIZE("selenide.browserSize"),
    SELENIDE_BROWSER_VERSION("selenide.browserVersion"),
    SELENIDE_BROWSER_POSITION("selenide.browserPosition"),
    SELENIDE_START_MAXIMIZED("selenide.startMaximized"),
    SELENIDE_DRIVER_MANAGMENT_ENABLE("selenide.driverManagerEnabled"),
    SELENIDE_BROWSER_BINARY("selenide.browserBinary"),
    SELENIDE_PAGE_LOAD_STRATEGY("selenide.pageLoadStrategy"),
    SELENIDE_BASE_URL("selenide.baseUrl"),
    SELENIDE_TIMEOUT("selenide.timeout"),
    SELENIDE_POLLING_INTERVAL("selenide.pollingInterval"),
    SELENIDE_HOLD_BROWSER_OPEN("selenide.holdBrowserOpen"),
    SELENIDE_REOPEN_BROWSER_ON_FAIL("selenide.reopenBrowserOnFail"),
    SELENIDE_CLICK_VIA_JS("selenide.clickViaJs"),
    SELENIDE_SCREENSHOTS("selenide.screenshots"),
    SELENIDE_SAVE_PAGE_SOURCE("selenide.savePageSource"),
    SELENIDE_REPORTS_FOLDER("selenide.reportsFolder"),
    SELENIDE_REPORTS_URL("selenide.reportsUrl"),
    SELENIDE_FAST_SET_VALUE("selenide.fastSetValue"),
    SELENIDE_VERSATIL_SET_VALUE("selenide.versatileSetValue"),
    SELENIDE_FILE_DOWNLOAD("selenide.fileDownload"),
    SELENIDE_PROXY_ENABLE("selenide.proxyEnabled"),
    SELENIDE_PROXE_HOST("selenide.proxyHost"),
    SELENIDE_PROXY_PORT("selenide.proxyPort");

    private String propertyName;

    private SelenideProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getName() {
        return this.propertyName;
    }

}
