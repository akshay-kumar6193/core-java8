package com.geeks.Test;


public class Test {

	public static void main(String[] args) {

		// NOTE: The following input values will be used for testing your solution.
      System.out.println(nonRepeating("abcab")); // should return 'c'
      System.out.println(nonRepeating("abab")); // should return null
        System.out.println(nonRepeating("aabbbc")); // should return 'c'
        System.out.println(nonRepeating("aabbdbc")); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
    	int ch[]=new int[256];
    	Character result=null;
    	for (int i = 0; i < s.length(); i++) {
			ch[s.charAt(i)]++;
		}
    	for (int i = 0; i < ch.length; i++) {
			if(ch[i]==1) { 
				result=(char)i;
				break;
				
				}
		}
    	
    	
        return result;
    }
}
