package first_week.first_day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class If_1330 {
    public static void main(String[] args) throws IOException {
        String[] numberArray = inputNumbers();

        int number1 = Integer.parseInt(numberArray[0]);
        int number2 = Integer.parseInt(numberArray[1]);

        String answer = compare(number1, number2);

        System.out.println(answer);
    }

    private static String compare(int number1, int number2) {
        if(number1 > number2) {
            return ">";
        }

        if(number1 < number2) {
            return "<";
        }

        return "==";
    }

    private static String[] inputNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String numbers = bufferedReader.readLine();

        String[] numberArray = numbers.split(" ");
        return numberArray;
    }
}
