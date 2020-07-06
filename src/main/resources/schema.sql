DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS DEPARTMENT;

CREATE TABLE DEPARTMENT
(
    department_id   INT          NOT NULL PRIMARY KEY,
    department_name VARCHAR(250) NOT NULL
);

CREATE TABLE EMPLOYEE
(
    id            int          NOT NULL PRIMARY KEY,
    full_name     varchar(255) NOT NULL,
    salary        int          NOT NULL,
    department_id int,
    FOREIGN KEY (department_id) REFERENCES DEPARTMENT (department_id)
);