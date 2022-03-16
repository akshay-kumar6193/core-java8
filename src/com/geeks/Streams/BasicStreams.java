package com.geeks.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.geeks.model.Employee;

public class BasicStreams {
public static void main(String[] args) {
	
	
	Employee e1=new Employee("Alexander", 10000);
	Employee e2=new Employee("Alex", 2000);
	Employee e3=new Employee("Bernard", 900);
	Employee e4=new Employee("Putin", 100);
	
	List<Employee> empList = Arrays.asList(e1, e2, e3, e4);

	// Print name of all employees with salary greater than 500 and alphabetically
	
	List<Employee> empSalList=empList.stream().filter((e)->e.getSalary()>500).collect(Collectors.toList());
	
	Comparator<Employee> compareSalary=Comparator.comparing(Employee::getName);

//	Collections.sort(empSalList,compareSalary);
//	
//	System.out.println(empSalList);
//	
	//Compact for above case
	
		empList.stream().filter((e)->e.getSalary()>500).
			map(Employee::getName).sorted().forEach(e->System.out.print(e+" "));
	
	
}
}
