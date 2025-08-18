
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


-- 상품테이블 테이터 (샘플)
insert into product (prd_no, prd_name, price, category, prd_status, prd_desc, prd_tag, trade_type, sale_status, prd_img, member_no, sido, sigungu, dong, lat, lng)
values (product_seq.nextval, '원목 4인용 식탁', 180000, '가구/생활', '사용감 많음', '원목으로 만들어져서 굉장히 튼튼한 제품입니다. 관심있으신 분들 연락주세요!', '식탁,원목,가구',
        '직거래', '판매중', '1_원목4인용식탁.jpg', 1, '대구광역시', '수성구', '범어동', 35.857420, 128.626100);
insert into product (prd_no, prd_name, price, category, prd_status, prd_desc, prd_tag, trade_type, sale_status, prd_img, member_no, sido, sigungu, dong, lat, lng)
values (product_seq.nextval, '캠핑용 폴딩체어', 30000, '스포츠', '새상품(미사용)', 
        '캠핑갈려고 샀는데 사정이 생겨서 사용하지 못한 새제품입니다. 포장도 뜯지 않아 박스까지 보관하고 있으니 구입하실 분은 연락주세요', 
        '캠핑,의자,아웃도어', '택배거래', '예약중', '2_캠핑용폴딩체어.jpg', 2, '경기도', '성남시 분당구', '서현동', 37.384948, 127.123869);  
insert into product (prd_no, prd_name, price, category, prd_status, prd_desc, prd_tag, trade_type, sale_status, prd_img, member_no, sido, sigungu, dong, lat, lng)
values (product_seq.nextval, '샤넬 클래식 플랩백', 5500000, '악세사리', '사용감 없음', 
        '현백에서 4월달에 구입한 정품으로 보증서 인증 가능합니다, 더스트백 포함, 기스 전혀 없습니다. 너무 아끼던 아이인데 급전이 필요해서 싸게 올립니다', 
        '가방,샤넬,플랩백', '직거래', '판매완료', '3_샤넬클래식플랩백.jpg', 1, '서울특별시', '서초구', '서초동', 37.492361, 127.014211); 
        
        
-- 회원테이블 데이터 (샘플)
insert into member(member_no, member_id, member_pw, member_name, member_birth, member_phone)
values (member_seq.nextval, 'hong123', 'hong123', '홍길동', to_date('1990-05-15', 'YYYY-MM-DD'), '01012345678');
insert into member(member_no, member_id, member_pw, member_name, member_birth, member_phone)
values (member_seq.nextval, 'kim123', 'kim123', '김길동', to_date('1998-10-18', 'YYYY-MM-DD'), '01085209632');       


-- 문의게시판 샘플데이터(멤버넘버, 상품넘버 없으면 외래키위반(부모없음)이라고 뜸, 있는 값으로 수정해서 넣기)
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '직거래 가능할까요?', '주말 오후에 대구 수성구역에서 직거래 가능한가요?', 3, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '가격 네고 문의', '소폭 가격 조정 가능한지 궁금합니다.', 4, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '상태 문의', '스크래치나 하자 있는 부분이 있으면 사진 부탁드려요.', 5, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '구성품 포함 여부', '박스/설명서/정품 케이블 포함되나요?', 3, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '예약 가능 시간', '오늘 저녁 7시쯤 방문 예약 가능할까요?', 4, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '택배 거래 문의', '안전거래/착불 가능 여부 알려주세요.', 5, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '사용 기간이 궁금해요', '실사용 기간과 사용 빈도 알려주실 수 있나요?', 3, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '사진 추가 요청', '옆면과 뒷면 사진도 추가 가능할까요?', 4, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '직거래 위치 문의', '범어동 근처면 어느 장소가 편하신가요?', 5, 9);
INSERT INTO qna (qna_no, qna_title, qna_content, member_no, prd_no) 
VALUES (qna_seq.nextval, '구매 의사 있습니다', '내일 오전 바로 결제 가능해요. 연락 부탁드립니다.', 4, 9);
