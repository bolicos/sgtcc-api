package com.analuciabolico.sgtccapi.v1.core.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenericMessagesValidationEnum {
    REQUIRED_FIELD("javax.validation.constraints.not.null.message"),
    INVALID_EMAIL("invalid.email.message"),
    INVALID_CPF("invalid.cpf.message"),
    GENERIC_ERROR("generic.error.message"),
    ENTITY_NOT_FOUND("entity.not.found.message");

    private final String key;
}
