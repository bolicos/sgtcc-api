package com.analuciabolico.sgtccapi.v1.interest_areas.dtos;

import com.analuciabolico.sgtccapi.v1.interest_areas.model.Interest_Area;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;

public class Interest_AreaRequest {
    private String name;
    private String createdAt;
    private String description;

    public Title convertToInterest_Area() {
        return  Interest_Area.builder()
                .id(null).description(this.description).name(this.name).createdAt(this.createdAt)
                .build();
    }
}
