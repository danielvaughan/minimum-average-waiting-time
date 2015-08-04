package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JobLoaderTest {

    @Test
    public void testLoad() throws Exception {
        String data = "3\n0 3\n1 9\n2 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        JobLoader jobLoader = new JobLoaderSystemInImpl();
        List<Job> jobs = jobLoader.load();
        assertThat(jobs.size(), is(3));
        assertThat(jobs.get(0).getArrivalTime(), is(0));
        assertThat(jobs.get(1).getArrivalTime(), is(1));
        assertThat(jobs.get(2).getArrivalTime(), is(2));
        assertThat(jobs.get(0).getProcessingTime(), is(3));
        assertThat(jobs.get(1).getProcessingTime(), is(9));
        assertThat(jobs.get(2).getProcessingTime(), is(5));
    }
}
