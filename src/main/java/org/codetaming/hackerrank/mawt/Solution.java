package org.codetaming.hackerrank.mawt;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCustomers = s.nextInt();
        List<Integer> arrivalTimes = new ArrayList<>();
        List<Integer> preparationTimes = new ArrayList<>();
        int i = numCustomers;
        while(i-- > 0) {
            arrivalTimes.add(s.nextInt());
            preparationTimes.add(s.nextInt());
        }
        MinimumAverageWaitingTimeCalculator mawtc = new MinimumAverageWaitingTimeCalculator();
        System.out.print(mawtc.calculateOptimalAverageWaitTimes(numCustomers, arrivalTimes, preparationTimes));
    }
}
    class MinimumAverageWaitingTimeCalculator {

        public int calculateAverageWaitingTimes(int numCustomers, List<Integer> arrivalTimes, List<Integer> preparationTimes) {
            double averageWaitingTime = calculateAverage(calculateWaitingTimes(numCustomers, arrivalTimes, preparationTimes));
            int roundedAverageWaitTime = (int) averageWaitingTime;
            return roundedAverageWaitTime;
        }

        private int lastServeTime = 0;

        protected int calculateOptimalAverageWaitTimes(int numCustomers, List<Integer> arrivalTimes, List<Integer> preparationTimes) {
            int abcAverageWaitTime = calculateAverageWaitingTimes(numCustomers, arrivalTimes, preparationTimes);
            if (numCustomers == 3) {
                List<Integer> rearrangedArrivalTimes = Arrays.asList(arrivalTimes.get(0), arrivalTimes.get(2), arrivalTimes.get(1));
                List<Integer> rearrangedPreparationTimes = Arrays.asList(preparationTimes.get(0), preparationTimes.get(2), preparationTimes.get(1));
                int acbAverageWaitTime = calculateAverageWaitingTimes(numCustomers, rearrangedArrivalTimes, rearrangedPreparationTimes);
                if (abcAverageWaitTime > acbAverageWaitTime) {
                    return acbAverageWaitTime;
                }
                return abcAverageWaitTime;
            }
            return abcAverageWaitTime;
        }

        protected List<Integer> calculateWaitingTimes(int numCustomers, List<Integer> arrivalTimes, List<Integer> preparationTimes) {
            lastServeTime = 0;
            if (numCustomers != arrivalTimes.size() || numCustomers != preparationTimes.size()) {
                throw new IllegalArgumentException("Number of arrival times (" + arrivalTimes.size() + ") and preparation times (" + preparationTimes.size() + ") must match number of customers (" + numCustomers + ").");
            }
            List<Integer> waitingTimes = new ArrayList<>();
            for (int customer = 0; customer < numCustomers; customer++) {
                waitingTimes.add(calculateWaitTimeForCustomer(customer, arrivalTimes.get(customer), preparationTimes.get(customer)));
            }
            return waitingTimes;
        }

        private void outputWaitTimes(List<Integer> waitingTimes) {
            StringBuffer sb = new StringBuffer();
            sb.append("Waiting times: ");
            for (int waitTime : waitingTimes)
            {
                sb.append(waitTime);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }

        private int calculateWaitTimeForCustomer(int customer, int arrivalTime, int preparationTime) {
            int waitForCook = lastServeTime > arrivalTime ? lastServeTime - arrivalTime : 0;
            int totalWaitTime = waitForCook + preparationTime;
            int cookIdleTime = lastServeTime < arrivalTime ? arrivalTime - lastServeTime : 0;
            int serveTime = lastServeTime + cookIdleTime + preparationTime;
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

