package com.java8.practice.collectionswithlambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Used method reference for printing and comparator
 * @author debojit
 *
 */
public class SortingWithComparator {
	
	/*
	 * Static method will be used in method reference of Comparator method compareTo()
	 */
	public static int employeeComparator(Employee o1, Employee o2)
	{
		return o1.getId() > o2.getId() ? -1 : o2.getId()>o1.getId() ? 1: 0;
	}
	
	public static void main(String[] args) {
		
		List<Employee> l1 = new ArrayList<>();
		l1.add(new Employee(1007,"John"));
		l1.add(new Employee(1001,"Katie"));
		l1.add(new Employee(1002, "Luis"));
		
		System.out.println("List maintains insertion orders->"+l1);
		
		/* Using method reference of println method odSystem.out class.
		 * forEach takes Consumer interface as parameter. It is a functional interface, so we can iplement its accept method
		 * using method reference
		 */
		System.out.println("\nPrinting using method reference\n");
		l1.forEach(System.out::println);
		
		System.out.println("\nPrinting using lamda\n");
		l1.forEach(list->System.out.println(list));
		/*
		 * If comparable interface is not implemented by Employee object, then it will give
		 */
		//Sorting on basis of comparable interface, since we have not passed comparator.
		Collections.sort(l1);
		System.out.println("\nSorting on basis of comparable interface, since we have not passed comparator");
		System.out.println(l1);
		
		List<Employee> l2 = new ArrayList<>();
		l2.add(new Employee(1007,"John"));
		l2.add(new Employee(1001,"Katie"));
		l2.add(new Employee(1002, "Luis"));
		
		/*
		 * Sorting of elements by passing comparator in legacy way 
		 * Moreover If we are passing comparator, it will override the compare method of comparable 
		 * interface implemented
		 */
		System.out.println("\nList maintains insertion orders->"+l2);
		Collections.sort(l2, new EmployeeComparator());
		System.out.println("Sorting of elements by passing comparator in legacy way");
		System.out.println(l2);
		
		//Sorting of elements by passing comparator in Using lambda expression
		List<Employee> l3 = new ArrayList<>();
		l3.add(new Employee(1007,"John"));
		l3.add(new Employee(1001,"Katie"));
		l3.add(new Employee(1002, "Luis"));
		
		System.out.println("\nList maintains insertion orders->"+l3);
		
		/*
		 * Commented out below code since, we can write the lambda expression directly in sort() method
		 */
		//Comparator<Employee> employeeCoparator = (o1,o2)->o1.getId() > o2.getId() ? -1 : o2.getId()>o1.getId() ? 1: 0;
		//Collections.sort(l3, employeeCoparator);
		Collections.sort(l3, (o1,o2)->o1.getId() > o2.getId() ? -1 : o2.getId()>o1.getId() ? 1: 0);
		System.out.println("Sorting of elements by passing comparator in Using lambda expression");
		System.out.println(l3);
		
		Collections.sort(l3, SortingWithComparator::employeeComparator);
		System.out.println("Sorting of elements by passing comparator in Using method reference");
		System.out.println(l3);
		
		//===================================================================================================================
		//===================================================================================================================
		//===================================================================================================================
		
		/**
		 * Tree set stores the elements in Natural Sorting order
		 * For custom objects, objects needs to implement comparable interface.
		 * If it is not implemented, then it will throw RunTimeException @ClassCastException
		 */
		
		/*
		 * Storing employee objects in comparablecomparing way
		 */
		  Set<Employee> s1 = new TreeSet<>();
		  
		  s1.add(new Employee(1007,"John")); 
		  s1.add(new Employee(1001,"Katie"));
		  s1.add(new Employee(1002, "Luis"));
		  
		  System.out.println("\nSorted elements on set on basis of comparable interface, since we have not passed comparator");
		  System.out.println(s1);
		 
		 /*
		  * Storing  elements in set using comparator in legacy way
		  */
		  Set<Employee> s2 = new TreeSet<>(new EmployeeComparator());
		  
		  s2.add(new Employee(1007,"John")); 
		  s2.add(new Employee(1001,"Katie"));
		  s2.add(new Employee(1002, "Luis"));
		  
		  System.out.println("\nSorted elements on set by passing comparator in legacy way");
		  System.out.println(s2);
		  
		  /*
		   * Storing  elements in set using comparator in lambda expression
		   */
		  Set<Employee> s3 = new TreeSet<>((o1,o2)->o1.getId()>o2.getId()?-1:o2.getId()>o1.getId()?1:0);
		  
		  s3.add(new Employee(1007,"John")); 
		  s3.add(new Employee(1001,"Katie"));
		  s3.add(new Employee(1002, "Luis"));
		  
		  System.out.println("\nSorted elements on set by passing comparator in lambda expression way");
		  System.out.println(s3);
		  
		  //==================================================================================================================
		  //==================================================================================================================
		  //===================================================================================================================
		
		  /**
		   * ******************************************************
		   * Sorting of map depends on KEY not on values by default
		   * ******************************************************
		   * 
		   * Putting elements in Tree Map, Key is Employee object which implements comparable interface and 
		   * override compare methods to sort as per id.
		   * For custom objects used as key, objects needs to implement comparable interface.
		   * If it is not implemented, then it will throw RunTimeException @ClassCastException
		   */
		  Map<Employee,Department> map1 = new TreeMap<>();
		  
		  map1.put(new Employee(1007,"John"), new Department(195,"PWD"));
		  map1.put(new Employee(1001,"Katie"), new Department(7,"MED"));
		  map1.put(new Employee(1002,"Luis"), new Department(2,"POWER"));
		  
		  System.out.println("\nSorted elements on map on basis of comparable interface, since we have not passed comparator");
		  System.out.println(map1);
		  
		  Map<Employee,Department> map2 = new TreeMap<>(new EmployeeComparator());
		  
		  map2.put(new Employee(1007,"John"), new Department(195,"PWD"));
		  map2.put(new Employee(1001,"Katie"), new Department(7,"MED"));
		  map2.put(new Employee(1002,"Luis"), new Department(2,"POWER"));
		  
		  System.out.println("\nSorted elements on map on basis of comparator in legacy way");
		  System.out.println(map2);
		  
		  Map<Employee,Department> map3 = new TreeMap<>((o1,o2)->o1.getId()>o2.getId()?-1:o2.getId()>o1.getId()?1:0);
		  
		  map3.put(new Employee(1007,"John"), new Department(195,"PWD"));
		  map3.put(new Employee(1001,"Katie"), new Department(7,"MED"));
		  map3.put(new Employee(1002,"Luis"), new Department(2,"POWER"));
		  
		  System.out.println("\nSorted elements on map on basis of comparator in lambda exression way");
		  System.out.println(map3);
		  
		
	}

}
