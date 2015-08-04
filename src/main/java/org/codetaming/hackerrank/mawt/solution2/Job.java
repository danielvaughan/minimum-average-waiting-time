package org.codetaming.hackerrank.mawt.solution2;

public class Job implements Comparable<Job> {

    private final int arrivalTime;
    private final int processingTime;
    private long waitingTime;

    public Job(int arrivalTime, int processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }

    public long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getArrivalTime() {
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
