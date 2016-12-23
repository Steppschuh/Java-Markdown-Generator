package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;

import java.util.ArrayList;
import java.util.List;

public class UnorderedList<T extends Object> extends MarkdownElement {

    protected List<T> items;

    public UnorderedList() {
        this.items = new ArrayList<>();
    }

    public UnorderedList(List<T> items) {
        this.items = items;
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
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

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        invalidateSerialized();
    }

}
