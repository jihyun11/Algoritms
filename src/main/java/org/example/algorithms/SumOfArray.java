package org.example.algorithms;

import java.util.Arrays;

public class SumOfArray {
    public static void main(String[] args) {
        Integer[] array = {5, 4, 2, 3};
        Arrays.sort(array);

        int minNumber = 0;

        for(int i = 0; i < array.length / 2; i ++) { // array.length / 2를 함으로써 중복값이 더해지는 것을 막음
            minNumber += array[i] * array[array.length - 1 - i]; // 해당 배열에서 가장 작은 숫자 * 가장 큰 숫자

        }

        System.out.println(minNumber);

    }
}
