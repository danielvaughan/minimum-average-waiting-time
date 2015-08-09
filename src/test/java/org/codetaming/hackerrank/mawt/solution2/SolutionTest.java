package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private org.codetaming.hackerrank.mawt.solution2.Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new org.codetaming.hackerrank.mawt.solution2.Solution();
    }

    @Test
    public void given_Sample_Output_00() throws Exception {
        String data = "3\n0 3\n1 9\n2 6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("9"));
    }

    @Test
    public void given_Sample_Output_01() throws Exception {
        String data = "3\n0 3\n1 9\n2 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("8"));
    }

    @Test
    public void given_times_with_gaps() throws Exception {
        String data = "3\n0 2\n5 4\n10 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("3"));
    }

    @Test
    public void given_times_with_arrival_time_factor() throws Exception {
        String data = "3\n0 6\n1 1\n4 2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("4"));
    }

    @Test
    public void given_TestCase_00() throws Exception {
        String data = "5\n" +
                "961148050 385599125\n" +
                "951133776 376367013\n" +
                "283280121 782916802\n" +
                "317664929 898415172\n" +
                "980913391 847912645\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("1418670047"));
    }

    @Test
    public void given_TestCase_01() throws Exception {
        System.setIn(this.getClass().getClassLoader().getResourceAsStream("test-01.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("8485548331"));
    }

    @Test
    public void given_TestCase_08() throws Exception {
        System.setIn(this.getClass().getClassLoader().getResourceAsStream("test-08.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("16673945929151"));
    }
}
