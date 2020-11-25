package com.analuciabolico.sgtccapi.v1.classes.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.analuciabolico.sgtccapi.v1.classes.dtos.StudentClassResponse;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ClassJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public Optional<Boolean> calculateAverageStudent(Long id, Long idStudent) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("CALCULATE_AND_UPDATE_AVERAGE");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("P_ID_CLASS_STUDENT", id)
                .addValue("P_ID_STUDENT", idStudent);

        Map<String, Object> outProcedure = simpleJdbcCall.execute(in);
        BigDecimal update = (BigDecimal) outProcedure.get("RESULT");

        return update.longValue() == 1 ? Optional.of(Boolean.TRUE): Optional.empty();
    }

    public List<StudentClassResponse> getStudentsReportsByClass(Long id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("CLASS_STUDENT_REPORT")
                .returningResultSet(
                        "P_RESULT",
                        BeanPropertyRowMapper.newInstance(StudentClassResponse.class)
                );

        SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CLASS", id);

        Map<String, Object> outProcedure = simpleJdbcCall.execute(in);
        return (List<StudentClassResponse>) outProcedure.get("P_RESULT");
    }
}
