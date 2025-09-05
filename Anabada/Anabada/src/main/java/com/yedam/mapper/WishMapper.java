package com.yedam.mapper;

import com.yedam.vo.WishVO;
import org.apache.ibatis.annotations.Param;

public interface WishMapper {
    public int countWishMember(int prdNo);
    public int existWish(WishVO wish);
    public int insertWish(WishVO wish);
    public int deleteWish(WishVO wish);


}
