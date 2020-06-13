package test;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** 
* @author 作者 bofei
* @version 创建时间：2017年7月27日 下午4:06:35 
*/
public class Job_Schedule_Test3 {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        long delay = 2;
        long interval = 1;

        // 从现在开始 2 秒钟之后启动，每隔 1 秒钟执行一次
        service.scheduleAtFixedRate(
                new JobTask2(), delay,
                interval, TimeUnit.SECONDS);
    }
}

class JobTask2 implements Runnable {
    public void run() {
        System.out.println("Test: " + Calendar.getInstance().getTime());
    }
}
