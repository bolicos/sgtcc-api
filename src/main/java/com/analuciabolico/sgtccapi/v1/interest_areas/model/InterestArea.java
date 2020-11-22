package com.analuciabolico.sgtccapi.v1.interest_areas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "INTEREST_AREAS")
@SequenceGenerator(name = "SEQ_INTEREST_AREAS", sequenceName = "SEQUENCE_INTEREST_AREAS", allocationSize = 1)
public class InterestArea implements Serializable {

    @Builder
    public InterestArea(@NonNull String name, @NonNull LocalDateTime createdAt, @NonNull String description, @NonNull Long id) {
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

    @NonNull
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime createdAt;
}
