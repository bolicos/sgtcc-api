package com.analuciabolico.sgtccapi.v1.interest_areas.dtos;

import com.analuciabolico.sgtccapi.v1.interest_areas.model.Interest_Area;

import java.io.Serializable;

public class Interest_AreaRequest implements Serializable {
    private String name;
    private String createdAt;
    private String description;

    public Interest_Area convertToInterest_Area() {
        return  Interest_Area.builder()
                .id(null).description(this.description).name(this.name).createdAt(this.createdAt)
                .build();
    }
}
