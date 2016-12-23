package net.steppschuh.markdowngenerator.text;

public class SubScript extends Text {

    public SubScript(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "~";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}