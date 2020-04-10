package com.java8.practice.methodreference;

/**
 * Constructor reference can be used if we need to initialize any abstract method of 
 * with an constructor without creating object.
 * 
 * **Point(s) to remember
 * 1. Only abstract method of Functional Interface can be used in method reference
 * 2. Constructor which will be referred should have same number no of arguement as the abstract method
 * 
 *  ** By Constructor reference we can achieve functions of a class by not creating any object of the class
 *     Rather than that we are assigning it to Functional Interface so that, its abstract method can be 
 *     used for object initialization
 *
 * @author debojit
 *
 */
public class ConstructorReferenceTest {
	
	public static void main(String[] args) {
		
		FuncInterface f1 = EmployeeName::new;
		f1.sayHello();
		
		//Arguement constructor refered to FunctionlInterface2 printArgs abstract method
		//Then used the object returned by the printArgs method to access other instance methods of EployeeName class.
		FunctionalInterface2 f2 = EmployeeName::new;
		EmployeeName em = f2.printArgs("Debojit");
		
		System.out.println(em.addTwoNumbers(5, 7));
	}

}
