-- 1. 회원 테이블 생성
create table member (
    member_no     number(5) primary key, -- 유저번호
    member_id     varchar2(40) not null, -- 아이디
    member_pw     varchar2(100) not null, -- 비밀번호
    member_name   varchar2(10) not null, -- 이름
    member_birth  date not null, -- 생년월일
    member_phone  varchar2(20) not null, -- 전화번호
    member_img    varchar2(100),
    member_score  number default 2 -- 평점
);

-- 2. 상품 테이블 (비정규화 지도API)
create table product (
    prd_no      number(5) primary key, -- 상품번호
    prd_name    varchar2(100) not null, -- 상품명
    price       number(20) default 0 not null, -- 상품가격
    prd_date    date default sysdate, -- 등록일자
    category    varchar2(30) not null, -- 카테고리 : 의류, 신발, 악세사리, 디지털/가전, 스포츠, 도서/티켓, 가구/생활, 기타
    prd_status   varchar2(20) not null, -- 상품상태 : 새상품(미사용), 사용감 없음, 사용감 적음, 사용감 많음, 고장/파손 상품
    prd_desc    varchar2(1000), -- 상품설명
    prd_tag     varchar2(100), -- 태그
    trade_type  varchar2(20) not null, -- 거래방식 : 직거래, 택배거래
    sale_status  varchar2(20) not null, -- 판매상태 : 판매중, 예약중, 판매완료
    prd_img     varchar2(100), -- 상품이미지명(상품번호_이미지이름.확장자, 예: 3_테이블.jpg)
    sido     varchar2(20),  -- 시/도 (예: 대구광역시)
    sigungu  varchar2(20),  -- 시/군/구 (예: 수성구)
    dong     varchar2(40),  -- 읍/면/동 (예: 범어동)
    lat      number(9,6),   -- 위도
    lng      number(9,6),    -- 경도
    view_cnt   number(10) default 0 not null,   --조회수
    member_no   number(5),
    foreign key (member_no) references member (member_no)
);

-- 3. 상품문의 테이블
create table qna (
    qna_no      number(10) primary key, -- 문의번호
    qna_title   varchar2(200) not null, -- 제목
    qna_content varchar2(2000) not null, -- 내용
    qna_date    date default sysdate, -- 작성일
    member_no   number(5),
    prd_no      number(5),
    foreign key (member_no) references member (member_no),
    foreign key (prd_no) references product (prd_no)
);

-- 4.  상품문의 댓글 테이블
create table qna_reply (
    qnaReply_no         number(10) primary key, -- 문의댓글번호
    qnaReply_content    varchar2(1000) not null, -- 내용
    qnaReply_date       date default sysdate, -- 작성일
    member_no           number(5),
    qna_no              number(5),
    foreign key (member_no) references member (member_no),
    foreign key (qna_no) references qna (qna_no)
);

-- 5. 구매 테이블
create table  purchase (
    pur_no      number(5) primary key, -- 구매번호
    member_no   number(5),
    prd_no      number(5),
    foreign key (member_no) references member (member_no),
    foreign key (prd_no) references product (prd_no)
);

-- 6. 리뷰 테이블
create table review (
    review          number(5) primary key, -- 리뷰번호
    review_content  varchar2(200) not null, -- 리뷰내용
    review_score    number default 0 not null, -- 리뷰평점
    member_no       number(5),
    prd_no          number(5),
    pur_no          number(5),
    foreign key (member_no) references member (member_no),
    foreign key (prd_no) references product (prd_no),
    foreign key (pur_no) references purchase (pur_no)
);

-- 7. 커뮤니티 테이블
create table commu (
    commu_no        number(5) primary key, -- 글번호
    commu_title     varchar2(100) not null, -- 글제목
    commu_date      date default sysdate, -- 작성일
    member_no   number(5),
    foreign key (member_no) references member (member_no)
);

-- 8. 커뮤니티 댓글 테이블
create table commu_reply (
    commuReply_no       number(5) primary key, -- 글댓글번호
    commuReply_content  varchar2(200) not null, -- 내용
    commuReply_date     date default sysdate, -- 작성일
    parent_id           number(5), -- 상위 댓글
    member_no           number(5),
    commu_no            number(5),
    foreign key (member_no) references member (member_no),
    foreign key (commu_no) references commu (commu_no)
);

-- 9. 공지 테이블
create table notice (
    noti_no         number(5) primary key, -- 공지번호
    noti_title      varchar2(200) not null, -- 공지제목
    noti_content    varchar2(500) not null, -- 공지내용
    noti_date       date default sysdate -- 작성일
);

-- 10. 찜 테이블
create table wish (
    wish_no     number(5) primary key,
    member_no   number(5),
    prd_no      number(5),
    foreign key (member_no) references member (member_no),
    foreign key (prd_no) references product (prd_no)
);


-- 시퀀스 생성
create sequence member_seq;
create sequence product_seq;
create sequence qna_seq;
create sequence qnaReply_seq;
create sequence purchase_seq;
create sequence review_seq;
create sequence commu_seq;
create sequence commuReply_seq;
create sequence notice_seq;
create sequence wish_seq;

-- 커밋
commit;




