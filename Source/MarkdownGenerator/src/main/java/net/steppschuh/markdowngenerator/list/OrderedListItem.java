package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.list.UnorderedListItem;

public class OrderedListItem extends UnorderedListItem {

    private int index = 1;

    public OrderedListItem(Object value) {
        super(value);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override public String getPredecessor() {
        return index + ". ";
    }
}
