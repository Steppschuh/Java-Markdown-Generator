package net.steppschuh.markdowngenerator.text;

public class BoldText extends TextFormatter {

    public BoldText(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "**";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}
