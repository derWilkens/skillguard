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
);
