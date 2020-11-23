package com.analuciabolico.sgtccapi.v1.teachers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
