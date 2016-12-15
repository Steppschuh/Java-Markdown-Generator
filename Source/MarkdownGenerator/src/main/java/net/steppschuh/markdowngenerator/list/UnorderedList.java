package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.MarkdownElement;

import java.util.ArrayList;
import java.util.List;

public class UnorderedList extends MarkdownElement {

    private List<Object> items;

    public UnorderedList() {
        this.items = new ArrayList<>();
    }

    public UnorderedList(List<Object> items) {
        this.items = items;
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        for (Object item : items) {
            if (item instanceof UnorderedListItem) {
                sb.append(item);
            } else {
                sb.append(new UnorderedListItem(item));
            }
            if (items.indexOf(item) < items.size() - 1) {
                sb.append("\n");
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
