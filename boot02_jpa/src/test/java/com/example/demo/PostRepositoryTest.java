package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.Posts;
import com.example.demo.repository.PostsRepository;

@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void 글등록() {
		// given
		String title = "글등록 테스트";
		String content = "글을 등록하는 테스트 중입니다.";
		String author = "홍길동";
		
		Posts post = Posts.builder().title(title).content(content).author(author).build();
		
		postsRepository.save(post);
		
		// when
		List<Posts> postList = postsRepository.findAll();
		
		// then
		assertEquals(postList.get(0).getTitle(), title);
		assertEquals(postList.get(0).getContent(), content);
		assertEquals(postList.get(0).getAuthor(), author);
	}
	
}
