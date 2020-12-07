package com.epam.e3s.test.ui.framework.jbehave.configuration.spring;

import com.epam.e3s.test.ui.framework.utils.jbehave.CurrentJbehaveContextInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan("com.epam.e3s.test.ui.framework.jbehave.steps"),
        @ComponentScan("steps")
})
public class JbehaveStepsConfiguration {

    @Bean
    public CurrentJbehaveContextInfo currentJbehaveContextInfo() {
        return new CurrentJbehaveContextInfo();
    }

}
