package com.analuciabolico.sgtccapi.v1.students.repository;

import com.analuciabolico.sgtccapi.v1.students.model.Student;
import io.micrometer.core.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "EXEC PROCEDURE RETURN_PROPOSAL_TITLE(:#{#id})")
    public String findTitleProposalByStudent(@NonNull Long id);
}
