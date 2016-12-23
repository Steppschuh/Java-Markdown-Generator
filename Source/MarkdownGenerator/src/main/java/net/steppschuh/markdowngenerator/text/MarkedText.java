package net.steppschuh.markdowngenerator.text;

public class MarkedText extends Text {

    public MarkedText(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "==";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}