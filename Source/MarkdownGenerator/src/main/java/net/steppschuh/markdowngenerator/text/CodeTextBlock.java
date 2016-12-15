package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.MarkdownSerializationException;

public class CodeTextBlock extends TextFormatter {

    String language;

    public CodeTextBlock(Object value) {
        this(value, "");
    }

    public CodeTextBlock(Object value, String language) {
        super(value);
        this.language = language;
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        if (value == null) {
            throw new MarkdownSerializationException("Value is null");
        }
        return predecessor + language + "\n" + value.toString() + "\n" + successor;
    }

    @Override
    protected String getPredecessor() {
        return "```";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}
