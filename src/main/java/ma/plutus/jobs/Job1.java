package ma.plutus.jobs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job1 implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        // String filePath = "./file.txt";
        // String content = "This is the content to write into the file.";

        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        //     bw.write(content);
        //     bw.newLine();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        System.out.println(jobSays + myFloatValue);
    }

}
