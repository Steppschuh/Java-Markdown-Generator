package net.steppschuh.markdowngenerator.text;

public class NormalText extends TextFormatter {

    public NormalText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "";
    }

    @Override
    public String getSuccessor() {
        return getPredecessor();
    }

}
