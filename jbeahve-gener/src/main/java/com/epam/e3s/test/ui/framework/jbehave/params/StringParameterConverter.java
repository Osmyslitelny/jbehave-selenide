package com.epam.e3s.test.ui.framework.jbehave.params;

import org.jbehave.core.steps.ParameterConverters;

import java.lang.reflect.Type;

public class StringParameterConverter extends ParameterConverters.StringConverter {

    @Override
    public String convertValue(String value, Type type) {
        return super.convertValue(prefix(value), type);
    }

    private String prefix(String value) {
        if (value.startsWith("v{")){
            return "I'm start with V";
        } else if (value.startsWith("j{")) {
            return "I'm start with J";
        } else if (value.startsWith("r{")) {
            return "I'm start with R";
        } else {
            return value;
        }
    }
}