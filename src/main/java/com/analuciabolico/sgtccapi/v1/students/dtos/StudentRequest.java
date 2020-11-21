package com.analuciabolico.sgtccapi.v1.students.dtos;

import com.analuciabolico.sgtccapi.v1.students.model.Student;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentRequest implements Serializable {
    private String name;
    private String cpf;
    private String email;
    private String registration;
    private String phone;

    public Student convertToStudent() {
        return  Student.builder()
                    .id(null).name(this.name).cpf(this.cpf).email(this.email).createdAt(LocalDateTime.now())
                    .registration(this.registration).phone(this.phone).build();
    }
}
