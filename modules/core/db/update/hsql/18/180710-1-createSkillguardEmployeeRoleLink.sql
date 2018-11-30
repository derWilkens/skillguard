create table SKILLGUARD_EMPLOYEE_ROLE_LINK (
    ROLE_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (ROLE_ID, EMPLOYEE_ID)
);
