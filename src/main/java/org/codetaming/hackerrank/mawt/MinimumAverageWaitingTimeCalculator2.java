package org.codetaming.hackerrank.mawt;

import java.util.ArrayList;
import java.util.List;

public class MinimumAverageWaitingTimeCalculator2 {

    private int numCustomers;

    private List<Order> remainingOrders = new ArrayList<>();

    public int calculateAverageWaitingTime() {
        if (remainingOrders.size()==numCustomers) {
            return processOrders();
        }
        throw new IllegalArgumentException("Not all customers have been added");
    }

    private int totalWaitingTime = 0;

    private int processOrders() {
        if (numCustomers==0)
        {
            return 0;
        }
        List<Order> unprocessedOrders = new ArrayList<>();
        int time =0;
        while (remainingOrders.size() > 0)
        {
            unprocessedOrders.clear();
            for (Order order : remainingOrders)
            {
                if (order.arrivalTime<=time)
                {
                    unprocessedOrders.add(order);
                }
            }
            if (unprocessedOrders.size()>0) {
                int prepationTime = processOptimalOrder(time, unprocessedOrders);
                time = time + prepationTime;
            }time++;
        }
        return (int)totalWaitingTime/numCustomers;
    }

    private int processOptimalOrder(int time, List<Order> unprocessedOrders) {
        Order optimalOrder = unprocessedOrders.get(0);
        int shortestWaitingTime = 0;
        for(Order order: unprocessedOrders)
        {
            int waitingTime = (time - order.arrivalTime) + order.preparationTime;
            if (shortestWaitingTime==0 ||  waitingTime<shortestWaitingTime)
            {
                shortestWaitingTime = waitingTime;
                optimalOrder = order;
            }
        }
        totalWaitingTime = totalWaitingTime + shortestWaitingTime;
        remainingOrders.remove(optimalOrder);
        return optimalOrder.preparationTime;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public void addOrder(int arrivalTime, int preparationTime) {
        remainingOrders.add(new Order(arrivalTime, preparationTime));
    }

    private class Order {
        protected final int arrivalTime;
        protected final int preparationTime;

        public Order(int arrivalTime, int preparationTime) {
            this.arrivalTime = arrivalTime;
            this.preparationTime = preparationTime;
        }
    }
}
