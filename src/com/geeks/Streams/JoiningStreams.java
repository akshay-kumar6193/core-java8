package com.geeks.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningStreams {
	
	public static void main(String[] args) {
		
		List<String> str= Arrays.asList("abc","def","ghi");
		char[] ch = {'a','k','s','h','a','y'};
		
		// with delimiter
		
		String sh=Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining());
		System.out.println(sh);
		
		//with delimiter
		String strList=str.stream().map(String::valueOf).collect(Collectors.joining("-"));
		System.out.println(strList);
 		
		// with delimiter, prefix, suffix
		String chStrName=Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining("","[","]"));
		System.out.println(chStrName);
		
	}
	

}
