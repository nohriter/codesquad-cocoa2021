package contents.week4.study;

import java.util.Timer;
import java.util.TimerTask;

public class TimerEx2 {

    public static int count;

    public static void main(String[] args) {
        count = 0;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (count < 5) {
                    System.out.println("timer");
                    count++;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 5000, 2000);
    }

}
