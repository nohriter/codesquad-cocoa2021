package first_week.first_day.loop_example;

import java.util.Scanner;

public class Loop_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCount = Integer.parseInt(scanner.next());
        String number = scanner.next();

        String[] numbers = number.split("");
        
        int sum = 0;
        
        for(int i=0; i < numberCount; i++) {
            sum += Integer.parseInt(numbers[i]);
        }

        System.out.println(sum);
    }
}
