package com.learning;

public class Test {
    public static void main(String[] args) {
        System.out.println();
        //String str = "abb";
        String str = "aabbddd";
        
        int len = str.length();
        char prevChar = str.charAt(0);
        char currChar;
        String result = String.valueOf(prevChar);
        for (int i = 1; i < len; i++) {
            currChar = str.charAt(i);
            if (currChar == prevChar) {
                result = new StringBuilder(result).append(currChar).toString();
            } else {
                prevChar = currChar;
                result = String.valueOf(currChar);
            }
        }
        System.out.println(result);
        System.out.println(result.length());
    }
}
