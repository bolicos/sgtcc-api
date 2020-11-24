package com.analuciabolico.sgtccapi.v1.titles.services.interfaces;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.titles.dtos.TitleRequest;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ITitleService {
    ResourceCreated save(TitleRequest titleRequest);

    Title findById(Long id);

    List<Title> findAll(Sort sort);
}
