package com.analuciabolico.sgtccapi.v1.interest_areas.services.implementations;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.interest_areas.dtos.Interest_AreaRequest;
import com.analuciabolico.sgtccapi.v1.interest_areas.model.Interest_Area;
import com.analuciabolico.sgtccapi.v1.interest_areas.repository.Interest_AreaRepository;
import com.analuciabolico.sgtccapi.v1.interest_areas.services.interfaces.IInterest_AreaService;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class Interest_AreaService implements IInterest_AreaService {
    private final Interest_AreaRepository interest_AreaRepository;

    @Override
    public ResourceCreated save(Interest_AreaRequest interest_AreaRequest) {
        return new ResourceCreated(interest_AreaRepository.save(interest_AreaRequest.convertToInterest_Area()).getId());
    }

    @Override
    public Interest_Area findById(Long id) {
        return interest_AreaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Interest_Area> findAll(Sort sort) {
        return interest_AreaRepository.findAll(sort);
    }
}
