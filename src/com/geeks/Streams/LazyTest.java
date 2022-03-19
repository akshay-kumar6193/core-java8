package com.geeks.Streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

// This test describes lazy operations are called on demand i.e when terminal operation on stream arises.
// Stream can only be traversed once.
public class LazyTest {

	public static void main(String[] args) {

		Random random = new Random();
		Supplier<Integer> supp = () -> {
			Integer rn = random.nextInt();
			System.out.println("inside supplier " + rn);
			return rn;
		};
		// a lazy test -> steam is not intialized untill a terminal operation is called.
		Stream<Integer> randomStream = Stream.generate(supp);

		// here once the terminal operation is called i.e forEach the values are
		// instialized
		// and all intermidiate operation action performed

		// comment the below statement to check for lazy evalution
		randomStream.limit(3).filter(s -> s > 0).forEach(System.out::println);

		System.out.println("\n  \n");

		Stream<Integer> fabnci = Stream.of(1, 1, 2, 3, 5);
		fabnci.forEach(System.out::print);

		// Exception in thread "main" java.lang.IllegalStateException: stream has
		// already been operated upon or closed
		// fabnci.forEach(System.out::println);
		Stream<Integer> limitFabnci = Stream.of(1, 1, 2, 3, 5);
		/*
		 * Exception in thread "main" java.lang.IllegalStateException: stream has 
		 * already been operated upon or closed 
		 * limitFabnci.limit(2); 
		 * limitFabnci.forEach(System.out::println);
		 */
		
		// To overcome above exception need to assign limit intermediate operation to another stream obj.
		  Stream<Integer> withLimit=limitFabnci.limit(3); 
		  withLimit.forEach(System.out::println);
		
		  
	}
	
}
