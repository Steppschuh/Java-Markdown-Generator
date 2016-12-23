package net.steppschuh.markdowngenerator.text;

public class SubScript extends Text {

    public SubScript(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "~";
    }

}