package com.analuciabolico.sgtccapi.v1.aluno.repository;

import com.analuciabolico.sgtccapi.v1.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
