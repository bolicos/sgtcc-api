package com.analuciabolico.sgtccapi.v1.interest_areas.model;

import io.micrometer.core.lang.NonNull;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Interest_Area implements Serializable {

    @Builder
    public Interest_Area(@NonNull String name, @NonNull LocalDateTime createdAt, @NonNull String description, @NonNull Long id) {
        this.name = name;
        this.createdAt = createdAt;
        this.description = description;
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_INTEREST_AREAS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    private String description;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @lombok.NonNull
    @Column(nullable = false, columnDefinition = "timestamp")
    protected LocalDateTime createdAt;

}
