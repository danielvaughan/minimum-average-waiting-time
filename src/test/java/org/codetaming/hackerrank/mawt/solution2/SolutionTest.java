package org.codetaming.hackerrank.mawt.solution2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
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
    public void given_TestCode_08() throws Exception {
        System.setIn(this.getClass().getClassLoader().getResourceAsStream("test-8.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        solution.main(new String[]{});
        assertThat(out.toString(), is("16673945929151"));
    }
}
