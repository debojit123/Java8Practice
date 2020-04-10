package com.java8.practice.functionalinterface;

/*
 * In java 8 new annotation introduced to declare functional interface, it explicitly tell compiler that
 * interface should have only one abstract method, not more not less.
 * Using of annotation is not must to declare Functional Interface
 */

@FunctionalInterface
public interface FunctionalInterfaceWithAnnotation {
	
	public int findHighest(int a,int b);
	
	/*
	 * If we declare two or more abstract method compiler will throw error 
	 * "Invalid '@FunctionalInterface' annotation; FunctionalInterfaceWithAnnotation is not a functional interface"
	 */ 
	
	//public void printHelloWord();
	
	/*
	 * We can any number of default method and static methods
	 */
		default void printDefault()
		{
			System.out.println("In default method");
		}
		
		public static void printStatic()
		{
			System.out.println("In static method");
		}

}
