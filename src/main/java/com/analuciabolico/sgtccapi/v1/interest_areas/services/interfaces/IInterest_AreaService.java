package com.analuciabolico.sgtccapi.v1.interest_areas.services.interfaces;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.interest_areas.dtos.InterestAreaRequest;
import com.analuciabolico.sgtccapi.v1.interest_areas.model.InterestArea;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IInterest_AreaService {
    ResourceCreated save(InterestAreaRequest interestAreaRequest);

    Interest_Area findById(Long id);

    List<Interest_Area> findAll(Sort sort);
}
