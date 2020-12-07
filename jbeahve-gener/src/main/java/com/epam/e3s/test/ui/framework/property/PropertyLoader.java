package com.epam.e3s.test.ui.framework.property;

import com.epam.e3s.test.ui.framework.utils.jbehave.CurrentJbehaveContextInfo;
import com.epam.e3s.test.ui.framework.webdriver.selenoid.SelenideProperty;
import com.epam.e3s.test.ui.framework.webdriver.selenoid.SelenoidPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PropertyLoader {

    private static Environment springEnvironment;

    @Autowired
    public PropertyLoader(Environment springEnvironment) {
        PropertyLoader.springEnvironment = springEnvironment;
    }

    public void loadRp() {
    }

    public void loadSelenide() {
    }

    public static void loadSelenoid() {
        Arrays.stream(SelenideProperty.values()).forEach(it -> {
            loadAndSet(it.getName());
        });
    }

    private static void loadAndSet(String name) {
        loadAndSet(name, null);
    }


    private static void loadAndSet(String name, String defaultValue) {
        if (System.getProperties().getProperty(name) != null) {
            return;
        } else {
            if (defaultValue == null) {
                if (springEnvironment.getProperty(name) != null) {
                    System.setProperty(name, springEnvironment.getProperty(name));
                }
            } else {
                System.setProperty(name, springEnvironment.getProperty(name, defaultValue));
            }
        }
    }


//    public static void setReportPortalProperties() {
//        for (ListenerProperty lp : ListenerProperty.values()) {
//            if (!lp.getPropertyName().contains("keystore")) {
//                if (!lp.toString().contains("PROXY") && !lp.toString().contains("OLD")) {
//                    if (lp.toString().equals("DESCRIPTION")) {
//                        System.setProperty(lp.getPropertyName(), propertyHolder.getValue(lp.getPropertyName()).replace(",", "\n"));
//                        continue;
//                    }
//                    System.setProperty(lp.getPropertyName(), propertyHolder.getValue(lp.getPropertyName()));
//                }
//            }
//        }
//    }
//

}
