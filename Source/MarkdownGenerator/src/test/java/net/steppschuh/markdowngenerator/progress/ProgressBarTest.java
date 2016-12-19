package net.steppschuh.markdowngenerator.progress;

import net.steppschuh.markdowngenerator.table.Table;

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

    @Test
    public void example3() throws Exception {
        Table.Builder tableBuilder = new Table.Builder()
                .withAlignments(Table.ALIGN_RIGHT, Table.ALIGN_RIGHT, Table.ALIGN_CENTER)
                .addRow("Day", "Growth", "Bars");

        ProgressBar progressBar = new ProgressBar(0, ProgressBar.LENGTH_LARGE);
        progressBar.setFillChar('#');
        progressBar.setEmptyChar(' ');

        for (int i = 0; i <= 20; i++) {
            progressBar.setValue(1 - (Math.pow(i - 15, 2) * 0.003) - Math.pow((i - 2) * 0.05, 3));
            String value = Math.round(progressBar.getValue() * 100) + "%";
            tableBuilder.addRow((i + 1), value, progressBar.toString());
        }

        System.out.println(tableBuilder.build());
    }

}