package contents.week1.day_01.mission.star_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class STAR2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = ((count-i) * 2)-1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
