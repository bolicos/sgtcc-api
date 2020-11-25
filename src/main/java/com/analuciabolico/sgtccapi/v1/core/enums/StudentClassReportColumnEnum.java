package com.analuciabolico.sgtccapi.v1.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StudentClassReportColumnEnum {
    SEMESTER("Semestre"),
    NAME("Nome"),
    STUDENT("Aluno"),
    AVERAGE("Media");

    private String key;
}
