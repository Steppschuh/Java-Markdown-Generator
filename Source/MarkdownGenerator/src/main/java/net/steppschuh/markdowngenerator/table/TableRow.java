package net.steppschuh.markdowngenerator.table;

import net.steppschuh.markdowngenerator.MarkdownElement;

import java.util.ArrayList;
import java.util.List;

public class TableRow extends MarkdownElement {

    List<Object> items;

    public TableRow() {
        this.items = new ArrayList<>();
    }

    public TableRow(List<Object> items) {
        this.items = items;
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        for (Object item : items) {
            sb.append(Table.SEPERATOR);
            sb.append(Table.surroundValueWith(item.toString(), " "));
            if (items.indexOf(item) == items.size() - 1) {
                sb.append(Table.SEPERATOR);
            }
        }
        return sb.toString();
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

}
