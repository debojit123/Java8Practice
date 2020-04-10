package com.java8.practice.methodreference;


public class EmployeeName {
	
	private String name;
	
	public EmployeeName()
	{
		System.out.println("No args constructor fired");
	}
	
	public EmployeeName(String name)
	{
		System.out.println("Arguement constructor fired");
		System.out.println("Argueent passed -> "+name);
	}
	
	/*
	 * Declared method as static since we can point any static method as a reference to Functional Interface abstract method
	 */
	public static void sayStudentName()
	{
		System.out.println("Student Name is Jessica");
	}
	
	public int addTwoNumbers(int a,int b)
	{
		return a+b;
	}

}
