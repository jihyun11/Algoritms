package org.example.algorithms;

public class OddEvenSort {
    public static String groupEvenOdd(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }

        result.append(" ");

        for(int i = 1; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "CodeWars";
        String result = groupEvenOdd(input);
        System.out.println(result);
    }
}
