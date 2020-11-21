package com.analuciabolico.sgtccapi.v1.students.dtos;

import com.analuciabolico.sgtccapi.v1.students.model.Student;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class StudentRequest implements Serializable {
    private String name;
    private String cpf;
    private String email;
    private Timestamp created_at;
    private String registration;
    private String phone;

    public Student convertToStudant() {
        return new Student(null, this.name, this.cpf, this.email, LocalDateTime.now(), this.registration, this.phone);
    }
}
