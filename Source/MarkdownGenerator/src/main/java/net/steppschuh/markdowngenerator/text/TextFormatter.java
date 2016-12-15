package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;

public abstract class TextFormatter extends MarkdownElement {

    final String predecessor = getPredecessor();
    final String successor = getSuccessor();

    Object value;

    public TextFormatter(Object value) {
        this.value = value;
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        if (value == null) {
            throw new MarkdownSerializationException("Value is null");
        }
        return predecessor + value.toString() + successor;
    }

    protected String getPredecessor() {
        return "";
    }

    protected String getSuccessor() {
        return "";
    }

}
