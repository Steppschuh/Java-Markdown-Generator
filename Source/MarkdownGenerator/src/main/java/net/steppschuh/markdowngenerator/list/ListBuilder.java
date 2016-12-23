package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.MarkdownBuilder;

/**
 * Created by steppschuh on 23/12/2016.
 */

public class ListBuilder extends MarkdownBuilder<ListBuilder, UnorderedList> {

    public ListBuilder() {
        super();
    }

    public ListBuilder(MarkdownBuilder parentBuilder) {
        super(parentBuilder);
    }

    @Override
    protected ListBuilder getBuilder() {
        return this;
    }

    @Override
    protected UnorderedList createMarkdownElement() {
        return new UnorderedList();
    }

    @Override
    public ListBuilder append(Object value) {
        markdownElement.getItems().add(value);
        return this;
    }

}
