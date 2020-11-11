CREATE OR REPLACE PROCEDURE CALCULATE_AND_UPDATE_AVERAGE(P_ID_STUDENT IN NUMBER, P_ID_CLASS_STUDENT IN NUMBER)
    IS
        V_AVERAGE NUMBER;
    BEGIN
        SELECT SUM(NOTE)/COUNT(NOTE)
        INTO V_AVERAGE
        FROM EXAMINATIONS
        INNER JOIN PROPOSALS P on P.ID = EXAMINATIONS.FK_PROPOSAL_UID
        INNER JOIN STUDENTS S on S.ID = P.FK_AUTHOR_UID
        INNER JOIN CLASSES_STUDENTS C on S.ID = C.FK_STUDENT_UID
        WHERE P.FK_AUTHOR_UID = P_ID_STUDENT
        AND C.FK_CLASS_UID = P_ID_CLASS_STUDENT;

        UPDATE CLASSES_STUDENTS
        SET AVERAGE = V_AVERAGE
        WHERE FK_STUDENT_UID = P_ID_STUDENT;

        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT);
    END;
/
SHOW ERRORS;

BEGIN
    CALCULATE_AND_UPDATE_AVERAGE(1, 1);
END;
