package com.analuciabolico.sgtccapi.v1.semesters.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.semesters.dtos.SemesterRequest;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;

public interface ISemesterService {
    ResourceCreated save(SemesterRequest semesterRequest);

    Semester findById(Long id);

    List<Semester> findAll(Sort sort);
}
