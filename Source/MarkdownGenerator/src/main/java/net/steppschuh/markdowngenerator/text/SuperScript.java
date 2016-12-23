package net.steppschuh.markdowngenerator.text;

public class SuperScript extends Text {

    public SuperScript(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "^";
    }

}