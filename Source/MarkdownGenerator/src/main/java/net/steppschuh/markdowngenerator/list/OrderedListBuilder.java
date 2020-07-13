package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.MarkdownBuilder;

public class OrderedListBuilder extends ListBuilder {

    @Override protected UnorderedList createMarkdownElement() {
        return new OrderedList();
    }

    /**
     * Returns the root {@link MarkdownBuilder#markdownElement}
     *
     * @return {@link MarkdownBuilder#markdownElement}
     */
    @Override public OrderedList build() {
        return (OrderedList) super.build();
    }
}
