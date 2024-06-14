package com.poscodx.container.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.poscodx.container.config.videosystem.DVDPlayerConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
	
	// 같은 타입의 빈이 2개 이상있으면 충돌이 발생하므로 id처럼 이름 지정 가능
	// 설정 클래스의 빈 생성 메소드의 @Bean의 name(default)속성으로 qualified하기
	@Autowired
	@Qualifier("dvdPlayer") 
	private DVDPlayer dvdPlayer01;
	
	@Autowired
	@Qualifier("dvdPlayer2")
	private DVDPlayer dvdPlayer02;
	
	@Autowired
	@Qualifier("dvdPlayer03")
	private DVDPlayer dvdPlayer03;
	
	@Test
	public void testDVDPlayer01NotNull() {
		assertNotNull(dvdPlayer01);
	}
	
	@Test
	public void testDVDPlayer02NotNull() {
		assertNotNull(dvdPlayer02);
	}
	
	@Test
	public void testDVDPlayer03NotNull() {
		assertNotNull(dvdPlayer03);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie Marvel's Avengers", dvdPlayer01.play());
	}
	
	@Test
	public void testPlay2() {
		assertEquals("Playing Movie Marvel's Avengers", dvdPlayer02.play());
	}
	
	@Test
	public void testPlay3() {
		assertEquals("Playing Movie Marvel's Avengers", dvdPlayer03.play());
	}
}
