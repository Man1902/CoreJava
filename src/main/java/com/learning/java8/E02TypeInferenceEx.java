package com.learning.java8;

public class E02TypeInferenceEx {

	public static void main(String[] args) {
		StrLenLamda strLenLamda = (String s) -> s.length();
		System.out.println( strLenLamda.getLength("Hello World!") );
		
		strLenLamda = (s) -> s.length();
		System.out.println( strLenLamda.getLength("Hello Learner") );
		
		strLenLamda = s -> s.length(); // If single input arg
		System.out.println( strLenLamda.getLength("Hello Optimist") );
		
		printLength(s -> s.length());
	}
	
	private static void printLength(StrLenLamda strLenLamda){
		System.out.println(strLenLamda.getLength("Hello Altruist!"));
	}
}

interface StrLenLamda {
	int getLength(String s);
}
