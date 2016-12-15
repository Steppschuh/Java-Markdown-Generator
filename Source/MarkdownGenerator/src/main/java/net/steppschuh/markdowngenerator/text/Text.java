package net.steppschuh.markdowngenerator.text;

public class Text extends TextFormatter {

    public Text(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}
