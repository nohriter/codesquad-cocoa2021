package contents.week1.day_01.mission.star_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class STAR2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {

            for (int j = (count - i) - 1; j > 0; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j < (2 * i) + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < count-1; i++) {
            for(int j=0; j < i+1; j++) {
                System.out.print(" ");
            }

            for(int j=(((count-i)-1)*2)-1; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
