package org.codetaming.hackerrank.mawt;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MinimumAverageWaitingTimeCalculatorTest {

    /*
    The first line contains an integer N, which is the number of customers.
    In the next N lines, the ith line contains two space separated numbers Ti and Li. Ti is the time when ith customer order a pizza, and Li is the time required to cook that pizza.
    Output Format
    Display the integer part of the minimum average waiting time.
    Constraints
    1 ≤ N ≤ 105 0 ≤ Ti ≤ 109 1 ≤ Li ≤ 109
     */

    private MinimumAverageWaitingTimeCalculator mawtc;

    @Before
    public void setUp() throws Exception {
        mawtc = new MinimumAverageWaitingTimeCalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRejectsIncorrectInput() throws Exception {
        int numCustomers = 2;
        List<Integer> arrivalTimes = Arrays.asList(0, 1, 2);
        List<Integer> preparationTimes = Arrays.asList(3, 6, 9);
        mawtc.calculateAverageWaitingTimes(numCustomers, arrivalTimes, preparationTimes);
    }

    @Test
    public void giveOneCustomerReturnTheArrivalTimePlusPreparationTime() throws Exception {
        assertMinimumAverageWaitingTimeIsCorrect(1, Arrays.asList(0), Arrays.asList(1), 1);
        assertMinimumAverageWaitingTimeIsCorrect(1, Arrays.asList(0), Arrays.asList(2), 2);
        assertMinimumAverageWaitingTimeIsCorrect(1, Arrays.asList(1), Arrays.asList(2), 2);
    }

    @Test
    public void giveTwoCustomersReturnTheArrivalTimePlusPreparationTime() throws Exception {
        assertMinimumAverageWaitingTimeIsCorrect(2, Arrays.asList(0, 1), Arrays.asList(1, 1), 1);
        assertMinimumAverageWaitingTimeIsCorrect(2, Arrays.asList(0, 1), Arrays.asList(2, 1), 2);
        assertMinimumAverageWaitingTimeIsCorrect(2, Arrays.asList(0, 1), Arrays.asList(3, 1), 3);
        assertMinimumAverageWaitingTimeIsCorrect(2, Arrays.asList(0, 1), Arrays.asList(3, 3), 4);
    }

    @Test
    public void testCalculateAcceptsCorrectSignature() throws Exception {
        int numCustomers = 3;
        List<Integer> arrivalTimes = Arrays.asList(0, 1, 2);
        List<Integer> preparationTimes = Arrays.asList(3, 6, 9);
        mawtc.calculateAverageWaitingTimes(numCustomers, arrivalTimes, preparationTimes);
    }

    private void assertMinimumAverageWaitingTimeIsCorrect(int numCustomers, List<Integer> arrivalTimes, List<Integer> preparationTimes, Integer averageWaitTime) {
        assertThat(mawtc.calculateOptimalAverageWaitTimes(numCustomers, arrivalTimes, preparationTimes), is(averageWaitTime));
    }

    @Test
    public void testCalculateWaitimesForSampleInput00() throws Exception {
        int numCustomers = 3;
        List<Integer> arrivalTimes = Arrays.asList(0, 1, 2);
        List<Integer> preparationTimes = Arrays.asList(3, 9, 6);
        List<Integer> expectedWaitTimes = Arrays.asList(3, 11, 16);
        assertThat(mawtc.calculateWaitingTimes(numCustomers, arrivalTimes, preparationTimes), is(expectedWaitTimes));
    }

    @Test
    public void testCalculateWithSampleInput00() throws Exception {
        int numCustomers = 3;
        List<Integer> arrivalTimes = Arrays.asList(0, 1, 2);
        List<Integer> preparationTimes = Arrays.asList(3, 9, 6);
        Integer averageWaitTime = 9;
        assertMinimumAverageWaitingTimeIsCorrect(numCustomers, arrivalTimes, preparationTimes, averageWaitTime);
    }

    @Test
    public void testCalculateWithSampleInput01() throws Exception {
        int numCustomers = 3;
        List<Integer> arrivalTimes = Arrays.asList(0, 1, 2);
        List<Integer> preparationTimes = Arrays.asList(3, 9, 5);
        Integer averageWaitTime = 8;
        assertMinimumAverageWaitingTimeIsCorrect(numCustomers, arrivalTimes, preparationTimes, averageWaitTime);
    }
}
