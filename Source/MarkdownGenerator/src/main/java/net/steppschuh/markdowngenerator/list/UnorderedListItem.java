package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.text.TextFormatter;

public class UnorderedListItem extends TextFormatter {

    public UnorderedListItem(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "- ";
    }

    @Override
    public String getSuccessor() {
        return "";
    }

}
