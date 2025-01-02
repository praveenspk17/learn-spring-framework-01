package com.example.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.SuperManGame;

public class App02GamingSpringBeans {

	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(GamingSpringConfiguration.class)) {
			
			context.getBean(GameRunner.class).run();
			
			
		}
		
		
		

	}

}
