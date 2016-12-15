package net.steppschuh.markdowngenerator.text;

public class ItalicText extends TextFormatter {

    public ItalicText(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "_";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}
