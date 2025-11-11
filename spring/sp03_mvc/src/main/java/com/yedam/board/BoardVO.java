package com.yedam.board;

import java.util.Date;     // sql.Date는 yyyy-MM-dd로 처리되고 util.Date는 Wed Nov 05 10:15:30 KST 2025으로 나타남
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO, DO, VO - 데이터를 담는다는 의미
@AllArgsConstructor     // Builder 사용되면 AllArgsCon.., NoArgsCon.. 모두 들어가야함
@NoArgsConstructor
@Builder
@Data
public class BoardVO {

	// 필드
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
	List<ReplyVO> reply;
	
}
