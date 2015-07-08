package org.codetaming.hackerrank.mawt;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
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

    @Test
    public void testCalculateAcceptsCorrectSignature() throws Exception {
        int numCustomers = 3;
        List<Integer> arrivalTimes = Arrays.asList(0, 1, 2);
        List<Integer> preparationTimes = Arrays.asList(3, 6, 9);
        Integer averageWaitTime = 0;
        assertTrue(mawtc.calculate(numCustomers, arrivalTimes, preparationTimes) > -1);
    }

}
