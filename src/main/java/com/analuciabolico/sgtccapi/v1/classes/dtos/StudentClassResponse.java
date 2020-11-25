package com.analuciabolico.sgtccapi.v1.classes.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentClassResponse implements Serializable {
    private String semester;
    private String name;
    private String student;
    private Double average;
}
