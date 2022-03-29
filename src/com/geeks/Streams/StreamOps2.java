package com.geeks.Streams;

import java.util.stream.Stream;

public class StreamOps2 {
	public static void main(String[] args) {

		Stream.of("ABC","BD","CAC").peek(x->System.out.print(x+" ")).filter(x->x.length()>2).forEach(System.out::println);
		
		
		System.out.println("AnyMatch : "+Stream.of("ABC","BD","CAC").anyMatch(x->x.equals("ABC")));
		System.out.println("AllMatch : "+Stream.of("ABC","BD","CAC").allMatch(x->x.equals("ABC")));
		System.out.println("NoneMatch : "+Stream.of("ABC","BD","CAC").noneMatch(x->x.equals("AC")));
		
		// difference between toArray() and reference to array allocator
		Object[] objArr=Stream.of("ABC","BD","CAC").filter(x->x.length()>2).toArray();
		
		String[] strArr=Stream.of("ABC","BD","CAC").filter(x->x.length()>2).toArray(String[]::new);
		
		
	}
}
