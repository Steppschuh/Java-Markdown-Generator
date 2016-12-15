package net.steppschuh.markdowngenerator.list;

import net.steppschuh.markdowngenerator.text.Text;

public class UnorderedListItem extends Text {

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
