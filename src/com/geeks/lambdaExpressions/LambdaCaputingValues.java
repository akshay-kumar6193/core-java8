package com.geeks.lambdaExpressions;

import java.util.Iterator;
import java.util.function.Consumer;

public class LambdaCaputingValues {

	public static void main(String[] args) {

		System.out.println("Anonymous class");

		for (int i = 0; i < 5; i++) {

			// Anonymous consumer implementation,created seperate instance
			Consumer<String> printer = new Consumer<String>() {
				@Override
				public void accept(String msg) {
					// TODO Auto-generated method stub
					System.out.println(msg);
				}
			};
			printer.accept(printer.toString());
		}
		System.out.println("Capturing lambda ,with same instance");
		// using lambda expression ,same instance used
		Consumer<String> myprinter = msg -> System.out.println(msg);
		for (int i = 0; i < 5; i++) {
			myprinter.accept(myprinter.toString());
		}

		// capturing instance lambda expression

		System.out.println("Capturing lambda expression with instance variable");
		new LambdaCaputingValues().foo();
		System.out.println("Capturing lambda expression without instance variable");
		new LambdaCaputingValues().loo();

	}

	public void foo() {

		int num = 5;
		for (int i = 0; i < 5; i++) {
			Consumer<String> myprinter = msg -> System.out.println(msg + "----" + num);
			myprinter.accept(myprinter.toString());
		}

	}

	public void loo() {

		for (int i = 0; i < 5; i++) {
			Consumer<String> myprinter = msg -> System.out.println(msg + "----");
			myprinter.accept(myprinter.toString());
		}

	}

}
