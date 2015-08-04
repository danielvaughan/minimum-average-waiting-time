package org.codetaming.hackerrank.mawt.solution2;

import java.util.ArrayList;
import java.util.List;

public class SjfSchedulerImpl implements Scheduler {

    private List<Job> potentialJobs = new ArrayList<>();

    @Override
    public void addJob(Job job) {
        potentialJobs.add(job);
    }

    @Override
    public Job getNextJob() {
        if (potentialJobs.isEmpty()) {
            return null;
        }
        Job shortestJob = potentialJobs.get(0);
        for (Job job : potentialJobs) {
            if (job.getProcessingTime() < shortestJob.getProcessingTime()) {
                shortestJob = job;
            }
        }
        potentialJobs.remove(shortestJob);
        return shortestJob;
    }
}
