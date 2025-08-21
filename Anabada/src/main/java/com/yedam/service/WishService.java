package com.yedam.service;

import com.yedam.vo.WishVO;

public interface WishService {
    public int countProductWish(int prdNo);
    public boolean exists(WishVO wish);
    public boolean registerWish(WishVO wish);
    public boolean removeWish(WishVO wish);
}
