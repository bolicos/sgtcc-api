package com.analuciabolico.sgtccapi.v1.examinations.repository;

import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
