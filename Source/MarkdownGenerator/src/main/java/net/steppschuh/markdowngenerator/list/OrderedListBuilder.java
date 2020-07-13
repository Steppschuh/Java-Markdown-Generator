package net.steppschuh.markdowngenerator.list;

public class OrderedListBuilder extends ListBuilder {

    @Override protected UnorderedList createMarkdownElement() {
        return new OrderedList();
    }
}
