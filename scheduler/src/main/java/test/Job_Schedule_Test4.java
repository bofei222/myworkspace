package test;


import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;

import java.util.Calendar;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Job_Schedule_Test4 {
    public static void main(String[] args) throws SchedulerException {
        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // define the job and tie it to our MyJob class
        JobDetail job = newJob(QuartzJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        // and start it off
        scheduler.start();
    }
}

