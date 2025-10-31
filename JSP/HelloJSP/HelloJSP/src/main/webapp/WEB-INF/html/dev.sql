-- 25-07-28
-- 게시글번호, 제목, 내용, 작성자, 조회수, 생성일자, 변경일자
create table tbl_board(
    board_no   number,                   --게시글번호
    title      varchar2(100) not null,   --제목
    content    varchar2(1000) not null,  --내용
    writer     varchar2(30) not null,    --작성자
    view_cnt   number default 0,         --조회수
    creation_date  date default sysdate, -- 데이터 생성된 시점(생성일자)
    last_update_date  date default sysdate  --수정시점 (변경일자)
);

-- pk 설정
alter table tbl_board add constraint pk_board primary key(board_no);

-- 시퀀스 설정
create sequence board_seq;

-- 시퀀스 설정시 값 넣는 방법
insert into tbl_board (board_no, title, content, writer)
values(board_seq.nextval, '게시글 등록', '게시글 등록 연습입니다', '홍길동');
insert into tbl_board (board_no, title, content, writer)
values(board_seq.nextval, '등록 테스트', 'HTML, CSS, Javascript 입니다', '김길동');
insert into tbl_board (board_no, title, content, writer)
values(board_seq.nextval, '댓글 등록 되나요?', '기능을 만들겁니다', '박길동');
-- 지금은 샘플데이터여서 이렇게 넣지만 나중에는 여기에 userId를 넣을 예정

select *
from  tbl_board;

-- creation_date 잘못만든거 수정
--ALTER TABLE tbl_board 
--ADD creation_date DATE DEFAULT SYSDATE;
--UPDATE tbl_board SET creation_date = creation_data;
--ALTER TABLE tbl_board DROP COLUMN creation_data;