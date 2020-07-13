package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.list.UnorderedList;

import java.util.List;

public class OrderedList extends UnorderedList<OrderedListItem> {

    private int elementCount;

    public OrderedList() {
        elementCount = 0;
    }

    public OrderedList(List<OrderedListItem> items) {
        super(items);
        items.forEach(i -> i.setIndex(++elementCount));
    }

    @Override public void setItems(List<OrderedListItem> items) {
        super.setItems(items);
        elementCount = items.size();
    }

    public OrderedList add(OrderedListItem item) {
        item.setIndex(++elementCount);
        getItems().add(item);
        return this;
    }

}
