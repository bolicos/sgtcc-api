package com.analuciabolico.sgtccapi.v1.semesters.dtos;

import java.io.Serializable;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -9200644404494336814L;
    private String name;


    public Semester convertToSemester() {
        return  Semester.builder().id(null).name(this.name).build();
    }
}
