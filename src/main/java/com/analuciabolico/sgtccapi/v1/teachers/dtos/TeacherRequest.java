package com.analuciabolico.sgtccapi.v1.teachers.dtos;

import java.time.LocalDateTime;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {
    private String name;
    private String cpf;
    private String email;
    private String registration;
    private String phone;

    public Teacher convertToTeacher() {
        return  Teacher.builder()
                .id(null).name(this.name).cpf(this.cpf).email(this.email).createdAt(LocalDateTime.now())
                .registration(this.registration).phone(this.phone).build();
    }
}
