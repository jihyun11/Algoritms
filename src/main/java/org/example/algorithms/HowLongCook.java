package org.example.algorithms;

public class HowLongCook {
    public static void main(String[] args) {
        String neededPower = "100w";
        int minutes = 8;
        int seconds = 45;
        String power = "800w";

        int p1 = Integer.valueOf(neededPower.replace("w", ""));
        int p2 = Integer.valueOf(power.replace("w", ""));
        int s = (int)Math.ceil((minutes * 60. + seconds) * p1 / p2);

        String result = String.format("%d 분 %d 초", s/60, s%60);

        System.out.println(result);
    }
}
