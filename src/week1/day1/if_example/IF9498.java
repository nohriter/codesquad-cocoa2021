package week1.day1.if_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF9498 {
    public static void main(String[] args) throws IOException {
        int score = inputScore();

        printRecord(score);
    }

    private static void printRecord(int score) {
        if (90 <= score && score <= 100) {
            System.out.println("A");
        }
        if (80 <= score && score < 90) {
            System.out.println("B");
        }
        if (70 <= score && score < 80) {
            System.out.println("C");
        }
        if (60 <= score && score < 70) {
            System.out.println("D");
        }
        if (100 < score && score < 60) {
            System.out.println("F");
        }
    }

    private static int inputScore() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(bufferedReader.readLine());
        return score;
    }
}
