CREATE OR REPLACE PROCEDURE CLASS_STUDENT_REPORT(P_ID_CLASS IN CLASSES.ID%TYPE, P_RESULT INOUT SYS_REFCURSOR)
    LANGUAGE PLPGSQL
    AS $$
BEGIN
    OPEN P_RESULT FOR
        SELECT S.NAME AS SEMESTER, C.NAME AS NAME, ST.NAME AS STUDENT, CS.AVERAGE AS AVERAGE
        FROM STUDENTS ST
                 INNER JOIN CLASSES_STUDENTS CS ON ST.ID = CS.FK_STUDENT_UID
                 INNER JOIN CLASSES C ON C.ID = CS.FK_CLASS_UID
                 INNER JOIN SEMESTERS S ON S.ID = C.FK_SEMESTER_UID
        WHERE C.ID = P_ID_CLASS;
END;
$$;
