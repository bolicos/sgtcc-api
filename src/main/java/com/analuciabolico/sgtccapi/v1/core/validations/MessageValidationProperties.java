package com.analuciabolico.sgtccapi.v1.core.validations;

import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;


public class MessageValidationProperties {

    private MessageValidationProperties() {
        throw new IllegalStateException("Utility class");
    }

    private static final String PROPERTIES = "validation-messages";
    private static final ResourceBundle bundle = getBundle(PROPERTIES);

    public static String getMessage(GenericMessagesValidationEnum enumProperties) {
        return bundle.getString(enumProperties.getKey());
    }
}
