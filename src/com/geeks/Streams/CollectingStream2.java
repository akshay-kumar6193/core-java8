package com.geeks.Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.geeks.model.City;


public class CollectingStream2 {

	public static void main(String[] args) {
		
		Set<String> st
        = Stream
              .of("GEEKS", "FOR", "GEEKS").collect(Collectors.collectingAndThen(Collectors.toSet(),
            		  Collections::<String> unmodifiableSet));
		
		System.out.println(st);
		
		 Map<String, String> mp
         = Stream
               .of(new String[][] {
                   { "1", "Geeks" },
                   { "2", "For" },
                   { "3", "Geeks" } })
               .collect(
                   Collectors
                       .collectingAndThen(
                           Collectors.toMap(p -> p[0], p -> p[1]),
                           Collections::<String, String>
                               unmodifiableMap));
		 
		 System.out.println(mp);
		
		 System.out.println("Total count: "+prepareTemperature().stream().collect(Collectors.counting()));
		 
		 
		 System.out.println(prepareTemperature().stream().collect
				 (Collectors.groupingBy(City::getName,Collectors.counting())));
		 
		System.out.println(prepareTemperature().stream().
				collect(Collectors.groupingBy(City::getName, Collectors.groupingBy(City::getTemperature))));
		
		System.out.println(prepareTemperature().stream().collect(Collectors.groupingBy
				(City::getName,Collectors.mapping(City::getTemperature,Collectors.toList()))));
	
		 Map<Boolean, List<City>> out=prepareTemperature().stream().collect(Collectors.partitioningBy(x->x.getTemperature()>15));
		 
		 Map<Boolean, Set<City>> out1=prepareTemperature().stream().collect(Collectors.partitioningBy(x->x.getTemperature()>15
				 ,Collectors.toSet()));
			Stream.of(out,out1).forEach(System.out::println);
			
	
	
	}
	

private static List<City> prepareTemperature()
{
    List<City> cities = new ArrayList<>();
    cities.add(new City("New Delhi", 33.5));
    cities.add(new City("Mexico", 14));
    cities.add(new City("New York", 13));
    cities.add(new City("Dubai", 43));
    cities.add(new City("London", 15));
    cities.add(new City("Alaska", 1));
    cities.add(new City("Kolkata", 30));
    cities.add(new City("Sydney", 11));
    cities.add(new City("Mexico", 15));
    cities.add(new City("Dubai", 43));
    return cities;
}
	
}
