package com.example.learnspringframework;

import java.util.List;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.SuperManGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		//Tightly Coupled application -> Without leveraging Interfaces
		/**
		 * var is 'Type Inference' feature introduced in Java 10. Based on the assigned variable value, complier automatically infers 
		 *the type of the var variable.
		 *
		 *Eg: 
		 *List<String> names = List.of("Arun","Madhav");
		 *var names = List.of("Arun","Madhav");
		 * 
		 */
		//var marioGame = new MarioGame();
		
		//now it leverages interfaces - GameRunner constructor uses interface as an argument -so 
		// any game object that implements GamingConsole will work.
		var game = new SuperManGame(); //1. Object Creation
		var gameRunner = new GameRunner(game);
		//2. Object Creation and Wiring of dependencies.  Game is a dependency of GameRunner.
		// Till now, we were having control of object creation and wiring of dependencies
		// Going forward, we want Spring Framework to manage the above step
		gameRunner.run();
		
		/**
		 * POJO -> Any Java Object is called as POJO Class 
		 * POJO refers to Plain Old Java Object
		 * 
		 * Java Beans -> Refers to Enterprise Java Beans (No longer being used)
		 * Has 3 constraints
		 * 1. should have no arg default public constructor (Java will provide by default even if not 
		 * 	mentioned
		 * 
		 * 2. Should have getter n setter methods
		 * 3. Class should implement Serializable
		 * 
		 * Spring Bean
		 * - Any Java object that is managed by Spring (Spring uses IOC Container to manage beans)
		 * 
		 *  
		 * 
		 * 
		 */

	}

}
