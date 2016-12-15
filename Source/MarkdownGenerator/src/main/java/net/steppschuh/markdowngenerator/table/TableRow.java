package net.steppschuh.markdowngenerator.table;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;
import net.steppschuh.markdowngenerator.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class TableRow<T extends Object> extends MarkdownElement {

    private List<T> columns;

    public TableRow() {
        this.columns = new ArrayList<>();
    }

    public TableRow(List<T> columns) {
        this.columns = columns;
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        StringBuilder sb = new StringBuilder();
        for (Object item : columns) {
            if (item == null) {
                throw new MarkdownSerializationException("Column is null");
            }
            if (item.toString().contains(Table.SEPERATOR)) {
                throw new MarkdownSerializationException("Column contains seperator char \"" + Table.SEPERATOR + "\"");
            }
            sb.append(Table.SEPERATOR);
            sb.append(StringUtil.surroundValueWith(item.toString(), " "));
            if (columns.indexOf(item) == columns.size() - 1) {
                sb.append(Table.SEPERATOR);
            }
        }
        return sb.toString();
    }

    public List<T> getColumns() {
        return columns;
    }

    public void setColumns(List<T> columns) {
        this.columns = columns;
        invalidateSerialized();
    }

}
