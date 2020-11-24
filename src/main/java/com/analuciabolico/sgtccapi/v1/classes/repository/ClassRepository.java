package com.analuciabolico.sgtccapi.v1.classes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

}
