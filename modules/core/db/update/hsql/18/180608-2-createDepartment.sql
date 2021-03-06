alter table SKILLGUARD_DEPARTMENT add constraint FK_SKILLGUARD_DEPARTMENT_LEADER foreign key (LEADER_ID) references SEC_USER(ID);
alter table SKILLGUARD_DEPARTMENT add constraint FK_SKILLGUARD_DEPARTMENT_DEPUTY_LEADER foreign key (DEPUTY_LEADER_ID) references SEC_USER(ID);
alter table SKILLGUARD_DEPARTMENT add constraint FK_SKILLGUARD_DEPARTMENT_PARENT_DEPARTMENT foreign key (PARENT_DEPARTMENT_ID) references SKILLGUARD_DEPARTMENT(ID);
create index IDX_SKILLGUARD_DEPARTMENT_LEADER on SKILLGUARD_DEPARTMENT (LEADER_ID);
create index IDX_SKILLGUARD_DEPARTMENT_DEPUTY_LEADER on SKILLGUARD_DEPARTMENT (DEPUTY_LEADER_ID);
create index IDX_SKILLGUARD_DEPARTMENT_PARENT_DEPARTMENT on SKILLGUARD_DEPARTMENT (PARENT_DEPARTMENT_ID);
