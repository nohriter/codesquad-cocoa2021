package first_week.first_day.star_example;

import java.util.Scanner;

public class STAR2439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            for (int k = (count-1) - i; k > 0; k--) {
                System.out.print(" ");
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
