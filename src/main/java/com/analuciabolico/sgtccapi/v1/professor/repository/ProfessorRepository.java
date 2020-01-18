package com.analuciabolico.sgtccapi.v1.professor.repository;

import com.analuciabolico.sgtccapi.v1.professor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
