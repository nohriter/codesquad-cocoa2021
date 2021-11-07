package mission.week1.day1.if_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());

        String answer = compare(number1, number2);

        System.out.println(answer);
    }

    private static String compare(int number1, int number2) {
        if (number1 > 0) {
            if (number2 > 0) {
                return "1";
            }
            return "4";
        }

        if (number1 < 0) {
            if (number2 > 0) {
                return "2";
            }
            return "3";
        }

        return "";
    }
}
