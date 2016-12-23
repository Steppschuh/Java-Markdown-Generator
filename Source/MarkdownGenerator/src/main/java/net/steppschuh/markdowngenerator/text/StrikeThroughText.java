package net.steppschuh.markdowngenerator.text;

public class StrikeThroughText extends Text {

    public StrikeThroughText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "~~";
    }

}
