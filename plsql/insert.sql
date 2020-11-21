--TITLES
INSERT INTO TITLES(ID, DESCRIPTION, NOMENCLATURE, TYPE) VALUES (SEQUENCE_TITLES.nextval, 'Certificado de graduação em curso de nível superior certificado pelo MEC', 'GRADUAÇÃO', 'STRICTO SENSO')
INSERT INTO TITLES(ID, DESCRIPTION, NOMENCLATURE, TYPE) VALUES (SEQUENCE_TITLES.nextval, 'Certificado de especialização em curso certificado pelo MEC', 'ESPECIALIZAÇÃO', 'LATU SENSO')
INSERT INTO TITLES(ID, DESCRIPTION, NOMENCLATURE, TYPE) VALUES (SEQUENCE_TITLES.nextval, 'Certificado de mestrado em instituição certificada pelo MEC', 'MESTRADO', 'STRICTO SENSO')
INSERT INTO TITLES(ID, DESCRIPTION, NOMENCLATURE, TYPE) VALUES (SEQUENCE_TITLES.nextval, 'Certificado de doutorado em instituição certificada pelo MEC', 'DOUTORADO', 'STRICTO SENSO')
INSERT INTO TITLES(ID, DESCRIPTION, NOMENCLATURE, TYPE) VALUES (SEQUENCE_TITLES.nextval, 'Certificado de pós docência em instituição certificada pelo MEC', 'PÓS DOUTORADO', 'STRICTO SENSO')
INSERT INTO TITLES(ID, DESCRIPTION, NOMENCLATURE, TYPE) VALUES (SEQUENCE_TITLES.nextval, 'Certificado de livre docência em instituição certificada pelo MEC', 'LIVRE DOCÊNCIA', 'STRICTO SENSO')


--INTEREST_AREAS
insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'iot', SYSTIMESTAMP,'descricao iot');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'big data',SYSTIMESTAMP, 'descricao big data');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'banco de dados',SYSTIMESTAMP, 'descricao banco de dados');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'java',SYSTIMESTAMP, 'descricao java');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'rest',SYSTIMESTAMP, 'descricao rest');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'tecnologia',SYSTIMESTAMP, 'descricao tecnologia');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'acessibilidade',SYSTIMESTAMP, 'descricao acessibilidade');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'front end',SYSTIMESTAMP, 'descricao front end');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'administração',SYSTIMESTAMP, 'descricao administração');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'lógica', SYSTIMESTAMP, 'descricao lógica');

insert into INTEREST_AREAS(ID, NAME, CREATED_AT, DESCRIPTION) values (SEQUENCE_INTEREST_AREAS.nextval, 'api', SYSTIMESTAMP, 'descricao api');


--STUDENTS
insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '36215540099', 'paula@gmail.com', SYSTIMESTAMP, '20188763456', 'paula da silva', '453829475');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '13385524067', 'marta@gmail.com', SYSTIMESTAMP, '20188763325', 'marta da silva', '451823475');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '82542796084', 'paulo@gmail.com', SYSTIMESTAMP, '20188734325', 'paulo dos santos', '881823475');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '96669645031', 'lucia@gmail.com', SYSTIMESTAMP, '20188723325', 'lucia dornelles', '885623475');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '83459345012', 'gustavo@gmail.com', SYSTIMESTAMP, '20188723367', 'gustavo soares', '236623475');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '95276488070', 'almir@gmail.com', SYSTIMESTAMP, '20188721167', 'almir feitosa', '952764880');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '21839697091', 'caetano@gmail.com', SYSTIMESTAMP, '20188721887', 'caetano veloso', '218396970');

insert into STUDENTS(id, cpf, email, created_at, registration, name, phone)
values(SEQUENCE_STUDENTS.nextval, '97815488005', 'alda@gmail.com', SYSTIMESTAMP, '20188718736', 'alda maria', '978154880');



--TEACHERS
--TEACHERS
INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '10444746021', 'alex@gmail.com','20188763456', 'alex martins', '1044474', SYSTIMESTAMP, 2);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '68275207061', 'alice@gmail.com', '20184763456', 'alice novaes', '6827520', SYSTIMESTAMP, 3);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '87205611059', 'gelson@gmail.com', '20188363456', 'gelson melo', '87205611', SYSTIMESTAMP, 4);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '39560025040', 'camila@gmail.com', '20188333456', 'camila dos santos', '3956002', SYSTIMESTAMP, 5);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '74158626005', 'heitor@gmail.com', '20188722456', 'heitor rodrigues', '74158626', SYSTIMESTAMP, 6);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '68901037009', 'flavia@gmail.com', '20183363456', 'flavia golvea', '68901037', SYSTIMESTAMP, 5);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '78857614018', 'marcos@gmail.com', '20188700456', 'marcos motta', '788576140', SYSTIMESTAMP, 4);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '22958935000', 'ronaldo@gmail.com', '20188223456', 'ronaldo machado', '22958935', SYSTIMESTAMP, 3);

INSERT INTO TEACHERS(ID, CPF, EMAIL, REGISTRATION, NAME, PHONE, CREATED_AT, FK_TITLE_UID) VALUES
(SEQUENCE_TEACHERS.nextval, '43323537068', 'talita@gmail.com', '20188763986', 'talita franco', '43323537', SYSTIMESTAMP, 2);


--interest areas teachers

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(1, 1);

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(2, 1);

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(3, 1);

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(1, 2);

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(1, 3);

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(2, 2);

insert into INTEREST_AREAS_TEACHERS(FK_INTEREST_AREA_UID, FK_TEACHER_UID) VALUES(3, 3);

--SEMESTERS
insert into SEMESTERS(id, name) VALUES (SEQUENCE_SEMESTERS.nextval, '2018/2');

insert into SEMESTERS(id, name) VALUES (SEQUENCE_SEMESTERS.nextval, '2018/1');

insert into SEMESTERS(id, name) VALUES (SEQUENCE_SEMESTERS.nextval, '2019/2');

insert into SEMESTERS(id, name) VALUES (SEQUENCE_SEMESTERS.nextval, '2019/1');

--CLASSES
INSERT INTO CLASSES(ID, NAME, CREATED_AT, FK_TEACHER_UID, FK_SEMESTER_UID)
VALUES (SEQUENCE_CLASSES.nextval, 'Projeto de TCC', SYSTIMESTAMP, 1, 1);

INSERT INTO CLASSES(ID, NAME, CREATED_AT, FK_TEACHER_UID, FK_SEMESTER_UID)
VALUES (SEQUENCE_CLASSES.nextval, 'Projeto de TCC', SYSTIMESTAMP, 1, 3);

INSERT INTO CLASSES(ID, NAME, CREATED_AT, FK_TEACHER_UID, FK_SEMESTER_UID)
VALUES (SEQUENCE_CLASSES.nextval, 'Metodologia de Pesquisa',SYSTIMESTAMP, 2, 2);

INSERT INTO CLASSES(ID, NAME, CREATED_AT, FK_TEACHER_UID, FK_SEMESTER_UID)
VALUES (SEQUENCE_CLASSES.nextval, 'Metodologia de Pesquisa',SYSTIMESTAMP, 2, 4);

--CLASSES_STUDENTS
insert into CLASSES_STUDENTS(fk_student_uid, fk_class_uid)
VALUES (1, 1);
insert into CLASSES_STUDENTS(fk_student_uid, fk_class_uid)
VALUES (2, 1);
insert into CLASSES_STUDENTS(fk_student_uid, fk_class_uid)
VALUES (3, 1);
insert into CLASSES_STUDENTS(fk_student_uid, fk_class_uid)
VALUES (4, 3);
insert into CLASSES_STUDENTS(fk_student_uid, fk_class_uid)
VALUES (5, 3);
insert into CLASSES_STUDENTS(fk_student_uid, fk_class_uid, AVERAGE)
VALUES (6, 2, 8.2);

--PROPOSALS
insert into PROPOSALS(id, title, created_at, fk_author_uid, fk_leader_uid)
VALUES (SEQUENCE_PROPOSALS.nextval, 'Proposta sobre iot', SYSTIMESTAMP, 1, 1);

insert into PROPOSALS(id, title, created_at, fk_author_uid, fk_leader_uid)
VALUES (SEQUENCE_PROPOSALS.nextval, 'Proposta sobre big data', SYSTIMESTAMP, 2, 1);

insert into PROPOSALS(id, title, created_at, fk_author_uid, fk_leader_uid)
VALUES (SEQUENCE_PROPOSALS.nextval, 'Proposta sobre ruby', SYSTIMESTAMP, 3, 2);

--EXAMINATIONS
insert into EXAMINATIONS(id, presentation, approved, text_content, text_structure, language, observation, relevance, title, note, type, created_at, fk_proposal_uid, fk_teacher_uid)
VALUES(SEQUENCE_EXAMINATIONS.nextval, 'boa apresentacao', 1, 'bom conteudo', 'boa estrutura', 'boa linguagem', 'observacoes', 'boa relevancia', 'titulo sobre iot', 8, 'avaliacao projeto tcc', SYSTIMESTAMP, 1, 5);

insert into EXAMINATIONS(id, presentation, approved, text_content, text_structure, language, observation, relevance, title, note, type, created_at, fk_proposal_uid, fk_teacher_uid)
VALUES(SEQUENCE_EXAMINATIONS.nextval, 'boa apresentacao', 1, 'bom conteudo', 'boa estrutura', 'boa linguagem', 'observacoes', 'boa relevancia', 'titulo sobre iot', 7, 'avaliacao projeto tcc', SYSTIMESTAMP, 1, 4);

insert into EXAMINATIONS(id, presentation, approved, text_content, text_structure, language, observation, relevance, title, note, type, created_at, fk_proposal_uid, fk_teacher_uid)
VALUES(SEQUENCE_EXAMINATIONS.nextval, 'boa apresentacao', 0, 'bom conteudo', 'boa estrutura', 'boa linguagem', 'observacoes', 'boa relevancia', 'titulo sobre big data', 5, 'avaliacao projeto tcc', SYSTIMESTAMP, 2, 5);

insert into EXAMINATIONS(id, presentation, approved, text_content, text_structure, language, observation, relevance, title, note, type, created_at, fk_proposal_uid, fk_teacher_uid)
VALUES(SEQUENCE_EXAMINATIONS.nextval, 'boa apresentacao', 0, 'bom conteudo', 'boa estrutura', 'boa linguagem', 'observacoes', 'boa relevancia', 'titulo sobre big data', 6, 'avaliacao projeto tcc', SYSTIMESTAMP, 2, 5);
