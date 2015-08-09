package org.codetaming.hackerrank.mawt.solution2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SjfSchedulerPriorityQueueImpl implements Scheduler {

    private PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>(10000000, new ProcessingTimeCompartor());

    @Override
    public void addJob(Job job) {
        jobPriorityQueue.add(job);
    }

    @Override
    public Job getNextJob() {
        Job nextJob = jobPriorityQueue.poll();
        return nextJob;
    }

    private class ProcessingTimeCompartor implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            if (o1.getProcessingTime() < o2.getProcessingTime())
            {
                return -1;
            }
            if (o1.getProcessingTime() > o2.getProcessingTime())
            {
                return 1;
            }
            return 0;
        }
    }
}
