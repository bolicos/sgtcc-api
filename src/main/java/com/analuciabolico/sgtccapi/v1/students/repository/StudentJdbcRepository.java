package com.analuciabolico.sgtccapi.v1.students.repository;

import com.analuciabolico.sgtccapi.v1.students.dtos.StudentGuidanceResponse;
import com.analuciabolico.sgtccapi.v1.students.dtos.StudentProposalTitleResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class StudentJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public Optional<StudentProposalTitleResponse> findTitleProposalByStudent(Long id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("RETURN_PROPOSAL_TITLE");
        SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_STUDENT", id);

        Map<String, Object> outProcedure = simpleJdbcCall.execute(in);
        String proposalTitle = (String) outProcedure.get("P_PROPOSALS_TITLE");
        return Optional.of(new StudentProposalTitleResponse(proposalTitle));
    }

    public Optional<StudentGuidanceResponse> findGuidanceByStudent(Long id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("RETURNS_GUIDANCE_NAME");
        SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_STUDENT", id);

        Map<String, Object> outProcedure = simpleJdbcCall.execute(in);
        String guidance = (String) outProcedure.get("P_GUIDING_NAME");
        return Optional.of(new StudentGuidanceResponse(guidance));
    }
}
