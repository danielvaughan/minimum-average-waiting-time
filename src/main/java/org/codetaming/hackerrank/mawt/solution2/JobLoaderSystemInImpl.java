package org.codetaming.hackerrank.mawt.solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobLoaderSystemInImpl implements JobLoader {

    @Override
    public List<Job> load() {
        Scanner s = new Scanner(System.in);
        int numCustomers = s.nextInt();
        List<Job> jobs = new ArrayList<>();
        int i = numCustomers;
        while(i-- > 0) {
            int arrivalTime = s.nextInt();
            int processingTime = s.nextInt();
            jobs.add(new Job(arrivalTime, processingTime));
        }
        return jobs;
    }

}
