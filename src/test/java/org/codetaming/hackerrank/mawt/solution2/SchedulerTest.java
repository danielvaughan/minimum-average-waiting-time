package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchedulerTest {

    @Test
    public void testGetNextWithSjfSchedulerPriorityQueueImpl() throws Exception {
        Scheduler scheduler = new SjfSchedulerPriorityQueueImpl();
        getNext(scheduler);
    }

    private void getNext(Scheduler scheduler) {
        Random random = new Random();
        for (int i=1; i<=10; i++)
        {
            int randomTime = random.nextInt(99);
            scheduler.addJob(new Job(1, 1 + randomTime));
        }
        scheduler.addJob(new Job(1, 1));
        assertThat(scheduler.getNextJob().getProcessingTime(), is(1));
    }

    @Test
    public void testGetNextWithSjfSchedulerImpl() throws Exception {
        Scheduler scheduler = new SjfSchedulerImpl();
        getNext(scheduler);
    }
}
