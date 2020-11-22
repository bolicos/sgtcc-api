package com.analuciabolico.sgtccapi.v1.interest_areas.repository;

import com.analuciabolico.sgtccapi.v1.interest_areas.model.InterestArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestAreaRepository extends JpaRepository<InterestArea, Long> {
}
