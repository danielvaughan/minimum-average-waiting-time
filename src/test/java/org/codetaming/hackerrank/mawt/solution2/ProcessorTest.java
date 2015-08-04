package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class ProcessorTest {


    @Test
    public void testProcessor() throws Exception {
        String data = "3\n0 3\n1 9\n2 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Processor processor = new ProcessorImpl(new JobLoaderSystemInImpl(), new SjfSchedulerImpl());
        List<Job> jobs = processor.process();
        for (Job job : jobs)
        {
            System.out.println(jobs);
        }
    }
}
