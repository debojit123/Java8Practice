package com.java8.practice.functionalinterface;

public interface FunctionalInterfaceBasic {
	
	//Any interface which contains only single abstract methods is called Functional Interface
	public void printHelloWord();
	
	//If we add two abstract methods, then it is not Functional Interface
	//public void add();
	
	//We can any number of default method nd static methods
	default void printDefault()
	{
		System.out.println("In default method");
	}
	
	public static void printStatic()
	{
		System.out.println("In static method");
	}
}
