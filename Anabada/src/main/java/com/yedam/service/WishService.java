package com.yedam.service;

import com.yedam.vo.WishVO;

public interface WishService {
    public int countProductWish(int prdNo);
    public int findProductMember(int prdNo);
    public boolean registerWish(WishVO wish);
    public boolean removeWish(WishVO wish);
}
