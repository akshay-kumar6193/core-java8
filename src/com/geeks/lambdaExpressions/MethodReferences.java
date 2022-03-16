package com.geeks.lambdaExpressions;

import java.util.function.Function;

import com.geeks.model.Employee;

public class MethodReferences {

	public static <T>void  printAll(T[] arr,Function<T,String> funct ) {

		int i=0;
		for(T t: arr) {
			System.out.println(i++ +":\t"+funct.apply(t));
		}
		
	}
	
	public static void main(String[] args) {
		Employee dept[]=new Employee[5];
		dept[0]=new Employee("Alex", 5);
		dept[1]=new Employee("Brandon", 10);
		dept[2]=new Employee("Derex", 40);
		dept[3]=new Employee("Randson", 25);
		dept[4]=new Employee("EThan", 50);
		
		printAll(dept, Employee::getName);
		System.out.println("\n");
		printAll(dept,emp-> ""+ emp.getSalary());
	}
	
	
}
