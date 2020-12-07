package com.epam.e3s.test.ui.framework.jbehave.configuration.jbehave;

import com.epam.e3s.test.ui.framework.jbehave.configuration.spring.JbehaveStepsConfiguration;
import com.epam.e3s.test.ui.framework.jbehave.configuration.spring.PropertiesConfiguration;
import com.epam.e3s.test.ui.framework.jbehave.params.StringParameterConverter;
import com.epam.e3s.test.ui.framework.jbehave.steps.LifecycleSteps;
import com.epam.e3s.test.ui.framework.property.PropertyLoader;
import com.epam.e3s.test.ui.framework.utils.jbehave.CurrentJbehaveContextInfo;
import com.epam.e3s.test.ui.framework.utils.spring.SpringUtil;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import steps.MySteps;
import steps.MySteps2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class StoriesConfiguration extends JUnitStories {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoriesConfiguration.class);
    private ApplicationContext context;

    public StoriesConfiguration() {
    }

    @Override
    public void run() {
        super.run();
    }

    //ONE
    //story executor settings
    @Override
    public Configuration configuration() {
        context = new SpringApplicationContextFactory(springConfigurationNames()).createApplicationContext();

        PropertyLoader.loadSelenoid();


        Configuration configuration = new MostUsefulConfiguration();
        configuration.useParameterConverters(new ParameterConverters().addConverters(new StringParameterConverter()));
        //        Selenide.open();
        SpringUtil.getBean(CurrentJbehaveContextInfo.class).setConfiguration(configuration);
        return configuration;
    }

    //TWO
    //Candidate (deprecated) finder settings
    @Override
    public InjectableStepsFactory stepsFactory() {
        InjectableStepsFactory factory = null;
        int i = 1;
        switch (i) {
            case 0:
                factory = new InstanceStepsFactory(this.configuration(), new MySteps(), new MySteps2(), new LifecycleSteps());
                break;
            case 1:
//                ApplicationContext context = new SpringApplicationContextFactory(springConfigurationNames()).createApplicationContext();
//                ApplicationContext context = new SpringApplicationContextFactory("spring-root.xml").createApplicationContext();
                factory = new SpringStepsFactory(this.configuration(), context);
                break;
        }
        return factory;
    }

    /**
     * Override this method if you need custom spring configuration
     *
     * @return
     */
    protected String[] springConfigurationNames() {
        return new String[]{
                JbehaveStepsConfiguration.class.getName(),
                PropertiesConfiguration.class.getName()
        };
    }

    protected List<String> storyPaths() {
        String searchInDirectory = codeLocationFromClass(this.getClass()).getFile();
        String storiesPath = "**/stories/";//
        String searchSubfolders = "false";
        String storyFilter = System.getProperty("storyFilter", "false".equals(searchSubfolders) ? "*" : "**/*");

        List<String> singleStories = new ArrayList<>();
        List<String> folderStories = new ArrayList<>();

        Arrays.stream(storiesPath.split(",")).forEach(storyPath -> {
            if (storyPath.endsWith(".story")) {
                singleStories.add(storyPath);
            } else {
                folderStories.add(storyPath + storyFilter + ".story");
            }
        });
        List<String> includes = new ArrayList<String>() {
            {
                addAll(singleStories);
                addAll(folderStories);
            }
        };

//        LOG.info(new StringBuilder().append("Stories location path: ")
//                .append("\n        search directory -> ")
//                .append(searchInDirectory)
//                .append("\n        includes -> ")
//                .append(includes).toString());

        List<String> storyList = new StoryFinder().findPaths(searchInDirectory, includes, null);
        if (storyList.isEmpty()) {
            throw new RuntimeException("Folder with story is empty");
        }
        return storyList;
    }

}