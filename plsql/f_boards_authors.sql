CREATE OR REPLACE FUNCTION BOARDS_AUTHORS(v_name_class in varchar2) RETURN SYS_REFCURSOR IS
cur_s SYS_REFCURSOR;
begin
    open cur_s for
        select S.NAME || ' - '|| GET_DATE_SCHEDULED_BOARD(S.name)
        from STUDENTS S
        inner join CLASSES_STUDENTS CS on S.ID = CS.FK_STUDENT_UID
        inner join CLASSES C2 on C2.ID = CS.FK_CLASS_UID
        where lower(c2.NAME) = lower(v_name_class);
    return cur_s;
end;
/
