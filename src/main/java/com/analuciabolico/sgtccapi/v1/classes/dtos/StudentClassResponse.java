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
    /**
     *
     */
    private static final long serialVersionUID = -4337223303171074210L;
    private String semester;
    private String name;
    private String student;
    private Double average;
}
