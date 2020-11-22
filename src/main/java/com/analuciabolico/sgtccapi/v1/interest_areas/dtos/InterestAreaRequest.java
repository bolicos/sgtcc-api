package com.analuciabolico.sgtccapi.v1.interest_areas.dtos;

import com.analuciabolico.sgtccapi.v1.interest_areas.model.InterestArea;

import java.io.Serializable;
import java.time.LocalDateTime;

public class InterestAreaRequest implements Serializable {
    private String name;
    private String description;

    public InterestArea convertToInterestArea() {
        return  InterestArea.builder()
                .id(null).description(this.description).name(this.name).createdAt(LocalDateTime.now())
                .build();
    }
}
