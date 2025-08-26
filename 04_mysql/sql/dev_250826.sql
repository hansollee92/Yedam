show databases;
use mysql;
show tables;
use user;

select *
from user;

-- database(xe) - user - 테이블
--              - user - 테이블
-- database(dev/mysql/...) - dev01
-- user(dev01) - 여러 database 선택 

-- 테이블 생성
CREATE TABLE `dev`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- 테이블 사용을 위해 먼저 시행
use dev;

select *
from customers;

-- customers 테이블 데이터 넣기
insert into customers
values(1, '홍길동', 'hong@emil.com', '010-1111-2222', '대구 중구');
-- 칼럼만 지정하면 id값은 자동으로 순차적으로 생성된다. 
-- 칼럼 지정할때 id값은 auto increment를 지정을 했기 때문 
insert into customers(name, email, phone)
values('김민석', 'kim@email.com', '010-1111-4444');
insert into customers(name, email, phone)
values('박철순', 'park@email.com', '010-1111-7777');

-- 수정
update customers
set address = '서울 강남'
where id = 3;

-- 현재는 root관리자로 들어와서 데이터베이스도 만들었고 테이블도 만들었다. 
-- 하지만, 일반적인 사용으로는 적절하지 않아서 일반사용자 하나를 더 만들 것이다. 

-- 사용자 만들어진지 체크해보기
use mysql;
show tables;

select user, host, plugin
from user;

