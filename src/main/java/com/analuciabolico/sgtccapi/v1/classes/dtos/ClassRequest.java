package com.analuciabolico.sgtccapi.v1.classes.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
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
    private String name;
    private Set<Student> students;
    private Teacher teacher;
    private Semester semester;


    public Class convertToClass() {
        return  Class.builder()
                .id(null).name(this.name).teacher(this.teacher).createdAt(LocalDateTime.now()).semester(this.semester)
                .build();
    }
}
