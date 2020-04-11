package com.java8.practice.streams;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Streams are applied on collection object, so that operation on each object can be processed
 * and can be collected back
 * 
 * Once operation is done on one stream, you cannot use that stream anymore, it will give run time ERROR not run time exception.
 * @return 
 * 
 *
 */
public class StreamsFilterTest {
	
	 static void performListStream(ArrayList<Integer> list1)
	{

		//Converting list1 o stream of Integer objects
		Stream<Integer> stream =list1.stream();
		
		/* Perform filter on streams.
		 * filter() method take Predicate functional interface as argument.
		 */
		
		//Prepare predicate for filter method using lambda expresion
		
		Predicate<Integer> predicate = i->i%10==0;
		
		//Appending "and" condition of predicate. And method takes Predicate as arguement
		//This returns one more predicate
		Predicate<Integer> andPredicate = predicate.and(i->i%5==0);
		Predicate<Integer> orPredicate = predicate.or(i->i%5==0);
		
		//Using the predicate in filter method
		//filter method will return stream of processed objects
		Stream<Integer> processedStream = stream.filter(andPredicate);
		//Stream<Integer> processedStream = stream.filter(orPredicate);
		
		//Collect objects in list from processed stream
		System.out.println(processedStream.collect(Collectors.toList()));
		
		System.out.println("Combining all the predicates inline using lambda\n");
		
		//System.out.println(stream.filter(((Predicate<Integer>) i->i%5==0).or(i->i%2==0)).collect(Collectors.toList()));		
	}
	
	 static void performMapOnStream(ArrayList<Integer> list1) {
		 Stream<Integer> stream = list1.stream();
		 
		 /*
		  * map() method of stream takes "Function" functional interface as its argument
		  * Function<T> is a functional interface, which have only one abstract method "returnType apply(T parameter,T returnType)"
		  * first arugument is the type of elemnts on which it will perform operations, second is the return type of the method
		  * this method will perform the operation implemented in each of the elements in the stream.
		  * After function is applied to all the elements, map() method will return a new stream of processed elements
		  */
		 
		 //Prepare function
		 Function<Integer,Integer> f1 = i->i+4;
		 
		 /* Function chaining using compose() method of "Function" interface. It is a default method
		  * compose method takes one argument, compose(Function<T,R> before). That means function which is
		  * passed as argument will be applied before in the streams of elemnts
		  */
		 Function<Integer,Integer> f2=i->i*3;
		 Function<Integer,Integer> f3=f1.compose(f2);
		 
		 //Applying function on the initial Stream to get final stream
		 Stream<Integer> finalStream = stream.map(f3);
		 
		 //Collecting it as list
		 System.out.println(finalStream.collect(Collectors.toList()));
		 
		 System.out.println("\nChaining all the funtions in a singleline using lambda");
		 System.out.println(list1.stream().map(((Function<Integer,Integer>) i->i+4).compose(i->i-4)).collect(Collectors.toList()));
		 
	 }
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++)
		{
			list1.add(i*5);
		}
		
		//StreamsFilterTest.performListStream(list1);
		StreamsFilterTest.performMapOnStream(list1);
		
		
		
		
		
		
	}
	

}
