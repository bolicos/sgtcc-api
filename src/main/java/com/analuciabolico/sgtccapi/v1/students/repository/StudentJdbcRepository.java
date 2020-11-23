package com.analuciabolico.sgtccapi.v1.students.repository;

import com.analuciabolico.sgtccapi.v1.students.dtos.StudentProposalTitleResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class StudentJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public Optional<StudentProposalTitleResponse> findTitleProposalByStudent(Long id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("RETURN_PROPOSAL_TITLE");
        SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_STUDENT", id);

        String title = simpleJdbcCall.execute(String.class, in);
        return Optional.of(new StudentProposalTitleResponse(title));
    }
}
