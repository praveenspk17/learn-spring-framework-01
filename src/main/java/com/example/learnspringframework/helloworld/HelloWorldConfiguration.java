package com.example.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Record is JDK 16 Feature. Where we can eliminate all the verbiose of Getter/ Setter method
// If we have Record declaration - then by default Getter/ Setter are created in-built with default
// constructor matching the arguments with toString and equals methods.
//Adding Address as well
record Person(String name, int age, Address address){ };

record Address(String addressLine, String city) { };
	
/**
 * Spring Context or Spring Container -> Manages Spring Beans and their Life Cycle.
 * Also called as IOC Container (IOC refers to Inversion of Control)
 * 
 * - This creates Objects in Ready State to be consumed.
 * Types of Spring Container
 * 1. Bean Factory - Basic Spring Container (some kind of IOT applications)
 * 2. Application Context - Advanced Spring Container with enterprise specific features
 *  - Easy to use in Web Applications
 *  - Easy internationalization
 *  - Easy to integrate with Spring AOP (Aspect Oriented Programming)
 *  Recommended for REST APIs, Microservices etc.
 *  
 *  ....
 *  When we have multiple Bean methods (Eg: person, person2, person3) but of same type Person. 
 *  Then there need to be given some priority if you are planning to retrieve Bean based on 
 *  some Type
 */
// To indicate the configuration class
@Configuration
public class HelloWorldConfiguration {
	
	@Bean // Indicate the method that produces object that need to be managed by container
	public String name()
	{
		return "Praveen";
	}
	
	@Bean
	public int age()
	{
		return 27;
	}
	
	@Bean
	public Person person()
	{
		return new Person("Abdul", 31,new Address("23 Gandhi Street", "Chicago") );
	}
	
	//To update the name of the Bean use name attribute
	@Bean(name = "address2")
	@Primary
	public Address address()
	{
		return new Address("23 Mary Street", "New York");
	}
	
	//To update the name of the Bean use name attribute
		@Bean(name = "address3")
		@Qualifier("address3qualifier")
		//This annotation to notify framework not to use default instead to use this while auto wiring
		public Address address3()
		{
			return new Address("12 Kovil Street", "Salem");
		}
	
	//In order to show case Bean relationship - one bean depends on another
	// For Eg: if creating another Person object -> that utilizes name and age(existing Bean)
	@Bean
	public Person person2MethodCall()
	{
		return new Person(name(), age(), address()); // Utilizing Bean method calls
	}
	// Alternative way to invoke Beans that are already managed by Spring
	@Bean
	@Primary
	public Person person3Parameters(String name, int age, Address address3) // Pass the actual bean name as parameters
	{
		return new Person(name, age, address3); // Utilizing Bean method calls
	}
	//Here we are trying to autowire, but we dont have any Bean named 'address' so it throws error
	//: No qualifying bean of type 'com.example.learnspringframework.Address' available: 
	//expected single matching bean but found 2: address2,address3 
	// If we make one Bean as Primary, then this error would not occur
	@Bean
	public Person person4Parameters(String name, int age, Address address) 
	{
		return new Person(name, age, address); // Utilizing Bean method calls
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) 
	{
		return new Person(name, age, address); // Utilizing Bean method calls
	}
	
}
