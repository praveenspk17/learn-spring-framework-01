package com.example.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Name(String firstName, String lastName) {}
record Addresses(String line1, String line2) {}
record PersonNew(String city, Addresses address) {}


@Configuration
public class SampleHelloWorldSpring {
	
	@Bean
	public int age()
	{
		return 27;
	}
	@Bean
	@Primary
	public Addresses praveenAddr()
	{
		return new Addresses("187", "Kumaran St 1");
	}
	
	@Bean
	@Qualifier("AddrQualifier")
	public Addresses sampathAddr()
	{
		return new Addresses("287", "Kumaran St 1");
	}
	
	@Bean
	public PersonNew personInfo(@Qualifier("AddrQualifier") Addresses addr)
	{
		return new PersonNew("Salem", addr);
	}
	
	
	
	
	
}
