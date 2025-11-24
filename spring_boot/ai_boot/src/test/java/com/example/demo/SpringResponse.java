package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SpringResponse {

    @Autowired
    private ChatClient.Builder chatClientBuilder;

    private ChatClient chatClient;

    @BeforeEach
    void setUp() {
        this.chatClient = chatClientBuilder.build();
    }

	@Test
	public void test() {

        String response = chatClient.prompt("스티브 잡스의 명언을 한 개 알려줘")  //질문을 만들고
                .call() //질문을 요청하고
                .content(); // 응답결과를 받음

        System.out.println(response);
	}
}