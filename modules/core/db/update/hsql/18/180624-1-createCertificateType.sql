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
);
