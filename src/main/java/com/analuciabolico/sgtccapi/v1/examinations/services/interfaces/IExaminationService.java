package com.analuciabolico.sgtccapi.v1.examinations.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.examinations.dtos.ExaminationRequest;
import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;

public interface IExaminationService {

    ResourceCreated save(ExaminationRequest examinationRequest);

    Examination findById(Long id);

    List<Examination> findAll(Sort sort);
}
