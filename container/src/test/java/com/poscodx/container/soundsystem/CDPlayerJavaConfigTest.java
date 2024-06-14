package com.poscodx.container.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.poscodx.container.config.soundsystem.CDPlayerConfig;

// spring에서 junit으로 테스트하기 위해
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {CDPlayerConfig.class})
public class CDPlayerJavaConfigTest {
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDPlayNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing 붕붕 by 김하온",cdPlayer.play());
	
	}
}
