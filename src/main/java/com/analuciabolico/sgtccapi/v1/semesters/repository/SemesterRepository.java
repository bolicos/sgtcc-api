package com.analuciabolico.sgtccapi.v1.semesters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

}
