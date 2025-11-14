package com.example.demo.service;

import com.example.demo.repository.Posts;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor     // 기본생성자
@Data
public class PostsSaveRequestDto {

	// field
	private String title;
	private String content;
	private String author;
	
	   // Posts의 모든 것을 필드에 작성하지 않는 이유는 id, comment는 내가 작성하는 것이 아님
	   // 그리고 해당 필드들은 모두 쓰고 읽고 가능해야하니 @Data 롬복기능 추가
	
	// 생성자
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	// 메서드 
	// DTO(요청 데이터)를 실제 엔티티(Posts) 객체로 바꿔주는 변환 메서드
	    // 현재 Dto가 실제 DB테이블의 컬럼과 1:1매칭이 아닌 상태이기 때문에 엔티티로 변경한 다음에 넘겨줌
	    // 이때 builder를 이용해서 값을 넘겨주고 있는 것
	public Posts toEntity() {
		return Posts.builder()
				    .title(title)
				    .content(content)
				    .author(author)
				    .build();
	}

}
