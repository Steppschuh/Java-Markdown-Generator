package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;

public class Text extends MarkdownElement {

    Object value;

    public Text(Object value) {
        this.value = value;
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        if (value == null) {
            throw new MarkdownSerializationException("Value is null");
        }
        return getPredecessor() + value.toString() + getSuccessor();
    }

    protected String getPredecessor() {
        return "";
    }

    protected String getSuccessor() {
        return getPredecessor();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
        invalidateSerialized();
    }

}
