package net.steppschuh.markdowngenerator.table;

import net.steppschuh.markdowngenerator.MarkdownElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table extends MarkdownElement {

    public static final String SEPERATOR = "|";
    public static final String TRIMMING_INDICATOR = "~~~";
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 2;
    public static final int ALIGN_RIGHT = 3;

    List<TableRow> rows;
    List<Integer> alignments;
    boolean firstRowIsHeader;
    int minimumColumnWidth = 3;

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
        Map<Integer, Integer> collumnWidths = getColumnWidths(rows, minimumColumnWidth);

        StringBuilder sb = new StringBuilder();

        String headerSeperator = generateHeaderSeperator(collumnWidths, alignments);
        boolean headerSeperatorAdded = !firstRowIsHeader;
        if (!firstRowIsHeader) {
            sb.append(headerSeperator).append("\n");
        }

        for (TableRow row : rows) {
            for (int columnIndex = 0; columnIndex < row.getItems().size(); columnIndex++) {
                int alignment = getAlignment(alignments, columnIndex);
                sb.append(SEPERATOR);
                String value = row.getItems().get(columnIndex).toString();
                boolean isTrimmingIndicator = TRIMMING_INDICATOR.equals(value);
                if (isTrimmingIndicator) {
                    value = " ";
                } else {
                    value = surroundValueWith(value, " ");
                }
                value = fillUpAligned(value, " ", collumnWidths.get(columnIndex) + 2, alignment);
                sb.append(value);
                if (columnIndex == row.getItems().size() - 1) {
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

    public Table trim(int entries) {
        rows = trim(this, entries).getRows();
        return this;
    }

    public static Table trim(Table table, int entries) {
        if (table.getRows().size() <= entries) {
            return table;
        }

        int trimmedEntriesCount = table.getRows().size() - (table.getRows().size() - entries);
        int trimmingStartIndex = Math.round(trimmedEntriesCount / 2) + 1;
        int trimmingStopIndex = table.getRows().size() - trimmingStartIndex;

        List<TableRow> trimmedRows = new ArrayList<>();
        for (int i = trimmingStartIndex; i <= trimmingStopIndex; i++) {
            trimmedRows.add(table.getRows().get(i));
        }

        table.getRows().removeAll(trimmedRows);

        TableRow trimmingIndicatorRow = new TableRow();
        for (int columnIndex = 0; columnIndex < table.getRows().get(0).getItems().size(); columnIndex++) {
            trimmingIndicatorRow.getItems().add(TRIMMING_INDICATOR);
        }
        table.getRows().add(trimmingStartIndex, trimmingIndicatorRow);

        return table;
    }

    public static String generateHeaderSeperator(Map<Integer, Integer> columnWidths, List<Integer> alignments) {
        StringBuilder sb = new StringBuilder();
        for (int columnIndex = 0; columnIndex < columnWidths.entrySet().size(); columnIndex++) {
            sb.append(SEPERATOR);

            String value = fillUpLeftAligned("", "-", columnWidths.get(columnIndex));

            int alignment = getAlignment(alignments, columnIndex);
            switch (alignment) {
                case ALIGN_RIGHT: {
                    value = " " + value + ":";
                    break;
                }
                case ALIGN_CENTER: {
                    value = ":" + value + ":";
                    break;
                }
                default: {
                    value = surroundValueWith(value, " ");
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
        if (rows.size() < 1) {
            return columnWidths;
        }
        for (int columnIndex = 0; columnIndex < rows.get(0).getItems().size(); columnIndex++) {
            columnWidths.put(columnIndex, getMaximumItemLength(rows, columnIndex, minimumColumnWidth));
        }
        return columnWidths;
    }

    public static int getMaximumItemLength(List<TableRow> rows, int columnIndex, int minimumColumnWidth) {
        int maximum = minimumColumnWidth;
        for (TableRow row : rows) {
            if (row.getItems().size() < columnIndex - 1) {
                continue;
            }
            String value = row.getItems().get(columnIndex).toString();
            maximum = Math.max(value.length(), maximum);
        }
        return maximum;
    }

    public static int getAlignment(List<Integer> alignments, int columnIndex) {
        if (columnIndex >= alignments.size()) {
            return ALIGN_LEFT;
        }
        return alignments.get(columnIndex);
    }

    public static String fillUpAligned(String value, String fill, int length, int alignment) {
        switch (alignment) {
            case ALIGN_RIGHT: {
                return fillUpRightAligned(value, fill, length);
            }
            case ALIGN_CENTER: {
                return fillUpCenterAligned(value, fill, length);
            }
            default: {
                return fillUpLeftAligned(value, fill, length);
            }
        }
    }

    public static String fillUpLeftAligned(String value, String fill, int length) {
        if (value.length() >= length) {
            return value;
        }
        while (value.length() < length) {
            value += fill;
        }
        return value;
    }

    public static String fillUpRightAligned(String value, String fill, int length) {
        if (value.length() >= length) {
            return value;
        }
        while (value.length() < length) {
            value = fill + value;
        }
        return value;
    }

    public static String fillUpCenterAligned(String value, String fill, int length) {
        if (value.length() >= length) {
            return value;
        }
        boolean left = true;
        while (value.length() < length) {
            if (left) {
                value = fillUpLeftAligned(value, fill, value.length() + 1);
            } else {
                value = fillUpRightAligned(value, fill, value.length() + 1);
            }
            left = !left;
        }
        return value;
    }

    public static String surroundValueWith(String value, String surrounding) {
        return surrounding + value + surrounding;
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
    }

    public List<Integer> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<Integer> alignments) {
        this.alignments = alignments;
    }

    public boolean isFirstRowHeader() {
        return firstRowIsHeader;
    }

    public void useFirstRowAsHeader(boolean firstRowIsHeader) {
        this.firstRowIsHeader = firstRowIsHeader;
    }

    public int getMinimumColumnWidth() {
        return minimumColumnWidth;
    }

    public void setMinimumColumnWidth(int minimumColumnWidth) {
        this.minimumColumnWidth = minimumColumnWidth;
    }
}
