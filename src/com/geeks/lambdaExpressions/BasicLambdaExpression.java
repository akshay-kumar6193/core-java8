package com.geeks.lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.geeks.model.Employee;

public class BasicLambdaExpression {

	public static void main(String[] args) {

		// Declare individual Employee

		Employee akshay = new Employee("Akshay", 20000);
		Employee ankur = new Employee("Ankur", 10000);
		Employee aman = new Employee("Aman", 5000);
		Employee ankit = new Employee("Ankit", 50000);
		Employee atul = new Employee("Atul", 60000);

		List<Employee> empList = Arrays.asList(akshay, ankur, aman, ankit, atul);

		// using Comparator interface without lambda expression
		Comparator<Employee> byName = new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				// TODO Auto-generated method stub
				return e1.getName().compareTo(e2.getName());
			}
		};

		// using comparator with lambda expression
		Comparator<Employee> byNameLambda = (e1, e2) -> e1.getName().compareTo(e2.getName());

		Collections.sort(empList, byNameLambda);
		System.out.println(empList);

		// using compact runnable object
		Runnable r = () -> {
			System.out.println("A runnable thread");
		};
		Thread t1 = new Thread(r);

		// using compact thread object
		Thread t2 = new Thread(() -> System.out.println("A runnable thread without runnable object"));

	}

}
