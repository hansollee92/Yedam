package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.PurchaseMapper;
import com.yedam.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    PurchaseMapper mapper = sqlSession.getMapper(PurchaseMapper.class);

    @Override
    public boolean recordPurchase(int memberNo, int prdNo) {
        PurchaseVO vo = new PurchaseVO();
        vo.setMemberNo(memberNo);
        vo.setPrdNo(prdNo);

        int r = mapper.insertPurchase(vo);
        if (r == 1) {
            sqlSession.commit();
            return true;
        }
        return false;
    }
}