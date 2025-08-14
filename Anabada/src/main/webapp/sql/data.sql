-- 상품테이블 테이터 (샘플)
insert into product (prd_no, prd_name, price, category, prd_status, prd_desc, prd_tag, trade_type, field, sale_status, prd_img, member_no, sido, sigungu, dong, lat, lng)
values (product_seq.nextval, '원목 4인용 식탁', 180000, '가구/생활', '사용감 많음', '원목으로 만들어져서 굉장히 튼튼한 제품입니다. 관심있으신 분들 연락주세요!', '식탁,원목,가구',
        '직거래', '대구광역시 수성구 범어동', '판매중', '1_원목4인용식탁.jpg', 1, '대구광역시', '수성구', '범어동', 35.857420, 128.626100);
insert into product (prd_no, prd_name, price, category, prd_status, prd_desc, prd_tag, trade_type, field, sale_status, prd_img, member_no, sido, sigungu, dong, lat, lng)
values (product_seq.nextval, '캠핑용 폴딩체어', 30000, '스포츠', '새상품(미사용)', 
        '캠핑갈려고 샀는데 사정이 생겨서 사용하지 못한 새제품입니다. 포장도 뜯지 않아 박스까지 보관하고 있으니 구입하실 분은 연락주세요', 
        '캠핑,의자,아웃도어', '택배거래', '경기도 성남시 분당구 서현동', '예약중', '2_캠핑용폴딩체어.jpg', 2, '경기도', '성남시 분당구', '서현동', 37.384948, 127.123869);  
insert into product (prd_no, prd_name, price, category, prd_status, prd_desc, prd_tag, trade_type, field, sale_status, prd_img, member_no, sido, sigungu, dong, lat, lng)
values (product_seq.nextval, '샤넬 클래식 플랩백', 5500000, '악세사리', '사용감 없음', 
        '현백에서 4월달에 구입한 정품으로 보증서 인증 가능합니다, 더스트백 포함, 기스 전혀 없습니다. 너무 아끼던 아이인데 급전이 필요해서 싸게 올립니다', 
        '가방,샤넬,플랩백', '직거래', '서울특별시 서초구 서초동', '판매완료', '3_샤넬클래식플랩백.jpg', 1, '서울특별시', '서초구', '서초동', 37.492361, 127.014211); 
        
        
-- 회원테이블 데이터 (샘플)
insert into member(member_no, member_id, member_pw, member_name, member_birth, member_phone)
values (member_seq.nextval, 'hong123', 'hong123', '홍길동', to_date('1990-05-15', 'YYYY-MM-DD'), '01012345678');
insert into member(member_no, member_id, member_pw, member_name, member_birth, member_phone)
values (member_seq.nextval, 'kim123', 'kim123', '김길동', to_date('1998-10-18', 'YYYY-MM-DD'), '01085209632');       