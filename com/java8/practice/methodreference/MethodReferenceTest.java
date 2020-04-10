package com.java8.practice.methodreference;

public class MethodReferenceTest {
	
	public MethodReferenceTest() {
		// TODO Auto-generated constructor stub
	}
	
	private int i;
	
		//Suppose we need to refer one constructor implementation without instantiating the class
		//Also we can use constructor to instantiate field without instantiating named class
		public MethodReferenceTest(int i) {
			super();
			this.i = i;
			System.out.println("Contructor Thread is running....");
			for(int j=i;j<5;j++)
			{
				System.out.println("Thread number"+j+1);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//static method to be used in static method reference
		public static void displayThreadCount()
		{
			System.out.println("Thread is running....");
			for(int i=0;i<5;i++)
			{
				System.out.println("Thread number"+i+1);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		//instance method to be used in instance method reference
		public void instanceReferenceThread()
		{
			System.out.println("Thread is running....");
			for(int i=0;i<5;i++)
			{
				System.out.println("Instance Ref Thread number"+i+1);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		public static void main(String[] args) {
			
			/**
			 *Method reference is another way to implement abstract method of functional interface with any other static 
			 *method of any other class.
			 * **Points to remember**
			 *1. Static methods can be used as method reference e. ClasssName::staticMethodName
			 *2. Number of method argument in interface function and function which will be refereed should be same
			 *3. Return type and modifiers can be different.
			 *4. Instance Method can be used as method reference
			 */
			FuncInterface f = EmployeeName::sayStudentName;
			f.sayHello();
			
			/*
			 * Implemented Runnable interface run() method with static method displayThreadCount()
			 * lamda expression can be replaced using method referene
			 */
			Thread t = new Thread(MethodReferenceTest::displayThreadCount);
			t.start();
			
		}

}
