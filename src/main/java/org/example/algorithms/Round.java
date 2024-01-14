package org.example.algorithms;

public class Round {
    public static void main(String[] args) {
        double number = 42.342342;

        // round 함수는 소수점 첫째자리까지만 반올림 가능해서, 다른자릿수의 반올림을 원한다면 별도로 가공을 해줘야 한다
        // 본 문제에서는 소수점 둘째자리까지 반올림을 하여 나타내는 문제였다
        double roundedNumber = Math.round(number * 100.0) /  100.0;
        System.out.println(roundedNumber);

    }
}
