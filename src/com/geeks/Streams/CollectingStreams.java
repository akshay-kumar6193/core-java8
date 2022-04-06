package com.geeks.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.geeks.model.City;

public class CollectingStreams {

	
	public static void main(String[] args) {
	
		///get cities name with temp.>10
		
		List<String> citiesName= prepareTemperature().stream().filter(x->x.getTemperature()>10).
				map(City::getName).collect(Collectors.toList());
			System.out.println("List: "+citiesName.stream().collect(Collectors.joining(", ")));
		// to linkedList
			List<String> citiesLLLName= prepareTemperature().stream().filter(x->x.getTemperature()>10).
					map(City::getName).collect(Collectors.toCollection(LinkedList::new));
		
			System.out.println("LinkedList: "+citiesLLLName);
			
			//transform to set for above test.
			
			Set<String> citiesSet= prepareTemperature().stream().filter(x->x.getTemperature()>10).
					map(City::getName).collect(Collectors.toSet());
			System.out.println("Set: " +citiesSet);
			
			//to hashSet
			
			TreeSet<String> citiesHashSet= prepareTemperature().stream().filter(x->x.getTemperature()>10).
					map(City::getName).collect(Collectors.toCollection(TreeSet::new));
			System.out.println("HashSet :"+citiesHashSet);
				
			
			//to Map if not duplicate key
			Map<String,Double> duplicateMap=prepareTemperature().stream().filter(x->x.getTemperature()>10).
					collect(Collectors.toMap(City::getName, City::getTemperature,(key,Identity)->key));
			duplicateMap.forEach((k, v) -> System.out.print((k + ":" + v+" ")));

			System.out.println();
			
			// to Map if duplicate key use mergerFunction
			Map<String,Double> map=prepareTemperature().stream().
					filter(x->x.getTemperature()>10).
					collect(Collectors.toMap(City::getName, City::getTemperature,(key,Identity)->Identity));
			map.forEach((k,v)->System.out.print(k+":"+v+" "));
			
			
			System.out.println();
			// to Map if duplicate key use mergerFunction with supplier
			TreeMap<String,Double> mapwithSUpplier=prepareTemperature().stream().
					filter(x->x.getTemperature()>10).
					collect(Collectors.toMap(City::getName, City::getTemperature,(key,Identity)->Identity,TreeMap::new)
					);
			mapwithSUpplier.forEach((k,v)->System.out.print(k+":"+v+" "));;
			
			
			
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

