package net.steppschuh.markdowngenerator.progress;

import org.junit.Test;

/**
 * Created by Stephan on 12/18/2016.
 */
public class ProgressBarTest {

    @Test
    public void example1() throws Exception {
        ProgressBar progressBar = new ProgressBar(0.75);
        System.out.println(progressBar);
    }

    @Test
    public void example2() throws Exception {
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setMaximumValue(100);
        progressBar.setAppendPercentage(true);

        for (int i = 0; i <= 100; i += 5) {
            progressBar.setValue(i);
            System.out.println(progressBar);
        }
    }

}