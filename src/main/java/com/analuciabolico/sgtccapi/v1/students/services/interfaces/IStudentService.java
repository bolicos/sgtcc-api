package com.analuciabolico.sgtccapi.v1.students.services.interfaces;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.students.dtos.StudentRequest;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IStudentService {
    ResourceCreated save(StudentRequest studentRequest);

    Student findById(Long id);

    List<Student> findAll(Sort sort);
}
