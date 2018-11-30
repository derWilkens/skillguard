alter table SKILLGUARD_EMPLOYEE_ROLE_LINK add constraint FK_EMPROL_ON_ROLE foreign key (ROLE_ID) references SKILLGUARD_ROLE(ID);
alter table SKILLGUARD_EMPLOYEE_ROLE_LINK add constraint FK_EMPROL_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references SEC_USER(ID);
