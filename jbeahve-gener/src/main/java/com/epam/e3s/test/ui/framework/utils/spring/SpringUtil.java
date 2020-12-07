package com.epam.e3s.test.ui.framework.utils.spring;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Yahor_Alve on 6/19/2015.
 */
@Component
public class SpringUtil {

    private static ApplicationContext context;

    @Autowired
    public SpringUtil(ApplicationContext context) {
        SpringUtil.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> classObj) {
        return (T) getContext().getAutowireCapableBeanFactory().getBean(classObj.getName());
    }

    public static <T> T getBean(String name) {
        return (T) getContext().getAutowireCapableBeanFactory().getBean(name);
    }

    public static boolean isBeanPresent(String name) {
        return getContext().getAutowireCapableBeanFactory().containsBean(name);
    }

    public static void addBean(Class beanClass) {
        addBean(beanClass.getName(), beanClass);
    }

    public static void addBean(String beanName, Class beanClass) {
        addBean(beanName, beanClass, Collections.emptyMap());
    }

    public static void addBean(String beanName, Class beanClass, Map<String, Object> fieldValues) {
        AutowireCapableBeanFactory factory = getContext().getAutowireCapableBeanFactory();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
        if (isBeanPresent(beanName)) {
            registry.removeBeanDefinition(beanName);
        }

        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(beanClass);

        MutablePropertyValues mpv = new MutablePropertyValues();
        fieldValues.entrySet().stream().forEach(it -> {
            mpv.add(it.getKey(), it.getValue());
        });

        gbd.setPropertyValues(mpv);

        registry.registerBeanDefinition(beanName, gbd);
    }


}
