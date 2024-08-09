package ma.plutus;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import ma.plutus.jobs.Job1;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.JobDetail;

import static org.quartz.SimpleScheduleBuilder.*;


public class Main {
    public static void main(String[] args) {
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            JobDetail job = newJob(Job1.class)
            .withIdentity("myJob", "group1") // name "myJob", group "group1"
            .usingJobData("jobSays", "hello agent number :")
            .usingJobData("myFloatValue", 3.141f)
            .build();

            // Trigger the job to run now, and then every 40 seconds
            Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(40)
                    .repeatForever())            
                .build();

            scheduler.scheduleJob(job, trigger);
            // scheduler.shutdown();

        } catch (Exception se) {
            System.out.println(se.getStackTrace());
        }
    }
}