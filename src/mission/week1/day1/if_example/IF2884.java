package mission.week1.day1.if_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF2884 {
    public static void main(String[] args) throws IOException {
//       첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
//       그리고 이것은 현재 상근이가 설정한 놓은 알람 시간 H시 M분을 의미한다.
//       입력 시간은 24시간 표현을 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고,
//       끝은 23:59(다음날 자정 1분 전)이다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.

        String[] time = inputTime();

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        printAnswer(hour, minute);
    }

    private static void printAnswer(int hour, int minute) {
        if (minute - 45 < 0) {
            minute = (minute - 45) + 60;
            if(hour == 0) {
                hour = 24;
            }
            hour -= 1;
            System.out.println(hour + " " + minute);
            return;
        }
        minute -= 45;
        System.out.println(hour + " " + minute);
    }

    private static String[] inputTime() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String time = bufferedReader.readLine();

        String[] times = time.split(" ");
        return times;
    }
}
