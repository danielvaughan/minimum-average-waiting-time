package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void testSort() throws Exception {
        Job job1 = new Job(1,0);
        Job job2 = new Job(3,0);
        Job job3 = new Job(2,0);
        List<Job> jobList = Arrays.asList(job1,job2,job3);
        Collections.sort(jobList);
        assertThat(jobList.get(0), is(job1));
        assertThat(jobList.get(1), is(job3));
        assertThat(jobList.get(2), is(job2));
    }
}
