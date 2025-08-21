package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {

    private int notiNo;
    private String notiTitle;
    private String notiContent;
    private Date notiDate;
    
}
