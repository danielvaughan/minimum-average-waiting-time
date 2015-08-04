package org.codetaming.hackerrank.mawt;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinimumAverageWatingTimeCalculator2Test {

    private MinimumAverageWaitingTimeCalculator2 mawtc2;

    @Before
    public void setUp() throws Exception {
        mawtc2 = new MinimumAverageWaitingTimeCalculator2();
    }

    @Test
    public void givenZeroCustomersReturnAverageWaitingTimeOf0() throws Exception {
        assertThat(mawtc2.calculateAverageWaitingTime(), is(0));
    }

    @Test
    public void givenOneCustomerReturnPreparationTime() throws Exception {
        int numCustomers = 1;
        int arrivalTime = 1;
        int preparationTime = 1;
        mawtc2.setNumCustomers(numCustomers);
        mawtc2.addOrder(arrivalTime, preparationTime);
        assertThat(mawtc2.calculateAverageWaitingTime(), is(preparationTime));
    }

    @Test
    public void givenSampleInput00Return9() throws Exception {
        mawtc2.setNumCustomers(3);
        mawtc2.addOrder(0, 3);
        mawtc2.addOrder(1, 6);
        mawtc2.addOrder(2, 9);
        assertThat(mawtc2.calculateAverageWaitingTime(), is(9));
    }

    @Test
    public void givenSampleInput01Return8() throws Exception {
        mawtc2.setNumCustomers(3);
        mawtc2.addOrder(0, 3);
        mawtc2.addOrder(1, 9);
        mawtc2.addOrder(2, 5);
        assertThat(mawtc2.calculateAverageWaitingTime(), is(8));
    }
}
