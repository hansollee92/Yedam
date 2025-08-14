-- 회원 데이터 샘플
insert into member (member_no,
                    member_id,
                    member_pw,
                    member_name,
                    member_birth,
                    member_phone)
values (member_seq.nextval,
        'bong',
        'bong123',
        '박봉근',
        to_date('2000-05-07', 'yyyy-mm-dd'),
        '01012345678');

insert into member (member_no,
                    member_id,
                    member_pw,
                    member_name,
                    member_birth,
                    member_phone)
values (member_seq.nextval,
        'hong',
        'hong',
        '홍길동',
        to_date('1995-06-17', 'yyyy-mm-dd'),
        '01078943594');

-- 상품 데이터 샘플
INSERT INTO product (
    prd_no, prd_name, price, prd_date, category, prd_status, prd_desc, prd_tag,
    trade_type, sale_status, prd_img, sido, sigungu, dong, lat, lng, member_no
) VALUES (
             product_seq.nextval,
             '나이키 에어맥스 270',
             120000,
             SYSDATE,
             '신발',
             '사용감 없음',
             '한 번만 착용한 거의 새 상품입니다. 정품 보증 가능.',
             '나이키,운동화,에어맥스',
             '직거래',
             '판매중',
             '나이키에어맥스270.jpg',
             '대구광역시',
             '수성구',
             '범어동',
             35.857500,
             128.624200,
             1
         );

INSERT INTO product (
    prd_no, prd_name, price, prd_date, category, prd_status, prd_desc, prd_tag,
    trade_type, sale_status, prd_img, sido, sigungu, dong, lat, lng, member_no
) VALUES (
             product_seq.nextval,
             '아이패드 프로 11인치 3세대',
             850000,
             SYSDATE,
             '디지털/가전',
             '사용감 적음',
             '정상 작동하며 케이스와 펜슬 포함. 화면 미세 스크래치 있습니다.',
             '아이패드,태블릿,3세대',
             '택배거래',
             '판매중',
             '아이패드프로3세대.jpg',
             '대구광역시',
             '중구',
             '동성로3가',
             35.868200,
             128.606900,
             2
         );

-- 찜 데이터 샘플
insert into wish (wish_no,
                  member_no,
                  prd_no)
values (wish_seq.nextval,
        1,
        1);

insert into wish (wish_no,
                  member_no,
                  prd_no)
values (wish_seq.nextval,
        2,
        1);

insert into wish (wish_no,
                  member_no,
                  prd_no)
values (wish_seq.nextval,
        2,
        2);
