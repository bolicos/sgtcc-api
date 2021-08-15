package com.analuciabolico.sgtccapi.v1.classes.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6755635889378816768L;
    private String name;
    private Long teacher;
    private Long semester;

    public Class convertToClass() {
        return  Class.builder()
                .id(null).name(this.name).teacher(new Teacher(this.teacher)).semester(new Semester(this.semester))
                .createdAt(LocalDateTime.now()).build();
    }
}
