package net.steppschuh.markdowngenerator.text;

public class StrikeThroughText extends Text {

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
