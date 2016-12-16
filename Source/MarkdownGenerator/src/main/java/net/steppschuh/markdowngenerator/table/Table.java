package net.steppschuh.markdowngenerator.table;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.steppschuh.markdowngenerator.util.StringUtil.surroundValueWith;

public class Table extends MarkdownElement {

    public static final String SEPERATOR = "|";
    public static final String WHITESPACE = " ";
    public static final String DEFAULT_TRIMMING_INDICATOR = "~";
    public static final int DEFAULT_MINIMUM_COLUMN_WIDTH = 3;

    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 2;
    public static final int ALIGN_RIGHT = 3;

    private List<TableRow> rows;
    private List<Integer> alignments;
    private boolean firstRowIsHeader = true;
    private int minimumColumnWidth = DEFAULT_MINIMUM_COLUMN_WIDTH;
    private String trimmingIndicator = DEFAULT_TRIMMING_INDICATOR;

    public static class Builder {

        private Table table;
        private int rowLimit;

        public Builder() {
            table = new Table();
        }

        public Builder withRows(List<TableRow> tableRows) {
            table.setRows(tableRows);
            return this;
        }

        public Builder addRow(TableRow tableRow) {
            table.getRows().add(tableRow);
            return this;
        }

        public Builder addRow(Object... objects) {
            TableRow tableRow = new TableRow(Arrays.asList(objects));
            table.getRows().add(tableRow);
            return this;
        }

        public Builder withAlignments(List<Integer> alignments) {
            table.setAlignments(alignments);
            return this;
        }

        public Builder withAlignments(Integer... alignments) {
            return withAlignments(Arrays.asList(alignments));
        }

        public Builder withAlignment(int alignment) {
            return withAlignments(Collections.singletonList(alignment));
        }

        public Builder withRowLimit(int rowLimit) {
            this.rowLimit = rowLimit;
            return this;
        }

        public Builder withTrimmingIndicator(String trimmingIndicator) {
            table.setTrimmingIndicator(trimmingIndicator);
            return this;
        }

        public Table build() {
            if (rowLimit > 0) {
                table.trim(rowLimit);
            }
            return table;
        }

    }

    public Table() {
        this.rows = new ArrayList<>();
        this.alignments = new ArrayList<>();
        firstRowIsHeader = true;
    }

    public Table(List<TableRow> rows) {
        this();
        this.rows = rows;
    }

    public Table(List<TableRow> rows, List<Integer> alignments) {
        this(rows);
        this.alignments = alignments;
    }

    @Override
    public String serialize() {
        Map<Integer, Integer> columnWidths = getColumnWidths(rows, minimumColumnWidth);

        StringBuilder sb = new StringBuilder();

        String headerSeperator = generateHeaderSeperator(columnWidths, alignments);
        boolean headerSeperatorAdded = !firstRowIsHeader;
        if (!firstRowIsHeader) {
            sb.append(headerSeperator).append("\n");
        }

        for (TableRow row : rows) {
            for (int columnIndex = 0; columnIndex < columnWidths.size(); columnIndex++) {
                sb.append(SEPERATOR);

                String value = "";
                if (row.getColumns().size() > columnIndex) {
                    Object valueObject = row.getColumns().get(columnIndex);
                    if (valueObject != null) {
                        value = valueObject.toString();
                    }
                }

                if (value.equals(trimmingIndicator)) {
                    value = StringUtil.fillUpLeftAligned(value, trimmingIndicator, columnWidths.get(columnIndex));
                    value = surroundValueWith(value, WHITESPACE);
                } else {
                    int alignment = getAlignment(alignments, columnIndex);
                    value = surroundValueWith(value, WHITESPACE);
                    value = StringUtil.fillUpAligned(value, WHITESPACE, columnWidths.get(columnIndex) + 2, alignment);
                }

                sb.append(value);

                if (columnIndex == row.getColumns().size() - 1) {
                    sb.append(SEPERATOR);
                }
            }

            if (rows.indexOf(row) < rows.size() - 1) {
                sb.append("\n");
            }

            if (!headerSeperatorAdded) {
                sb.append(headerSeperator).append("\n");
                headerSeperatorAdded = true;
            }
        }
        return sb.toString();
    }

    /**
     * Removes {@link TableRow}s from the center of this table until only the requested amount of
     * rows is left.
     *
     * @param rowsToKeep Amount of {@link TableRow}s that should not be removed
     * @return the trimmed table
     */
    public Table trim(int rowsToKeep) {
        rows = trim(this, rowsToKeep, trimmingIndicator).getRows();
        return this;
    }

    /**
     * Removes {@link TableRow}s from the center of the specified table until only the requested
     * amount of rows is left.
     *
     * @param table      Table to remove {@link TableRow}s from
     * @param rowsToKeep Amount of {@link TableRow}s that should not be removed
     * @param trimmingIndicator The content that trimmed cells should be filled with
     * @return The trimmed table
     */
    public static Table trim(Table table, int rowsToKeep, String trimmingIndicator) {
        if (table.getRows().size() <= rowsToKeep) {
            return table;
        }

        int trimmedEntriesCount = table.getRows().size() - (table.getRows().size() - rowsToKeep);
        int trimmingStartIndex = Math.round(trimmedEntriesCount / 2) + 1;
        int trimmingStopIndex = table.getRows().size() - trimmingStartIndex;

        List<TableRow> trimmedRows = new ArrayList<>();
        for (int i = trimmingStartIndex; i <= trimmingStopIndex; i++) {
            trimmedRows.add(table.getRows().get(i));
        }

        table.getRows().removeAll(trimmedRows);

        TableRow trimmingIndicatorRow = new TableRow();
        for (int columnIndex = 0; columnIndex < table.getRows().get(0).getColumns().size(); columnIndex++) {
            trimmingIndicatorRow.getColumns().add(trimmingIndicator);
        }
        table.getRows().add(trimmingStartIndex, trimmingIndicatorRow);

        return table;
    }

    public static String generateHeaderSeperator(Map<Integer, Integer> columnWidths, List<Integer> alignments) {
        StringBuilder sb = new StringBuilder();
        for (int columnIndex = 0; columnIndex < columnWidths.entrySet().size(); columnIndex++) {
            sb.append(SEPERATOR);

            String value = StringUtil.fillUpLeftAligned("", "-", columnWidths.get(columnIndex));

            int alignment = getAlignment(alignments, columnIndex);
            switch (alignment) {
                case ALIGN_RIGHT: {
                    value = WHITESPACE + value + ":";
                    break;
                }
                case ALIGN_CENTER: {
                    value = ":" + value + ":";
                    break;
                }
                default: {
                    value = surroundValueWith(value, WHITESPACE);
                    break;
                }
            }

            sb.append(value);
            if (columnIndex == columnWidths.entrySet().size() - 1) {
                sb.append(SEPERATOR);
            }
        }
        return sb.toString();
    }

    public static Map<Integer, Integer> getColumnWidths(List<TableRow> rows, int minimumColumnWidth) {
        Map<Integer, Integer> columnWidths = new HashMap<Integer, Integer>();
        if (rows.isEmpty()) {
            return columnWidths;
        }
        for (int columnIndex = 0; columnIndex < rows.get(0).getColumns().size(); columnIndex++) {
            columnWidths.put(columnIndex, getMaximumItemLength(rows, columnIndex, minimumColumnWidth));
        }
        return columnWidths;
    }

    public static int getMaximumItemLength(List<TableRow> rows, int columnIndex, int minimumColumnWidth) {
        int maximum = minimumColumnWidth;
        for (TableRow row : rows) {
            if (row.getColumns().size() < columnIndex + 1) {
                continue;
            }
            Object value = row.getColumns().get(columnIndex);
            if (value == null) {
                continue;
            }
            maximum = Math.max(value.toString().length(), maximum);
        }
        return maximum;
    }

    public static int getAlignment(List<Integer> alignments, int columnIndex) {
        if (alignments.isEmpty()) {
            return ALIGN_LEFT;
        }
        if (columnIndex >= alignments.size()) {
            columnIndex = alignments.size() - 1;
        }
        return alignments.get(columnIndex);
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
        invalidateSerialized();
    }

    public List<Integer> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<Integer> alignments) {
        this.alignments = alignments;
        invalidateSerialized();
    }

    public boolean isFirstRowHeader() {
        return firstRowIsHeader;
    }

    public void useFirstRowAsHeader(boolean firstRowIsHeader) {
        this.firstRowIsHeader = firstRowIsHeader;
        invalidateSerialized();
    }

    public int getMinimumColumnWidth() {
        return minimumColumnWidth;
    }

    public void setMinimumColumnWidth(int minimumColumnWidth) {
        this.minimumColumnWidth = minimumColumnWidth;
        invalidateSerialized();
    }

    public String getTrimmingIndicator() {
        return trimmingIndicator;
    }

    public void setTrimmingIndicator(String trimmingIndicator) {
        this.trimmingIndicator = trimmingIndicator;
    }
}
