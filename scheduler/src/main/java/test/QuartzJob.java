package test;

import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/** 
* @author 作者 bofei
* @version 创建时间：2017年7月27日 下午4:12:40 
*/
public class QuartzJob implements org.quartz.Job {
    public QuartzJob() {
    }

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Test: " + Calendar.getInstance().getTime());
    }
}
