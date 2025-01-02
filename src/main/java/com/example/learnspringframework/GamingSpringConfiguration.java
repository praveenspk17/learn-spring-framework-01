package com.example.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.SuperManGame;

@Configuration
public class GamingSpringConfiguration {
	
	@Bean
	@Primary // Making it as Primary, so GameRunner would pick up MarioGame
	public GamingConsole game()
	{
		return new MarioGame();
	}
	
	@Bean
	@Qualifier("GameQualifier")
	public GamingConsole gameAlternate()
	{
		return new SuperManGame();
	}
	
	
	@Bean
	public GameRunner gamerunner(@Qualifier("GameQualifier") GamingConsole game)
	{
		return new GameRunner(game);
	}
}
