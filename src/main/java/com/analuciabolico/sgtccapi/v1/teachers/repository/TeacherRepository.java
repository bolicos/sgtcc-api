package com.analuciabolico.sgtccapi.v1.teachers.repository;

import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import io.micrometer.core.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "EXEC FUNCTION RETURN_TEACHER_TITLE(:#{Teacher.id})")
    String findTitleByTeacher(@NonNull Long id);;
}
