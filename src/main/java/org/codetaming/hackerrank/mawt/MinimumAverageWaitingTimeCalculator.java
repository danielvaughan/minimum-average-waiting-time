package org.codetaming.hackerrank.mawt;


import java.util.ArrayList;
import java.util.List;

public class MinimumAverageWaitingTimeCalculator {

    public int calculateAverageWaitingTimes(int numCustomers, List<Integer> arrivalTimes, List<Integer> preparationTimes) {
        double averageWaitingTime = calculateAverage(calculateWaitingTimes(numCustomers, arrivalTimes, preparationTimes));
        return (int) averageWaitingTime;
    }

    private int lastServeTime = 0;

    protected List<Integer> calculateWaitingTimes(int numCustomers, List<Integer> arrivalTimes, List<Integer> preparationTimes) {
        lastServeTime = 0;
        if (numCustomers != arrivalTimes.size() || numCustomers != preparationTimes.size()) {
            throw new IllegalArgumentException("Number of arrival times and preparation times must match number of customers.");
        }
        List<Integer> waitingTimes = new ArrayList<>();
        for (int customer = 0; customer < numCustomers; customer++) {
            waitingTimes.add(calculateWaitTimeForCustomer(customer, arrivalTimes.get(customer), preparationTimes.get(customer)));
        }
        return waitingTimes;
    }

    private int calculateWaitTimeForCustomer(int customer, int arrivalTime, int preparationTime) {
        int waitForCook = lastServeTime > arrivalTime ? lastServeTime - arrivalTime : 0;
        int totalWaitTime = waitForCook + preparationTime;
        int cookIdleTime = lastServeTime < arrivalTime ? arrivalTime - lastServeTime : 0;
        int serveTime = lastServeTime + cookIdleTime + preparationTime;
        outputState(customer, arrivalTime, preparationTime, waitForCook, cookIdleTime, serveTime, totalWaitTime);
        lastServeTime = serveTime;
        return totalWaitTime;
    }

    private void outputState(int customer, int arrivalTime, int preparationTime, int waitForCook, int cookIdleTime, int serveTime, int waitTime) {
        System.out.println(
                "\ncustomer: " + customer +
                        "\narrivalTime: " + arrivalTime +
                        "\nlastServeTime: " + lastServeTime +
                        "\nwaitForCook: " + waitForCook +
                        "\ncookIdleTime: " + cookIdleTime +
                        "\npreparationTime: " + preparationTime +
                        "\nserveTime: " + serveTime +
                        "\nwaitTime: " + waitTime);
    }

    private double calculateAverage(List<Integer> waitingTimes) {
        Integer sum = 0;
        if (!waitingTimes.isEmpty()) {
            for (Integer waitingTime : waitingTimes) {
                sum += waitingTime;
            }
            return sum.doubleValue() / waitingTimes.size();
        }
        return sum;
    }
}
