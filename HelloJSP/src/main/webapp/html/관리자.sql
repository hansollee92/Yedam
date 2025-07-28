alter session set "_ORACLE_SCRIPT" = true;    --유저 id/pw 정보 넣기 위한 session 변경

create user dev identified by dev;
grant connect, resource to dev;
alter user dev default tablespace users quota unlimited on users;