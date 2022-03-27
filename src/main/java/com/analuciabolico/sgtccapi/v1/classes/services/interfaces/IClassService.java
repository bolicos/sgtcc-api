package com.analuciabolico.sgtccapi.v1.classes.services.interfaces;

import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.classes.dtos.ClassRequest;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;

public interface IClassService {
    ResourceCreated save(ClassRequest classRequest);
    Class findById(Long id);
    List<Class> findAll(Sort sort);
}
