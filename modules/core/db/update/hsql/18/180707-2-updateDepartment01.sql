alter table SKILLGUARD_DEPARTMENT add constraint FK_SKILLGUARD_DEPARTMENT_ON_DEFAULT_JOB_FUNCTION foreign key (DEFAULT_JOB_FUNCTION_ID) references SKILLGUARD_JOBFUNCTION(ID);
create index IDX_SKILLGUARD_DEPARTMENT_ON_DEFAULT_JOB_FUNCTION on SKILLGUARD_DEPARTMENT (DEFAULT_JOB_FUNCTION_ID);
