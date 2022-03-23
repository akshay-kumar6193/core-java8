package com.geeks.lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.geeks.model.Employee;

public class ComposingFunctions {
	
	public static void main(String[] args) {
		
		
		Employee e1=new Employee("Alexander", 10000);
		Employee e2=new Employee("Alex", 2000);
		Employee e3=new Employee("Bernard", 900);
		Employee e4=new Employee("Putin", 100);
		
		List<Employee> empList = Arrays.asList(e1, e2, e3, e4);

		
		// Composing function with andThen and compose
		// andThen() -> Left to right
		// compose() -> Right to left
		Function<Employee,String> byName=Employee::getName;
		
		Function<String, Character> getFirstLetter= name->name.charAt(2);
		
		Function<Employee, Character> getEmployeeFirstName=byName.andThen(getFirstLetter);
		
		
		System.out.println(getEmployeeFirstName.apply(e1));
		
		//using Comparator for composing function
		
		Comparator<Employee> compareName=Comparator.comparing(Employee::getName);
		Comparator<Employee> compareSalary=Comparator.comparing(Employee::getSalary);
		
		Comparator<Employee> sort=compareName.thenComparing(compareSalary);
		
		Collections.sort(empList,sort);
		
		System.out.println(empList);
	}

}
