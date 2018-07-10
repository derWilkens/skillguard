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
    NAME varchar(50),
    ACRONYM varchar(15),
    LEADER_ID varchar(36),
    DEPUTY_LEADER_ID varchar(36),
    PARENT_DEPARTMENT_ID varchar(36),
    --
    primary key (ID)
);
