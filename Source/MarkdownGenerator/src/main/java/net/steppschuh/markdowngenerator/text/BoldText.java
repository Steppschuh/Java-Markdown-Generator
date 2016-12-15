package net.steppschuh.markdowngenerator.text;

public class BoldText extends TextFormatter {

    public BoldText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "**";
    }

    @Override
    public String getSuccessor() {
        return getPredecessor();
    }

}
