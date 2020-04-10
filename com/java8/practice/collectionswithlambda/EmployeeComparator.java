package com.java8.practice.collectionswithlambda;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		 return o1.getId() > o2.getId() ? -1 : o2.getId()>o1.getId() ? 1: 0; 
	}
	

}
