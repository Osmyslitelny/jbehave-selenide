package com.epam.e3s.test.ui.framework.utils.jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.model.Story;

public class CurrentJbehaveContextInfo {

    private ThreadLocal<Story> currentStory = ThreadLocal.withInitial(() -> new Story());
    private Configuration configuration;

    public Story currentStory() {
        return currentStory.get();
    }

    public void currentStory(Story story) {
        currentStory.set(story);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
