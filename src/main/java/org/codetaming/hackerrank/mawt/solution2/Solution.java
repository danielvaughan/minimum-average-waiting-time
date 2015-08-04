package org.codetaming.hackerrank.mawt.solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.go();
    }

    private void go() {
        Processor processor = new ProcessorImpl(new JobLoaderSystemInImpl(), new SjfSchedulerImpl());
        processor.process();
        System.out.print(processor.getAverageWaitTime());
    }

    class Job implements Comparable<Job> {

        private final long arrivalTime;
        private final long processingTime;
        private long waitingTime;

        public Job(long arrivalTime, long processingTime) {
            this.arrivalTime = arrivalTime;
            this.processingTime = processingTime;
        }

        public long getWaitingTime() {
            return waitingTime;
        }

        public void setWaitingTime(long waitingTime) {
            this.waitingTime = waitingTime;
        }

        public long getProcessingTime() {
            return processingTime;
        }

        public long getArrivalTime() {
            return arrivalTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.arrivalTime > o.getArrivalTime() ? +1 : this.arrivalTime < o.getArrivalTime() ? -1 : 0;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "arrivalTime=" + arrivalTime +
                    ", processingTime=" + processingTime +
                    ", waitingTime=" + waitingTime +
                    '}';
        }
    }

    interface JobLoader {

        List<Job> load();

    }

    class JobLoaderSystemInImpl implements JobLoader {

        @Override
        public List<Job> load() {
            Scanner s = new Scanner(System.in);
            long numCustomers = s.nextLong();
            List<Job> jobs = new ArrayList<>();
            long i = numCustomers;
            while (i-- > 0) {
                long arrivalTime = s.nextLong();
                long processingTime = s.nextLong();
                jobs.add(new Job(arrivalTime, processingTime));
            }
            return jobs;
        }

    }

    interface Processor {

        List<Job> process();

        long getAverageWaitTime();
    }

    class ProcessorImpl implements Processor {

        private JobLoader jobLoader;
        private Scheduler scheduler;

        public ProcessorImpl(JobLoader jobLoader, Scheduler scheduler) {
            this.jobLoader = jobLoader;
            this.scheduler = scheduler;
        }

        private List<Job> completedJobs = new ArrayList<>();

        @Override
        public List<Job> process() {
            List<Job> pendingJobs = jobLoader.load();
            sort(pendingJobs);
            long time = 0;
            while (!pendingJobs.isEmpty()) {
                time = time < pendingJobs.get(0).getArrivalTime() ? pendingJobs.get(0).getArrivalTime() : time;
                List<Job> qualifyingJobs = new ArrayList<>();
                for (Job job : pendingJobs) {
                    if (job.getArrivalTime() <= time) {
                        qualifyingJobs.add(job);
                    }
                }
                for (Job job : qualifyingJobs) {
                    scheduler.addJob(job);
                    pendingJobs.remove(job);
                }
                Job nextJob = scheduler.getNextJob();
                if (nextJob == null) {
                    time++;
                }
                while (nextJob != null) {
                    time = time + nextJob.getProcessingTime();
                    nextJob.setWaitingTime(time - nextJob.getArrivalTime());
                    completedJobs.add(nextJob);
                    nextJob = scheduler.getNextJob();
                }
            }
            return completedJobs;
        }

        @Override
        public long getAverageWaitTime() {
            long totalWaitTime = 0;
            for (Job job : completedJobs) {
                totalWaitTime = totalWaitTime + job.getWaitingTime();
            }
            return (long) (totalWaitTime / completedJobs.size());
        }

    }

    interface Scheduler {

        void addJob(Job job);

        Job getNextJob();

    }

    class SjfSchedulerImpl implements Scheduler {

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

}

