package com.analuciabolico.sgtccapi.v1.banca.repository;

import com.analuciabolico.sgtccapi.v1.banca.model.Banca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancaRepository extends JpaRepository<Banca, Long> {

}
