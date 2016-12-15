package net.steppschuh.markdowngenerator.text;

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
    public String serialize() {
        return predecessor + language + "\n" + value.toString() + successor;
    }

    @Override
    public String getPredecessor() {
        return "```";
    }

    @Override
    public String getSuccessor() {
        return "\n```";
    }

}
