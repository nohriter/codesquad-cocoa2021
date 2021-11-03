package week1.day1.star_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class STAR2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        0  9  0
//        1  7  0
//        2  5  2
//        3  3  3
//        4  1  4
        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            for(int j=0; j < i; j++) {
                System.out.print(" ");
            }
            for(int j=((count-i)*2)-1; j > 0; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
        for (int i = 0; i < count-1; i++) {
            for(int j=count-2-i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int j=0; j < ((i+1)*2)+1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
