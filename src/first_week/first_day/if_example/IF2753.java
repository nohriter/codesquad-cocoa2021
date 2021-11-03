package first_week.first_day.if_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF2753 {
    public static void main(String[] args) throws IOException {
//        윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.

        int year = inputYear();

        printAnswer(year);
    }

    private static void printAnswer(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
           System.out.println("1");
           return;
        }

        System.out.println("0");
    }

    private static int inputYear() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(bufferedReader.readLine());
    }
}
