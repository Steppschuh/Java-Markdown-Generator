package net.steppschuh.markdowngenerator.text;

public class BoldText extends Text {

    public BoldText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "**";
    }

}
