package com.example.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		// 1. Launch Spring context
		// To handle the warning message of Resource leak. You need to have the Context
		// created with Try Catch block and close the context within Finally
		// We can utilize Java Latest Feature try with resources
		try (var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			
			// 2. Configure the things that we want spring to manage - we use Configuration
			// class
			// to keep all the things that we want spring to manage. (Spring is kind of
			// intermediate framework
			// between JVM and our objects. Instead of JVM directly managing objects, spring
			// will manage

			// 3. Retrieve Bean objects using the name
			// Bean Method name is the parameter name to be passed
			System.out.println(context.getBean("name"));
			// This would automatically invoke the toString method to print the Person
			// Object // Person[name=Abdul, age=31]
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("address2")); // Address[addressLine=23 Mary Street, city=New York]
			// Use NAme of Bean or Type of Bean to retrieve Bean
			System.out.println(context.getBean(Address.class)); // Error: No qualifying bean of type
			// 'com.example.learnspringframework.Address' available: expected single
			// matching bean but found 2: address2,address3

			System.out.println(context.getBean("person2MethodCall"));

			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("person5Qualifier"));

			// To get all Beans managed by Spring - Print it out using FUnctional
			// Programming
			// Arrays.stream(context.getBeanDefinitionNames())
			// .forEach(System.out::println);
		}

	}

}
