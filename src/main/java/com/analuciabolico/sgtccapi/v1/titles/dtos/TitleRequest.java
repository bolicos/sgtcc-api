package com.analuciabolico.sgtccapi.v1.titles.dtos;

import com.analuciabolico.sgtccapi.v1.titles.model.Title;

import java.io.Serializable;

public class TitleRequest implements Serializable {
    private String description;
    private String nomenclature;
    private String type;

    public Title convertToTitle() {
        return  Title.builder()
                .id(null).description(this.description).nomenclature(this.nomenclature).type(this.type)
                .build();
    }

}
