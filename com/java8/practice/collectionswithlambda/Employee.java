package com.java8.practice.collectionswithlambda;

/**
 * 
 * @author debojit
 * Object in collection can be sort in two ways
 * i) Implementing comparable interface
 * ii) Creating custom comparator by implementing Comparator Interface, like EmployeeComparator
 */
public class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.getId() > o.getId() ? 1 : o.getId()>this.getId() ? -1: 0;
	}
	
	
	
	
	
	

}
