package com.geeks.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ReduceStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  List<String> words = Arrays.asList("GFG", "Geeks", "for",
                  "GeeksQuiz", "Geeky");

		  Optional<String> longestString = words.stream().
				  reduce((word1, word2)->word1.length()>word2.length()?word1:word2);
		 
		  System.out.println(longestString); //output: Optional[GeeksQuiz]
		 
		  longestString.ifPresent(System.out::println); //output: GeeksQuiz
		  
		  longestString.ifPresentOrElse(System.out::println,()->System.out.println("not present"));//output: GeeksQuiz
		  
		  Optional<String> combine=words.stream().reduce((word1,word2)->word1+","+word2);
		  String combineWithoutOptional =words.stream().reduce((word1,word2)->word1+","+word2).orElse("Empty");
		  
		  System.out.println(combineWithoutOptional);

		  
		  System.out.println(combine);
		  
		  int product = IntStream.range(2, 8)
                  .reduce((num1, num2) -> num1 * num2)
                  .orElse(-1);
		  
		  System.out.println(product);
		  
		  
		  
		  
	}

}
