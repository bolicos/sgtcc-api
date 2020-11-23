CREATE OR REPLACE FUNCTION COUNT_TEACHER_BY_TITLE(p_nomenclature_title IN VARCHAR2)
RETURN NUMBER
IS
    V_QUANT_TEACHER NUMBER;
BEGIN
    select count(TA.id)
    INTO V_QUANT_TEACHER
    from TEACHERS TA
    inner join TITLES TI on TA.FK_TITLE_UID = TI.ID
    where NOMENCLATURE = p_nomenclature_title;

    RETURN V_QUANT_TEACHER;
END;
/
SHOW ERRORS;

SELECT COUNT_TEACHER_BY_TITLE('MESTRADO') from dual;