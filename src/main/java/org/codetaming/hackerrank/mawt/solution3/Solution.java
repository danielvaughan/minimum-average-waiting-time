package org.codetaming.hackerrank.mawt.solution3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.go();
    }

    private Queue<Job> pendingQueue;
    private int numCustomers;
    private long totalWaitingTime;
    private long time = 0;

    private class Job implements Comparable<Job> {

        final long arrivalTime;
        final long processingTime;
        long potentialWaitTime;

        public long getArrivalTime() {
            return arrivalTime;
        }

        public long getProcessingTime() {
            return processingTime;
        }

        public Job(final long arrivalTime, final long processingTime) {
            this.arrivalTime = arrivalTime;
            this.processingTime = processingTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "arrivalTime=" + arrivalTime +
                    ", processingTime=" + processingTime +
                    '}';
        }

        @Override
        public int compareTo(Job o) {
            return this.arrivalTime > o.arrivalTime ? +1 : this.arrivalTime < o.arrivalTime ? -1 : 0;
        }

        public void recalculatePotentialWaitTime() {
            potentialWaitTime = (time - arrivalTime) + processingTime;
        }
    }

    private class ProcessingTimeCompartor implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o1.processingTime > o2.processingTime ? +1 : o1.processingTime < o2.processingTime ? -1 : 0;
        }
    }

    private class PotentialWaitTimeCompartor implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            o1.recalculatePotentialWaitTime();
            o2.recalculatePotentialWaitTime();
            return o1.potentialWaitTime > o2.potentialWaitTime ? +1 : o1.potentialWaitTime < o2.potentialWaitTime ? -1 : 0;
        }
    }


    private void go() {
        load();
        process();
        report();
    }

    private void report() {
        long averageWaitTime = (long) totalWaitingTime / numCustomers;
        System.out.print(averageWaitTime);
    }

    private void process() {
        while (!pendingQueue.isEmpty()) {
            time = time < pendingQueue.peek().arrivalTime ? pendingQueue.peek().arrivalTime : time;
            Queue<Job> processingQueue = new PriorityQueue<>(10, new ProcessingTimeCompartor());
            while (!pendingQueue.isEmpty() && pendingQueue.peek().arrivalTime <= time) {
                processingQueue.add(pendingQueue.poll());
            }
            while (!processingQueue.isEmpty()) {
                Job nextJob = processingQueue.poll();
                long waitingTime = (time - nextJob.arrivalTime) + nextJob.processingTime;
                totalWaitingTime = totalWaitingTime + waitingTime;
                time = time + nextJob.processingTime;
            }
        }
    }

    private void load() {
        Scanner s = new Scanner(System.in);
        numCustomers = s.nextInt();
        pendingQueue = new PriorityQueue<>(numCustomers);
        int i = numCustomers;
        while (i-- > 0) {
            long arrivalTime = s.nextLong();
            long processingTime = s.nextLong();
            pendingQueue.add(new Job(arrivalTime, processingTime));
        }
    }
}
