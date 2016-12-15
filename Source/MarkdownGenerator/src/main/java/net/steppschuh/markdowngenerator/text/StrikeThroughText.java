package net.steppschuh.markdowngenerator.text;

public class StrikeThroughText extends TextFormatter {

    public StrikeThroughText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "~~";
    }

    @Override
    public String getSuccessor() {
        return getPredecessor();
    }

}
