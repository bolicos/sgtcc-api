package com.analuciabolico.sgtccapi.v1.teachers.repository;

import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
