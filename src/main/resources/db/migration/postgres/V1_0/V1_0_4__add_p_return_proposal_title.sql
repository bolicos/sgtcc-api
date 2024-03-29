CREATE OR REPLACE PROCEDURE RETURN_PROPOSAL_TITLE(P_ID_STUDENT IN STUDENTS.ID%TYPE, P_PROPOSALS_TITLE INOUT PROPOSALS.TITLE%TYPE)
    LANGUAGE PLPGSQL
    AS $$
BEGIN
    SELECT P.TITLE
    INTO P_PROPOSALS_TITLE
    FROM PROPOSALS P
    INNER JOIN STUDENTS S ON S.ID = P.FK_AUTHOR_UID
    WHERE S.ID = P_ID_STUDENT;
END;
$$;