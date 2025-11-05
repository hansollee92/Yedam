package com.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.container.Speaker;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
public class SamsungTV implements TV {
	
	// 필드
	@Autowired    // 1) 필드주입방식
	Speaker speaker;
	int model;
	
	// 의존관계 객체
	// AppleSpeaker로 들고오면 나중에 다른 걸로 교체를 할수가 없기 때문에 그의 부모인 Speaker 인터페이스로 가져왔다. 
	
	// 생성자
	public SamsungTV() {
		System.out.println("===> SamsungTV");
	}
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("생성자 방식으로 주입");
	}
	
	// setter
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("setter 방식으로 주입");
	}
	
	// method
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV volumeUp");
		speaker.volumeUp();
		// 근데, 지금 이렇게만 넣게 되면 인터페이스를 가져와서 넣은 것이기 때문에 nullPoint예외가 일어난다.
		// >> Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.container.Speaker.volumeUp()" because "this.speaker" is null
		
		// 그래서 speaker를 주입할 때 이렇게 넣는 것이 아니라 의존관계에 있는 것을 주입해야한다. (의존관계에 있는 객체의 주입)
		
		// 그럼 이걸 어떻게 넣어주냐? -> applicationContext.xml로 가서 
		// <bean id="Speaker" class="com.container.AppleSpeaker"></bean> 만들어주고
		// <bean id="TV"></bean> 이 안에 <constructor-arg ref="Speaker"></constructor-arg>로 해주면 된다. 
		// 그렇게 한 다음에 Main.java 실행하면 정상적으로 실행된다. 
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV volumeDown");
		speaker.volumeDown();
	}
}