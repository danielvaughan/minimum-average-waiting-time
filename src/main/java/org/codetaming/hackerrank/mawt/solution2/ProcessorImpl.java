package org.codetaming.hackerrank.mawt.solution2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class ProcessorImpl implements Processor {

    private JobLoader jobLoader;
    private Scheduler scheduler;

    public ProcessorImpl(JobLoader jobLoader, Scheduler scheduler) {
        this.jobLoader = jobLoader;
        this.scheduler = scheduler;
    }

    private List<Job> completedJobs = new ArrayList<>();;

    @Override
    public List<Job> process() {
        List<Job> pendingJobs = jobLoader.load();
        sort(pendingJobs);
        long time = 0;
        while(!pendingJobs.isEmpty())
        {
            time = time < pendingJobs.get(0).getArrivalTime() ? pendingJobs.get(0).getArrivalTime() : time;
            //System.out.println("time skip: " + time);
            List<Job> qualifyingJobs = new ArrayList<>();
            for(Job job : pendingJobs)
            {
                if(job.getArrivalTime()<= time)
                {
                    qualifyingJobs.add(job);
                }
            }
            for (Job job : qualifyingJobs)
            {
                scheduler.addJob(job);
                pendingJobs.remove(job);
            }
            Job nextJob = scheduler.getNextJob();
            if (nextJob==null)
            {
                time++;
            }
            while (nextJob!=null)
            {
                time = time + nextJob.getProcessingTime();
                nextJob.setWaitingTime(time - nextJob.getArrivalTime());
                completedJobs.add(nextJob);
                nextJob = scheduler.getNextJob();
            }
        }
        return completedJobs;
    }

    @Override
    public int getAverageWaitTime() {
        long totalWaitTime = 0;
        for (Job job : completedJobs)
        {
            totalWaitTime = totalWaitTime + job.getWaitingTime();
        }
        return (int) (totalWaitTime / completedJobs.size());
    }

}
