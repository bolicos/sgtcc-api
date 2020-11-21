package com.analuciabolico.sgtccapi.v1.students.repository;

import com.analuciabolico.sgtccapi.v1.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(String id);
}
