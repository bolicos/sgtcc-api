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

import com.fasterxml.jackson.annotation.JsonFormat;

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

    /**
     *
     */
    private static final long serialVersionUID = -8127756949781906110L;

    @Builder
    public InterestArea(@NonNull String name, @NonNull LocalDateTime createdAt, @NonNull String description, Long id) {
        this.name = name;
        this.createdAt = createdAt;
        this.description = description;
        this.id = id;
    }

    public InterestArea(@NonNull Long id) {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime createdAt;
}
