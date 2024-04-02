package org.example.algorithms;

import java.util.Arrays;

public class PossibilitiesArray {
    public static boolean isArrayAllPossibilities(int[] a) {
        // 배열을 오름차순으로 정렬
        Arrays.sort(a);

        // 배열의 길이가 0이거나, 배열의 첫번째 요소가 0이 아닌 경우
        if (a.length == 0 || a[0] != 0)
            return false;

        // 배열을 순회하면서 각 요소가 이전 요소보다 1씩 증가하는지 확인
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1] + 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0, 3};
        int[] arr2 = {0, 1, 2, 2, 3};
        int[] arr3 = {0};

        System.out.println(isArrayAllPossibilities(arr1)); // Output: true
        System.out.println(isArrayAllPossibilities(arr2)); // Output: false
        System.out.println(isArrayAllPossibilities(arr3)); // Output: true
    }
}
