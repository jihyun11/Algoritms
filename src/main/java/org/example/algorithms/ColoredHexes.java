package org.example.algorithms;

public class ColoredHexes {

    public static String hexColor(String codes) {
        if (codes == null || codes.isEmpty() || codes.equals("000 000 000")) {
            return "black";
        }
        String[] colors = codes.split(" ");
        int red = Integer.parseInt(colors[0]);
        int green = Integer.parseInt(colors[1]);
        int blue = Integer.parseInt(colors[2]);
        if (red == blue && blue == green) {
            return "white";
        } else if (red > green && red > blue) {
            return "red";
        } else if (green > red && green > blue) {
            return "green";
        } else if (blue > red && blue > green) {
            return "blue";
        } else if (red == blue) {
            return "magenta";
        } else if (green == red) {
            return "yellow";
        } else if (blue == green) {
            return "cyan";
        }
        return "";
    }

    public static void main(String[] args) {
        String codes = "008 123 076";
        System.out.println(hexColor(codes));
    }

}
