create table SKILLGUARD_ROLE_CERTIFICATE_TYPE_LINK (
    CERTIFICATE_TYPE_ID varchar(36) not null,
    ROLE_ID varchar(36) not null,
    primary key (CERTIFICATE_TYPE_ID, ROLE_ID)
);
