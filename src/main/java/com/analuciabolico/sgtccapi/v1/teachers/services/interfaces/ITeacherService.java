package com.analuciabolico.sgtccapi.v1.teachers.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.teachers.dtos.TeacherRequest;
import com.analuciabolico.sgtccapi.v1.teachers.dtos.TeacherTitleResponse;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

public interface ITeacherService {
    ResourceCreated save(TeacherRequest teacherRequest);

    Teacher findById(Long id);

    List<Teacher> findAll(Sort sort);

    TeacherTitleResponse findTitleByTeacher(Long id);
}
