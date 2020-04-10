package com.java8.practice.lambdaexpressiontest;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.java8.practice.custominterface.FunctionalInterfaceImplWithoutLambda;
import com.java8.practice.functionalinterface.FunctionalInterfaceBasic;
import com.java8.practice.functionalinterface.FunctionalInterfaceInheritence;
import com.java8.practice.functionalinterface.FunctionalInterfaceWithAnnotation;

public class LambdaExpressionTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//Method 1
		FunctionalInterfaceBasic fi = new FunctionalInterfaceImplWithoutLambda();
		fi.printHelloWord();
		
		//Above in lamdaexpression
		/*
		 * To invoke lambda expression we need FI
		 */
		
		/**
		 * public void printHelloWord() {
		 * System.out.println("Hello");
		 * }
		 * 
		 * Above method transformed to lambda
		 * remove access modifier,return type,name of method, it becomes
		 * () { System.out.println("Hello"); }
		 * Equivalent lambda expression
		 * ()->{ System.out.println("Hello"); }
		 * To optimize we can remove {} since in method there is only one statement. So it becomes
		 * ()->System.out.println("Hello");
		 */
		
		FunctionalInterfaceBasic fi_lambda= ()->System.out.println("\n\nImplemented FunctionalInterfaceBasic with Lambda basic");
		fi_lambda.printHelloWord();
		fi_lambda.printDefault();
		FunctionalInterfaceBasic.printStatic();
		
		/*
		 *Invoking fi_inheritence with lambda 
		 */
		
		
		FunctionalInterfaceInheritence fi_inheritence =()->System.out.println("\n\nImplemented FunctionalInterfaceInheritence with Lambda basic");
		fi_inheritence.printHelloWord();
		fi_inheritence.printDefault();
		FunctionalInterfaceInheritence.printStatic();
		
		/*
		 * Implementing FunctionalInterfaceWithAnnotation with lambda
		 */
		FunctionalInterfaceWithAnnotation fi_withAnnotation=(a,b)->{
			if(a>b)
			{
				return a;
			}
			else
			{
				return b;
			}
		};
		
		//Using ternary operator
		//FunctionalInterfaceWithAnnotation fi_withAnnotation=(a,b)->a>b?a:b;
		
		System.out.println("\n\nFound highest by lamda=="+fi_withAnnotation.findHighest(10, 20));
		fi_withAnnotation.printDefault();
		
		
		/*
		 * Implement Runnable interface using lambda. It can be used for multi threading
		 */
		
		Runnable runnable = ()-> {
			for (int i =0; i<10; i++)
			{
				System.out.println("Child thread");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1= new Thread(runnable);
		t1.start();
		
		Runnable runnable1 = ()-> {
			for (int i =0; i<10; i++)
			{
				System.out.println("Child thread2");
			}
		};
		runnable1.run();
		Thread t2= new Thread(runnable1);
		t2.start();
		System.out.println();
		
		/*
		 * Implement Callable interface using lambda. It can be used for multi threading
		 */
		
		Callable<Integer> callable = ()->{
			Random generator = new Random(); 
		    Integer randomNumber = generator.nextInt(5); 
		  
		    Thread.sleep(randomNumber * 1000); 
		  
		    return randomNumber; 			
		};
		
		FutureTask<Integer> randomNumberTasks = new FutureTask<Integer>(callable);
		
		Thread t_callable=new Thread(randomNumberTasks);
		t_callable.start();
		System.out.println(randomNumberTasks.get());
		
		
	}

}
