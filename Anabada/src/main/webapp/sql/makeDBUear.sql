-- '2팀' 이라고 지정
-- 사용자 이름: team
-- 비밀번호: team

alter session set "_ORACLE_SCRIPT" = true;

create user team identified by team;
grant connect, resource to team;
alter user team default tablespace users quota unlimited on users;