package net.steppschuh.markdowngenerator.table;

import net.steppschuh.markdowngenerator.text.emphasis.BoldText;
import net.steppschuh.markdowngenerator.text.code.Code;
import net.steppschuh.markdowngenerator.text.Text;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class TableTest {

    @Test
    public void example1() throws Exception {
        List<TableRow> rows = Arrays.asList(
                new TableRow(Arrays.asList(
                        "Left",
                        "Center",
                        "Right"
                )),
                new TableRow(Arrays.asList(
                        new Text("Normal Text"),
                        new BoldText("Bold Text"),
                        new Code("Code Text")
                )),
                new TableRow(Arrays.asList(
                        1,
                        2,
                        3
                ))
        );

        List<Integer> alignments = Arrays.asList(
                Table.ALIGN_LEFT,
                Table.ALIGN_CENTER,
                Table.ALIGN_RIGHT
        );

        Table table = new Table(rows, alignments);
        System.out.println(table);
    }

    @Test
    public void example2() throws Exception {
        Table.Builder tableBuilder = new Table.Builder()
                .withAlignments(Table.ALIGN_RIGHT, Table.ALIGN_LEFT)
                .withRowLimit(7)
                .addRow("Index", "Boolean");

        for (int i = 1; i <= 20; i++) {
            tableBuilder.addRow(i, Math.random() > 0.5);
        }

        System.out.println(tableBuilder.build());
    }

    @Test
    public void example3() {
        Table.Builder tableBuilder = new Table.Builder()
                .addRow("Index", "Boolean");

        System.out.println(tableBuilder.build());
    }

}