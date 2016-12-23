package net.steppschuh.markdowngenerator.text;

public class MarkedText extends Text {

    public MarkedText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "==";
    }

}