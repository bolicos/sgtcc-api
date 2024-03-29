CREATE TABLE BOARDS
(
    ID BIGINT CONSTRAINT PK_BOARD PRIMARY KEY,
    CREATED_AT TIMESTAMP NOT NULL,
    DATE_SCHEDULED TIMESTAMP NOT NULL,
    FK_CLASS_UID BIGINT NOT NULL,
    FK_LEADER_UID BIGINT NOT NULL,
    FK_PROPOSAL_UID BIGINT NOT NULL
);
CREATE TABLE BOARDS_EVALUATORS
(
    FK_BOARD_UID BIGINT NOT NULL,
    FK_EVALUATOR_UID BIGINT NOT NULL
);
CREATE TABLE CLASSES
(
    ID BIGINT CONSTRAINT PK_CLASS PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    FK_TEACHER_UID BIGINT NOT NULL,
    FK_SEMESTER_UID BIGINT NOT NULL
);
CREATE TABLE CLASSES_STUDENTS
(
    FK_STUDENT_UID BIGINT NOT NULL,
    FK_CLASS_UID BIGINT NOT NULL,
    AVERAGE BIGINT
);
CREATE TABLE STUDENTS
(
    ID BIGINT CONSTRAINT PK_STUDENT PRIMARY KEY,
    CPF VARCHAR(11) UNIQUE NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    REGISTRATION VARCHAR(20) UNIQUE NOT NULL,
    NAME VARCHAR(200) NOT NULL,
    PHONE VARCHAR(15) NOT NULL
);
CREATE TABLE INTEREST_AREAS
(
    ID BIGINT CONSTRAINT PK_INTEREST_AREA PRIMARY KEY,
    NAME VARCHAR(200) UNIQUE NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    DESCRIPTION VARCHAR(200) NOT NULL
);
CREATE TABLE INTEREST_AREAS_TEACHERS
(
    FK_INTEREST_AREA_UID BIGINT NOT NULL,
    FK_TEACHER_UID BIGINT NOT NULL
);
CREATE TABLE EXAMINATIONS
(
    ID BIGINT CONSTRAINT PK_EXAMINATION PRIMARY KEY,
    PRESENTATION VARCHAR(255) NOT NULL,
    APPROVED BOOLEAN NOT NULL,
    TEXT_CONTENT VARCHAR(255) NOT NULL,
    TEXT_STRUCTURE VARCHAR(255) NOT NULL,
    LANGUAGE VARCHAR(255) NOT NULL,
    OBSERVATION VARCHAR(255),
    RELEVANCE VARCHAR(255) NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    NOTE NUMERIC(4, 2) NOT NULL,
    TYPE VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    FK_PROPOSAL_UID BIGINT NOT NULL,
    FK_TEACHER_UID BIGINT NOT NULL
);
CREATE TABLE SEMESTERS
(
    ID BIGINT CONSTRAINT PK_SEMESTER PRIMARY KEY,
    NAME VARCHAR(6) NOT NULL
);
CREATE TABLE TEACHERS
(
    ID BIGINT CONSTRAINT PK_TEACHER PRIMARY KEY,
    CPF VARCHAR(11) UNIQUE NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    REGISTRATION VARCHAR(20) UNIQUE NOT NULL,
    NAME VARCHAR(200) NOT NULL,
    PHONE VARCHAR(15) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    FK_TITLE_UID BIGINT NOT NULL
);
CREATE TABLE PROPOSALS
(
    ID BIGINT CONSTRAINT PK_PROPOSAL PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    FK_AUTHOR_UID BIGINT NOT NULL,
    FK_LEADER_UID BIGINT NOT NULL
);
CREATE TABLE SUGGESTIONS
(
    ID BIGINT CONSTRAINT PK_SUGGESTION PRIMARY KEY,
    DESCRIPTION VARCHAR(255) NOT NULL,
    SEARCH BOOLEAN NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL,
    FK_TEACHER_UID BIGINT NOT NULL
);
CREATE TABLE TITLES
(
    ID BIGINT CONSTRAINT PK_TITLE PRIMARY KEY,
    DESCRIPTION VARCHAR(255) NOT NULL,
    NOMENCLATURE VARCHAR(255) NOT NULL,
    TYPE VARCHAR(255) NOT NULL
);
