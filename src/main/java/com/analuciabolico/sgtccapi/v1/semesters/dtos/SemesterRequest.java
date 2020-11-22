package com.analuciabolico.sgtccapi.v1.semesters.dtos;

import java.io.Serializable;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SemesterRequest implements Serializable {
    private String name;


    public Semester convertToSemester() {
        return  Semester.builder().id(null).name(this.name).build();
    }
}
