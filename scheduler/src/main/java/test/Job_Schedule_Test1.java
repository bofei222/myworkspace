package test;

import java.util.Calendar;

/** 
* @author 作者 bofei
* @version 创建时间：2017年7月27日 下午3:57:41 
*/
public class Job_Schedule_Test1 {
    public static void main(String[] args) {
        new JobThread().start();
    }
}

class JobThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Test: " + Calendar.getInstance().getTime());

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

