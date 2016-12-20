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
        progressBar.setOpeningChar(' ');
        progressBar.setClosingChar(' ');

        for (int i = 0; i <= 20; i++) {
            progressBar.setValue(0.1 * (Math.sin(i) + Math.pow(i, 1.3) - (1.3 * Math.pow(i, 1.2))) + 0.3);
            String percentage = Math.round(progressBar.getValue() * 100) + "%";
            String visualization = progressBar.toString().replace(progressBar.getEmptyChar() + "", "");
            tableBuilder.addRow((i + 1), percentage, visualization);
        }

        System.out.println(tableBuilder.build());
    }

}