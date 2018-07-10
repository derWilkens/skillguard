alter table SKILLGUARD_CERTIFICATE add constraint FK_SKILLGUARD_CERTIFICATE_VERFIED_BY foreign key (VERFIED_BY_ID) references SEC_USER(ID);
alter table SKILLGUARD_CERTIFICATE add constraint FK_SKILLGUARD_CERTIFICATE_QUALIFICATION_TYPE foreign key (QUALIFICATION_TYPE_ID) references SKILLGUARD_CERTIFICATE_TYPE(ID);
alter table SKILLGUARD_CERTIFICATE add constraint FK_SKILLGUARD_CERTIFICATE_EMPLOYEE foreign key (EMPLOYEE_ID) references SEC_USER(ID);
alter table SKILLGUARD_CERTIFICATE add constraint FK_SKILLGUARD_CERTIFICATE_FILE_DATA foreign key (FILE_DATA_ID) references SYS_FILE(ID);
create index IDX_SKILLGUARD_CERTIFICATE_VERFIED_BY on SKILLGUARD_CERTIFICATE (VERFIED_BY_ID);
create index IDX_SKILLGUARD_CERTIFICATE_QUALIFICATION_TYPE on SKILLGUARD_CERTIFICATE (QUALIFICATION_TYPE_ID);
create index IDX_SKILLGUARD_CERTIFICATE_EMPLOYEE on SKILLGUARD_CERTIFICATE (EMPLOYEE_ID);
create index IDX_SKILLGUARD_CERTIFICATE_FILE_DATA on SKILLGUARD_CERTIFICATE (FILE_DATA_ID);
