package com.java8.practice.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceInheritence extends FunctionalInterfaceBasic {
	
	/*
	 * If we inherit functional interface with another functional interface, and we don't declare any abstract
	 * method in child interface, it will not throw any error. Since, after inheritence compiler will find one abstract method 
	 * in child interface. 
	 * If we remove the annotation, compiler will not treat it as FI, hence there will be no eror
	 */
	
	/*
	 * If we declare new abstract method here, compiler will throw error.
	 */
	
	//public void getData();
	
	/*
	 * We can define same abstract method as it is in Parent interface, in this case, abstract method written in child interface
	 * is treated as overriden method. So apparently, there is only one AM. Hence it is FI.
	 */
	public void printHelloWord();
	
	/*
	 * If we write default method of same name as of parent interface, it will treated as overriden method
	 * Better to put @Override annotation
	 */
	@Override
	default void printDefault()
	{
		System.out.println("In default method of inherited");
	}
	
	public static void printStatic()
	{
		System.out.println("In static method of inherited");
	}

}
