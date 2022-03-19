package com.geeks.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.geeks.model.Employee;

// filter,maps
public class StreamOps {

	public static void main(String[] args) {
		
		Random random=new Random();
		
		Stream<Integer> stream=Stream.generate(random::nextInt);

		// Select 10 random distinct positive integer
		stream.filter(n->n>0 ).distinct().limit(10).forEach(System.out::println);
	
		// Java 9(takeWhile && dropWhile)->basicaaly used for sorted structures.
		// as name suggest takeWhile will print values until true & 
		// dropWhile until the statement is true
		
		//stream.takeWhile(n->n>10).forEach(System.out::println);
		//stream.dropWhile(n->n>10).forEach(System.out::println);
		
	
		System.out.println("\n \n");
		
		Employee ankur = new Employee("Ankur", 10000);
		Employee aman = new Employee("Aman", 5000);
		Employee ankit = new Employee("Ankit", 50000);
		Employee atul = new Employee("Atul", 60000);
		Employee akshay1 = new Employee("Atul", 20000);
		Employee akshay = new Employee("Akshay", 20000);

//		List<Employee> empList = Arrays.asList(akshay, ankur, aman, ankit, atul,akshay1);
		Stream<Employee> empStream=Stream.of(akshay, ankur, aman, ankit, atul,akshay1);
		
		
		// Print distinct name of employees in sorted order 
    	//	empStream.map(e->e.getName()).distinct().sorted().forEach(System.out::println);
		
		// Print top two employees with sorted order
		empStream.sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(2).
		map(Employee::getName).forEach(System.out::println);
		
		System.out.println(213 % 10);
		
	
	}
	
	
}
