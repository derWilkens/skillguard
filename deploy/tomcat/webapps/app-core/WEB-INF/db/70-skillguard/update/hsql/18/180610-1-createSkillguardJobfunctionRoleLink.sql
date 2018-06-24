create table SKILLGUARD_JOBFUNCTION_ROLE_LINK (
    JOBFUNCTION_ID varchar(36) not null,
    ROLE_ID varchar(36) not null,
    primary key (JOBFUNCTION_ID, ROLE_ID)
);
