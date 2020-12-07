package com.epam.e3s.test.ui.framework.jbehave.configuration.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {
        "classpath:selenoid.properties",
        "classpath:selenide.properties",
        "classpath:www.properties",
        "reportportal.properties",
        "configuration_custom.properties",
        "configuration_ui_framework.properties"},
        ignoreResourceNotFound = true)
@ComponentScans({
        @ComponentScan("com.epam.e3s.test.ui.framework.property"),
        @ComponentScan("com.epam.e3s.test.ui.framework.utils.spring")
})
public class PropertiesConfiguration {
}
