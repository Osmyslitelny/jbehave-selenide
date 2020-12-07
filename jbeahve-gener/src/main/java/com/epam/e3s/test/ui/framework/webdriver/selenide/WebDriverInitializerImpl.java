package com.epam.e3s.test.ui.framework.webdriver.selenide;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.StaticConfig;
import com.codeborne.selenide.impl.StaticDriver;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import com.epam.e3s.test.ui.framework.utils.jbehave.CurrentJbehaveContextInfo;
import com.epam.e3s.test.ui.framework.utils.spring.SpringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * This is E3sAbstractDriverFactory class.
 * Contains the same logic and base for factory structure like
 * {@link com.codeborne.selenide.webdriver.WebDriverFactory}.
 * We create the kind of duplicate logic case of all factory implementations from selenide_config
 * are private packed. That means we can't extend it.
 * {@link com.codeborne.selenide.webdriver.WebDriverFactory}.
 */
public class WebDriverInitializerImpl {

    private static final Log LOG = LogFactory.getLog(WebDriverInitializerImpl.class.getName());
    //
////    protected WebDriverBinaryManager webDriverBinaryManager = new WebDriverBinaryManager();
////
////    @Autowired
////    private SeleniumProxy seleniumProxy;
//
//
    @Autowired
    private CurrentJbehaveContextInfo currentJbehaveContextInfo;


    //    @Override
    public void initialize(String user) {
        try {
            if (StaticConfig.get().reportsFolder() == null) {
                StaticConfig.get().reportsFolder(
                        currentJbehaveContextInfo.getConfiguration().storyReporterBuilder().outputDirectory().getPath() +
                                "\\"
                                + currentJbehaveContextInfo.currentStory().getName().replaceAll("\\.story", ""));
            }
//
//            SelenideProxyServer selenideProxyServer = createProxy(user);
//            WebDriver webDriver = createWebDriver(selenideProxyServer);
//            changeDriverConfigCaseItStatic();
//
//            WebDriverRunner.setWebDriver(webDriver, selenideProxyServer);
//
//            postCreatingDriverStep();
        } catch (Exception e) {
            LOG.error("WebDriver: [" + StaticConfig.get().browser() + "] was not initialized.\n", e);
            throw new RuntimeException("WebDriver: [" + StaticConfig.get().browser() + "] was not initialized.\n", e);
        }
    }
//
////    @Override
////    public void initialize() {
////        initialize(null);
////    }
//
//    private WebDriver createWebDriver(SelenideProxyServer proxy) throws IllegalArgumentException {
//        StaticConfig config = StaticConfig.get();
//
////        log.config("browser=" + config.browser());
////        log.config("browser.version=" + config.browserVersion());
////        log.config("remote=" + config.remote());
////        log.config("browserSize=" + config.browserSize());
////        log.config("startMaximized=" + config.startMaximized());
//
//        Browser browser = new Browser(config.browser(), config.headless());
//
//        if (config.driverManagerEnabled() && !config.isRemote()) {
//            webDriverBinaryManager.setupBinaryPath(browser);
//        }
//
//        E3sAbstractDriverFactory factory = config.isRemote()
//                ? config.getFactoryContainer().remoteFactory()
//                : config.getFactoryContainer().browserFactory();
//
//
//        WebDriver webdriver = factory.create(proxy);
//
//        logBrowserVersion(webdriver);
//        LOG.info("Selenide v. " + SelenideDriver.class.getPackage().getImplementationVersion());
//        logSeleniumInfo(config);
//        return webdriver;
//
//    }
//
//    private void postCreatingDriverStep() {
//        WebDriverRunner.getWebDriver().manage().window().setSize(
//                new Dimension(Integer.parseInt(StaticConfig.get().browserSizeWidth()), Integer.parseInt(StaticConfig.get().browserSizeHeight()))
//        );
//    }
//
//    private SelenideProxyServer createProxy(String user) {
//        if (!StaticConfig.get().proxyEnabled()){
//            return null;
//        }
//        if (StaticConfig.get().isRemote()) {
//            return seleniumProxy.startRestProxy();
//        } else {
//            return seleniumProxy.start(user);
//        }
//    }
//
////    private void mergeExtraCapability(MutableCapabilities baseCaps, MutableCapabilities addingCaps) {
////        if (baseCaps instanceof ChromeOptions && addingCaps.getCapability(ChromeOptions.CAPABILITY) != null) {
////            ((ChromeOptions) baseCaps).addArguments(
////                    (List) ((Map)addingCaps.asMap().get(ChromeOptions.CAPABILITY)).get("args"));
////        }
////        if (baseCaps instanceof FirefoxOptions && addingCaps.getCapability(FirefoxOptions.FIREFOX_OPTIONS) != null) {
////            ((FirefoxOptions) baseCaps).addArguments(
////                    (List) ((Map)addingCaps.asMap().get(FirefoxOptions.FIREFOX_OPTIONS)).get("args"));
////        }
////        baseCaps.merge(addingCaps);
////    }
//
//
////    public static class DelegateWebDriverNotFound extends RuntimeException {
////        public DelegateWebDriverNotFound() {
////            super("WebDriver has not been found for this thread.\n"
////                    + "Please verify you are using the correct WebDriverProvider, "
////                    + "with the appropriate credentials if using remote access, " +
////                    "e.g. to SauceLabs: -DSAUCE_USERNAME=xxxxxx " +
////                    "-DSAUCE_ACCESS_KEY=xxx-xxxx-xxxx-xxxx-xxx ");
////        }
////    }
//
//    protected void logSeleniumInfo(Config config) {
//        if (config.remote() == null) {
//            BuildInfo seleniumInfo = new BuildInfo();
//            LOG.info(
//                    "Selenium WebDriver v. " + seleniumInfo.getReleaseLabel() + " build time: " + seleniumInfo.getBuildTime());
//        }
//    }
//
//    protected void logBrowserVersion(WebDriver webdriver) {
//        if (webdriver instanceof HasCapabilities) {
//            Capabilities capabilities = ((HasCapabilities) webdriver).getCapabilities();
//            LOG.info("BrowserName=" + capabilities.getBrowserName() +
//                    " Version=" + capabilities.getVersion() + " Platform=" + capabilities.getPlatform());
//        } else {
//            LOG.info("BrowserName=" + webdriver.getClass().getName());
//        }
//    }
//
//    // I think if they do some refactoring we should be remove or change this step
//    // WebDriverRunner.staticSelenideDriver -> ThreadLocalSelenideDriver(StaticConfig,driverWithStaticConfig())
//    // May be it will be better for all framework to proxy Configuration.default
//    private void changeDriverConfigCaseItStatic(){
//        try {
////            System.out.println(Thread.currentThread().getId() + " right " + WebDriverRunner.getWebDriver().hashCode());
////            System.out.println(Thread.currentThread().getId() + " wrong " + WebDriverRunner.driver().config().hashCode());
//
//            //get staticSelenideDriver field
//            Field staticSelenideDriverField = WebDriverRunner.class.getDeclaredField("staticSelenideDriver");
//            staticSelenideDriverField.setAccessible(true);
//
//            //change config into staticSelenideDriver
//            Field selenideDriverConfigField = SelenideDriver.class.getDeclaredField("config");
//            selenideDriverConfigField.setAccessible(true);
//            SelenideDriver driverObject = (SelenideDriver)staticSelenideDriverField.get(null);
//
//            Config configProxy = (Config) Proxy.newProxyInstance(WebDriverRunner.class.getClassLoader(), new Class[]{Config.class},
//                    (proxy, method, args) -> method.invoke(StaticConfig.getConfigThreadPool().get(), args));
//            selenideDriverConfigField.set(driverObject, configProxy);
//
//            //get driver field from staticSelenideDriver
//            Field driverField = SelenideDriver.class.getDeclaredField("driver");
//            driverField.setAccessible(true);
//            StaticDriver driver = (StaticDriver)driverField.get(driverObject);
//            //change config into driver
//            Field staticDriverDriverField = StaticDriver.class.getDeclaredField("config");
//            staticDriverDriverField.setAccessible(true);
//            staticDriverDriverField.set(driver, configProxy);
//
//            //set false
//            driverField.setAccessible(false);
//            staticDriverDriverField.setAccessible(false);
//            selenideDriverConfigField.setAccessible(false);
//            staticSelenideDriverField.setAccessible(false);
//
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
////        field.set(null, newValue);
//    }
//
//

}