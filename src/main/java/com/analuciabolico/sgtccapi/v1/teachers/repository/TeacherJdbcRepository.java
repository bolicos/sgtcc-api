package com.analuciabolico.sgtccapi.v1.teachers.repository;

import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import com.analuciabolico.sgtccapi.v1.teachers.dtos.TeacherTitleResponse;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TeacherJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public Optional<TeacherTitleResponse> findTitleByTeacher(Long id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("RETURN_TEACHER_TITLE");
        SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_TEACHER", id);

        String title = simpleJdbcCall.executeFunction(String.class, in);
        return Optional.of(new TeacherTitleResponse(title));
    }
}
