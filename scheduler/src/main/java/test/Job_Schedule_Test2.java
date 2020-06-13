package test;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/** 
* @author 作者 bofei
* @version 创建时间：2017年7月27日 下午3:58:53 
*/
public class Job_Schedule_Test2 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay = 2000;
        long interval = 1000;

        // 从现在开始 2 秒钟之后启动，每隔 1 秒钟执行一次
        timer.schedule(new JobTask(), delay, interval);
    }
}

class JobTask extends TimerTask {
    public void run() {
        System.out.println("Test: " + Calendar.getInstance().getTime());
    }
}

