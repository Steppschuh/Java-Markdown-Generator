package net.steppschuh.markdowngenerator.text;

public class SuperScript extends Text {

    public SuperScript(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "^";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}