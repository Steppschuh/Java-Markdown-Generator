package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.MarkdownSerializable;

public class OrderedListBuilder extends ListBuilder {

    protected OrderedList list;

    @Override protected OrderedList createMarkdownElement() {
        return list = new OrderedList();
    }

    @Override protected OrderedListBuilder getBuilder() {
        return (OrderedListBuilder) super.getBuilder();
    }

    @Override public OrderedListBuilder append(Object value) {
        list.add(new OrderedListItem(value));
        return this;
    }

    @Override public OrderedListBuilder append(MarkdownSerializable value) {
        list.add(new OrderedListItem(value));
        return this;
    }

    @Override public OrderedList build() {
        return (OrderedList) super.build();
    }
}
