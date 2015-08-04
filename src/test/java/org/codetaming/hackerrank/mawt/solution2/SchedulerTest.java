package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchedulerTest {

    @Test
    public void testGetNext() throws Exception {
        Scheduler scheduler = new SjfSchedulerImpl();
        scheduler.addJob(new Job(1, 10));
        scheduler.addJob(new Job(1, 1));
        scheduler.addJob(new Job(1, 5));
        assertThat(scheduler.getNextJob().getProcessingTime(), is(1));
    }

}
