alter table SKILLGUARD_ROLE rename to SKILLGUARD_ROLE__UNUSED ;
alter table SKILLGUARD_JOBFUNCTION_ROLE_LINK drop constraint FK_JOBROL_ROLE ;
alter table SKILLGUARD_ROLE_CERTIFICATE_TYPE_LINK drop constraint FK_ROLCERTYP_ROLE ;
