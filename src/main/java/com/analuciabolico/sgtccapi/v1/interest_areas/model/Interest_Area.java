package com.analuciabolico.sgtccapi.v1.interest_areas.model;

import io.micrometer.core.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @lombok.NonNull
    @Column(nullable = false, columnDefinition = "timestamp")
    protected LocalDateTime createdAt;

}
