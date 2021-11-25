package contents.week4.study;

import java.util.Timer;
import java.util.TimerTask;

public class TimerEx1 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer");
            }
        };

        timer.schedule(task, 5000);
    }
}
