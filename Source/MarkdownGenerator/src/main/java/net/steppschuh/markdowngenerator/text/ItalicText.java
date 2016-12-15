package net.steppschuh.markdowngenerator.text;

public class ItalicText extends TextFormatter {

    public ItalicText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "_";
    }

    @Override
    public String getSuccessor() {
        return getPredecessor();
    }

}
