package com.example.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class SampleWorldConfiguration {

	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext(SampleHelloWorldSpring.class)){
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean(Addresses.class));
			System.out.println(context.getBean(PersonNew.class));
			
			
		}
		
		

	}

}
