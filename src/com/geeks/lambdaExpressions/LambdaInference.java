package com.geeks.lambdaExpressions;

import java.util.function.Consumer;

public class LambdaInference {

	public static void main(String[] args) {

		// Standard syntax:
		Consumer<String> c1 = (String s1) -> System.out.println(s1.toUpperCase());
		c1.accept("java");
		// OK: cast added
		Object o1 = (Consumer<String>) ((String s1) -> System.out.println(s1.toUpperCase()));

		// OK: but inference type of object
		Consumer<?> c2 = (s1) -> System.out.println(s1);

		// OK: inference type of String
		Consumer<?> c3 = (String s1) -> System.out.println(s1.toUpperCase());

	}

}
