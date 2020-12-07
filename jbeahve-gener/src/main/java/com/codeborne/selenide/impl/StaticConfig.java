package com.codeborne.selenide.impl;

import com.codeborne.selenide.*;
import org.openqa.selenium.MutableCapabilities;

public class StaticConfig implements Config {

    private static ThreadLocal<SelenideConfig> threadLocalConfig = ThreadLocal.withInitial(() -> new SelenideConfig());

    public static SelenideConfig get() {
        return threadLocalConfig.get();
    }

    @Override
    public String browser() {
        return threadLocalConfig.get().browser();
    }

    @Override
    public boolean headless() {
        return threadLocalConfig.get().headless();
    }

    @Override
    public String remote() {
        return threadLocalConfig.get().remote();
    }

    @Override
    public String browserSize() {
        return threadLocalConfig.get().browserSize();
    }

    @Override
    public String browserVersion() {
        return threadLocalConfig.get().browserVersion();
    }

    @Override
    public String browserPosition() {
        return threadLocalConfig.get().browserPosition();
    }

    @Override
    public boolean startMaximized() {
        return threadLocalConfig.get().startMaximized();
    }

    @Override
    public boolean driverManagerEnabled() {
        return threadLocalConfig.get().driverManagerEnabled();
    }

    @Override
    public String browserBinary() {
        return threadLocalConfig.get().browserBinary();
    }

    @Override
    public String pageLoadStrategy() {
        return threadLocalConfig.get().pageLoadStrategy();
    }

    @Override
    public long pageLoadTimeout() {
        return threadLocalConfig.get().pageLoadTimeout();
    }

    @Override
    public MutableCapabilities browserCapabilities() {
        return threadLocalConfig.get().browserCapabilities();
    }

    @Override
    public String baseUrl() {
        return threadLocalConfig.get().baseUrl();
    }

    @Override
    public long timeout() {
        return threadLocalConfig.get().timeout();
    }

    @Override
    public long pollingInterval() {
        return threadLocalConfig.get().pollingInterval();
    }

    @Override
    public boolean holdBrowserOpen() {
        return threadLocalConfig.get().holdBrowserOpen();
    }

    @Override
    public boolean reopenBrowserOnFail() {
        return threadLocalConfig.get().reopenBrowserOnFail();
    }

    @Override
    public boolean clickViaJs() {
        return threadLocalConfig.get().clickViaJs();
    }

    @Override
    public boolean screenshots() {
        return threadLocalConfig.get().screenshots();
    }

    @Override
    public boolean savePageSource() {
        return threadLocalConfig.get().savePageSource();
    }

    @Override
    public String reportsFolder() {
        return threadLocalConfig.get().reportsFolder();
    }

    @Override
    public String downloadsFolder() {
        return threadLocalConfig.get().downloadsFolder();
    }

    @Override
    public String reportsUrl() {
        return threadLocalConfig.get().reportsUrl();
    }

    @Override
    public boolean fastSetValue() {
        return threadLocalConfig.get().fastSetValue();
    }

    @Override
    public boolean versatileSetValue() {
        return threadLocalConfig.get().versatileSetValue();
    }

    @Override
    public SelectorMode selectorMode() {
        return threadLocalConfig.get().selectorMode();
    }

    @Override
    public AssertionMode assertionMode() {
        return threadLocalConfig.get().assertionMode();
    }

    @Override
    public FileDownloadMode fileDownload() {
        return threadLocalConfig.get().fileDownload();
    }

    @Override
    public boolean proxyEnabled() {
        return threadLocalConfig.get().proxyEnabled();
    }

    @Override
    public String proxyHost() {
        return threadLocalConfig.get().proxyHost();
    }

    @Override
    public int proxyPort() {
        return threadLocalConfig.get().proxyPort();
    }
}
