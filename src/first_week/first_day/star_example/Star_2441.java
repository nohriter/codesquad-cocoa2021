package first_week.first_day.star_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star_2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = count - i; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
