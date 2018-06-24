create table SKILLGUARD_ROLE_CERTIFICATE_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ROLE_ID varchar(36),
    LEVEL_ integer,
    CERTIFICATE_TYPE_ID varchar(36),
    MANDATORY boolean,
    --
    primary key (ID)
);
