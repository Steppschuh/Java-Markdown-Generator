package net.steppschuh.markdowngenerator.text;

public class StrikeThroughText extends TextFormatter {

    public StrikeThroughText(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "~~";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}
