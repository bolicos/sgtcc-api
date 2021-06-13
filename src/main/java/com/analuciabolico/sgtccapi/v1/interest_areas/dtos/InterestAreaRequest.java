package com.analuciabolico.sgtccapi.v1.interest_areas.dtos;

import com.analuciabolico.sgtccapi.v1.interest_areas.model.InterestArea;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterestAreaRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -160029278070696554L;
    private String name;
    private String description;

    public InterestArea convertToInterestArea() {
        return  InterestArea.builder()
                .id(null).description(this.description).name(this.name).createdAt(LocalDateTime.now())
                .build();
    }
}
