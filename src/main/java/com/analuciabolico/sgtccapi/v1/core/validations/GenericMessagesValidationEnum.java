package com.analuciabolico.sgtccapi.v1.core.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenericMessagesValidationEnum {
    REQUIRED_FIELD("javax.validation.constraints.NotNull.message"),
    INVALID_EMAIL("invalidEmail.message"),
    INVALID_CPF("invalidCpf.message"),
    GENERIC_ERROR("genericError.message"),
    ENTITY_NOT_FOUND("entityNotFound.message");

    private final String key;
}
