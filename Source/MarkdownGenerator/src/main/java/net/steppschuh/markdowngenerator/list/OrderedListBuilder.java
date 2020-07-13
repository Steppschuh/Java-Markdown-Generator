package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.MarkdownBuilder;
import net.steppschuh.markdowngenerator.MarkdownSerializable;

public class OrderedListBuilder extends ListBuilder {

    @Override protected OrderedList createMarkdownElement() {
        return new OrderedList();
    }

    @Override protected OrderedListBuilder getBuilder() {
        return (OrderedListBuilder) super.getBuilder();
    }

    @Override public OrderedListBuilder append(Object value) {
        return (OrderedListBuilder) super.append(value);
    }

    @Override public OrderedListBuilder append(MarkdownSerializable value) {
        return (OrderedListBuilder) super.append(value);
    }

    @Override public OrderedList build() {
        return (OrderedList) super.build();
    }
}
