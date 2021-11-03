package week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan {

    public static void main(String[] args) throws IOException {

        String[] danArray = InputDan();

        int startDan = Integer.parseInt(danArray[0]);
        int endDan = Integer.parseInt(danArray[1]);

        printGugudan(startDan, endDan);
    }

    private static String[] InputDan() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("시작단과 끝단을 입력해주세요.");

        String dan = bufferedReader.readLine();

        return dan.split(" ");
    }

    private static void printGugudan(int startDan, int endDan) {
        for (int i = startDan; i <= endDan; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " x " + j + " = " + i * j);
            }
            System.out.println();
        }
    }

}
