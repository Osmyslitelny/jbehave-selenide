package steps;

import com.epam.e3s.test.ui.framework.utils.jbehave.CurrentJbehaveContextInfo;
import com.epam.e3s.test.ui.framework.webdriver.selenoid.SelenoidPropertiesConfig;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Component;
//

//import org.apache.log4j.LogManager;


@Component
public class MySteps {

//    private static final org.apache.log4j.Logger logger2 = LogManager.getLogger("HelloWorld");

    @Autowired
    Environment environment;

    @Given("test test")
    public void one01(){
//        System.out.println("=============\n" + environment.getActiveProfiles("selenoid.test"));
        System.out.println("=============\n" + System.getProperty("selenoid.test","default"));
//        System.setProperty("selenoid.test","oooo");
//        System.out.println("=============\n" + environment.getProperty("selenoid.test"));
//        System.out.println("=============\n" + System.getProperty("selenoid.test","default"));
//
//        System.out.println("=============\n" + String.valueOf(new SelenoidPropertiesConfig().getstringValue()));
//        System.getProperties().entrySet().forEach(it -> {
//            System.out.println(it.getKey() + " " + it.getValue());
//        });
    }

    @Given("test0 '$qwert'")
    public void one0(String qwert){
        System.out.println(qwert);
//        logger.info("This is an information message");
//        logger2.info("This is an information message");
////        logger.error("this is a error message");
////        logger.error("this is a error message");
//        logger2.warn(logger.getClass() + " this is a warning message");
    }

    @Given("test01 '$qwert'")
    public void one1(String qwert){
        System.out.println(qwert);
//        logger.info("This is an information message");
//        logger2.info("This is an information message");
////        logger.error("this is a error message");
////        logger.error("this is a error message");
//        logger2.warn(logger.getClass() + " this is a warning message");
    }


    @Given("test1")
    public void one(){
        System.out.println("One");
    }

    @When("test2")
    public void two(){
        System.out.println("Two");
    }

    @Then("test3")
    public void three(){
        System.out.println("Three");
    }

    @Given("a stock of symbol $symbol and a threshold of $threshold")
    public void aStock(@Named("symbol") String aSymbol, @Named("threshold") double aThreshold) {
        System.out.println(aSymbol);
    }
}
