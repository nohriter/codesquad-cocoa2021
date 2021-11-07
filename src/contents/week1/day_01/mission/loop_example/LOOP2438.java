package contents.week1.day_01.mission.loop_example;

import java.util.Scanner;

public class LOOP2438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
