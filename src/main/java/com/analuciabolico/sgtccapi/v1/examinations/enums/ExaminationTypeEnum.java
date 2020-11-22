package com.analuciabolico.sgtccapi.v1.examinations.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExaminationTypeEnum {
    PRE_EVALUATION("Pré Avaliação"),
    FINAL_EVALUATION("Avaliação Final");

    private final String key;
}
