package com.analuciabolico.sgtccapi.v1.proposta.repository;

import com.analuciabolico.sgtccapi.v1.proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}
