-- begin SKILLGUARD_DEPARTMENT
create table SKILLGUARD_DEPARTMENT (
    ID varchar(36) not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DEFAULT_JOB_FUNCTION_ID varchar(36),
    NAME varchar(50),
    ACRONYM varchar(15),
    LEADER_ID varchar(36),
    DEPUTY_LEADER_ID varchar(36),
    PARENT_DEPARTMENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end SKILLGUARD_DEPARTMENT
-- begin SKILLGUARD_JOBFUNCTION
create table SKILLGUARD_JOBFUNCTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    --
    primary key (ID)
)^
-- end SKILLGUARD_JOBFUNCTION
-- begin SKILLGUARD_ROLE
create table SKILLGUARD_ROLE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    LEVEL_ integer,
    --
    primary key (ID)
)^
-- end SKILLGUARD_ROLE
-- begin SKILLGUARD_CERTIFICATE_TYPE
create table SKILLGUARD_CERTIFICATE_TYPE (
    ID varchar(36) not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    VALIDITY integer,
    --
    primary key (ID)
)^
-- end SKILLGUARD_CERTIFICATE_TYPE
-- begin SKILLGUARD_CERTIFICATE
create table SKILLGUARD_CERTIFICATE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ISSUING_DATE date,
    EXPIRATION_DATE date,
    VERFIED_BY_ID varchar(36),
    QUALIFICATION_TYPE_ID varchar(36),
    EMPLOYEE_ID varchar(36),
    FILE_DATA_ID varchar(36),
    --
    primary key (ID)
)^
-- end SKILLGUARD_CERTIFICATE
-- begin SKILLGUARD_JOBFUNCTION_ROLE_LINK
create table SKILLGUARD_JOBFUNCTION_ROLE_LINK (
    JOBFUNCTION_ID varchar(36) not null,
    ROLE_ID varchar(36) not null,
    primary key (JOBFUNCTION_ID, ROLE_ID)
)^
-- end SKILLGUARD_JOBFUNCTION_ROLE_LINK
-- begin SKILLGUARD_ROLE_CERTIFICATE_TYPE_LINK
create table SKILLGUARD_ROLE_CERTIFICATE_TYPE_LINK (
    CERTIFICATE_TYPE_ID varchar(36) not null,
    ROLE_ID varchar(36) not null,
    primary key (CERTIFICATE_TYPE_ID, ROLE_ID)
)^
-- end SKILLGUARD_ROLE_CERTIFICATE_TYPE_LINK
-- begin SEC_USER
alter table SEC_USER add column DEPARTMENT_ID varchar(36) ^
alter table SEC_USER add column JOBFUNCTION_ID varchar(36) ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'sec$User' where DTYPE is null ^
-- end SEC_USER
-- begin SKILLGUARD_EMPLOYEE_ROLE_LINK
create table SKILLGUARD_EMPLOYEE_ROLE_LINK (
    ROLE_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (ROLE_ID, EMPLOYEE_ID)
)^
-- end SKILLGUARD_EMPLOYEE_ROLE_LINK
