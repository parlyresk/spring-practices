package com.poscodx.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscodx.container.videosystem.Avengers;
import com.poscodx.container.videosystem.DVDPlayer;
import com.poscodx.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {

	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}

	// 주입(Injection)하기 1
	// Bean 생성 메소드를 직접 호출하는 방법
	@Bean("dvdPlayer") // 빈의 이름을 명시 , 원래는 메서드 이름으로 자동으로 할당됨
	public DVDPlayer dvdPlayer1() {
		return new DVDPlayer(avengers());

	}

	// 주입(Injection)하기 2
	// Parameter로 bean을 전달하는 방법
	@Bean
	public DVDPlayer dvdPlayer2(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);

	}
}
