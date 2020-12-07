package com.epam.e3s.test.ui.framework.jbehave.steps;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.jbehave.core.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
*/

@Component
public class LifecycleSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleSteps.class);

//    private final WebDriverInitializer webDriverProvider;

//    public LifecycleSteps(WebDriverInitializer webDriverProvider) {
//        this.webDriverProvider = webDriverProvider;
//    }

//    @Autowired
//    private ContextVariableTestData contextVariableTestData;
//
//    @Autowired
//    private XmlTestData xmlTestData;
//
//    @Autowired
//    private JsonTestData jsonTestData;


    @BeforeStory
    public void beforeStory(@Named("testType") String testType, @Named("xmlFile") String xmlFile, @Named("user") String userXpath, @Named("jsonFile") String jsonFile) {
//        contextVariableTestData.setContextVariable("testType", null);
        if (testType == null || testType.isEmpty()) {
            throw new RuntimeException("Test type can not be null or empty. Please set '@testType <value>' in the 'Meta:' for story file.");
        }
        LOGGER.info("Test type: " + testType);

        if (xmlFile != null && !xmlFile.isEmpty()) {
            LOGGER.info("Xml test data file: " + xmlFile);
//            xmlTestData.setTestDataFile(xmlFile);
        }

        if (jsonFile != null && !jsonFile.isEmpty()) {
            LOGGER.info("Json test data file: " + jsonFile);
//            jsonTestData.init(jsonFile);
        }

        if ("ui".equalsIgnoreCase(testType)) {
            String a = "b";
//            if (!userXpath.isEmpty()) {
//                if (xmlFile == null || xmlFile.isEmpty()) {
//                    throw new RuntimeException("If you want to set User test data file path can not be null or empty. Please set '@xmlFile <value>' in the 'Meta:' for story file.");
//                }
//                (webDriverProvider).initialize(xmlTestData.getValue(userXpath));
            } else {
//                webDriverProvider.initialize();
            }
//            try {
////                WebDriverRunner.getWebDriver().manage().deleteAllCookies();
////            } catch (WebDriverException e) {
////                LOG.error("Error deleting Cokies. \n", e);
//            }
//        }

    }

    @AfterStory
    public void afterStory(@Named("testType") String testType) {
        if ("ui".equalsIgnoreCase(testType)) {
//            WebDriverRunner.getWebDriver().quit();
//            WebDriverRunner.closeWebDriver();
//            LOG.info("WebDriver is closing.");
        }
    }

    @BeforeStories
    public void beforeStories() {
        LOGGER.info("##################################################################");
        LOGGER.info("Startup properties: ");
//        LOGGER.info("	- Browser type: [" + E3sConfig.get().browser() + "]");
        LOGGER.info("##################################################################");
    }

    @AfterStories
    public void afterStories() {
        LOGGER.info("##################################################################");
        LOGGER.info("End. ");
        LOGGER.info("##################################################################");
    }
}
