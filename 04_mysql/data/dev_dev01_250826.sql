-- 사용할 database 선택
use dev; 

select *
from customers;

-- 오라클에서는 안되지만 MySQL에서는 되는 insert 구문
insert into customers
set name='name', email='email', phone='010-1111';

-- 삭제 
delete from customers
where id = 4;