package org.example.algorithms;

import java.util.ArrayList;

public class NumberJelly {



    public static void main(String[] args) {
        ArrayList<String> num = new ArrayList<>();
        ArrayList<String> odd = new ArrayList<>();
        int[] num_list = {5, 7, 8, 3};
        for(int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                num.add(String.valueOf(num_list[i]));
            }
            if (num_list[i] % 2 != 0) {
                odd.add(String.valueOf(num_list[i]));
            }
        }
        System.out.println(num);
        System.out.println(odd);

        String num1 = String.join(",", num);
        String num2 = num1.replace(",", "");

        String odd1 = String.join(",", odd);
        String odd2 = odd1.replace(",", "");
        System.out.println(odd2);

        int totalNum = Integer.parseInt(num2);
        int totalOdd = Integer.parseInt(odd2);

        System.out.println(totalNum + totalOdd);


    }
}